package org.jpstale.server.login.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.jpstale.server.common.enums.packets.PacketHeader;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.struct.packets.*;
import org.jpstale.server.common.struct.socket.PacketPing;
import org.jpstale.server.login.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Java 版 PacketServer。
 *
 * 对应 C++ 侧的：
 * - Server/server/packetserver.cpp - class PacketServer
 * - 其中的 BOOL PacketServer::AnalyzePacket(User* pcUser, PacketReceiving* p)
 *
 * 该类直接作为 Netty 入站处理器使用，负责：
 * - 从 Netty ByteBuf 中解析出完整的 Packet
 * - 根据 iHeader 分发到各个 *Server 模块（AccountServer、CharacterServer 等）
 * - 统一的收发日志输出
 */
@Component
@ChannelHandler.Sharable
public class PacketServer extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger log = LoggerFactory.getLogger(PacketServer.class);

    private final AccountServer accountServer;
    private final PingServer pingServer;
    private final CharacterServer characterServer;
    private final CheatServer cheatServer;
    private final LogServer logServer;
    private final NetServer netServer;

    /**
     * 包头 -> 处理函数 的分发表。
     */
    private final Map<PacketHeader, BiConsumer<ChannelHandlerContext, ByteBuffer>> handlers = new HashMap<>();

    public PacketServer(AccountServer accountServer,
                        PingServer pingServer,
                        CharacterServer characterServer,
                        CheatServer cheatServer,
                        LogServer logServer,
                        NetServer netServer) {
        this.accountServer = accountServer;
        this.pingServer = pingServer;
        this.characterServer = characterServer;
        this.cheatServer = cheatServer;
        this.logServer = logServer;
        this.netServer = netServer;

        registerHandlers();
    }

    private void registerHandlers() {
        // 认证 / 心跳
        register(PacketHeader.PKTHDR_Ping, PacketPing::new, pingServer::handlePing);
        register(PacketHeader.PKTHDR_Version, PacketVersion::new, (ctx, p) -> logServer.onLogEx(ctx,null, p));
        register(PacketHeader.PKTHDR_LoginUser, PacketLoginUser::new, accountServer::processAccountLogin);
        register(PacketHeader.PKTHDR_Client_Error, PacketTransCommand::new, cheatServer::handleClientError);

        // 角色 / 存档
        register(PacketHeader.PKTHDR_CharacterDataEx, PacketCharacterDataEx::new, characterServer::handleCharacterDataEx);
        register(PacketHeader.PKTHDR_CreateCharacter, PacketCreateCharacter::new, characterServer::createCharacter);
        // TODO: SaveData 等登录服相关包可在后续补充

        // 崩溃 / 作弊日志
        register(PacketHeader.PKTHDR_Crash, PacketCrash::new, cheatServer::handleCrash);
        register(PacketHeader.PKTHDR_CrashData, PacketCrashData::new, cheatServer::handleCrashData);
        register(PacketHeader.PKTHDR_LogCheat, PacketLogCheat::new, (ctx, p) -> logServer.onLogCheat(null, p));

        // Inter-Server Net* 包（LoginServer 侧关心的子集）
        register(PacketHeader.PKTHDR_NetIdentifier, PacketNetIdentifier::new, (ctx, p) -> netServer.onNetIdentifier(p));
        register(PacketHeader.PKTHDR_NetUsersOnline, PacketNetUsersOnline::new,
                (ctx, p) -> netServer.onNetUsersOnline(p));
        register(PacketHeader.PKTHDR_NetClan, PacketNetClan::new, (ctx, p) -> netServer.onNetClan(p));
        register(PacketHeader.PKTHDR_NetQuestUpdateDataPart, PacketNetQuestUpdateDataPart::new,
                (ctx, p) -> netServer.onNetQuestUpdateDataPart(p));
        register(PacketHeader.PKTHDR_NetPlayerGoldDiff, PacketNetPlayerGoldDiff::new,
                (ctx, p) -> netServer.onNetPlayerGoldDiff(p));
        register(PacketHeader.PKTHDR_NetPlayerItemPut, PacketNetPlayerItemPut::new,
                (ctx, p) -> netServer.onNetPlayerItemPut(p));
        register(PacketHeader.PKTHDR_NetPlayerThrow, PacketNetPlayerThrow::new,
                (ctx, p) -> netServer.onNetPlayerThrow(p));

        // 尚未在 pt-common 定义结构体的 Net 包，先直接调用 handler 占位
        handlers.put(PacketHeader.PKTHDR_NetPlayDataEx, (ctx, buf) -> netServer.onNetPlayDataEx(null));
        handlers.put(PacketHeader.PKTHDR_NetGiveExp, (ctx, buf) -> netServer.onNetGiveExp(null));
    }

    private <P extends Packet> void register(PacketHeader header,
                                             Supplier<P> factory,
                                             BiConsumer<ChannelHandlerContext, P> handler) {
        handlers.put(header, (ctx, buf) -> readAndDispatch(ctx, buf, factory, handler));
    }

    private <P extends Packet> void readAndDispatch(ChannelHandlerContext ctx,
                                                    ByteBuffer buf,
                                                    Supplier<P> factory,
                                                    BiConsumer<ChannelHandlerContext, P> handler) {
        P packet = factory.get();
        packet.readFrom(buf);
        try {
            handler.accept(ctx, packet);
        } catch (Exception e) {
            log.error("process packet: {} failed", packet, e);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        int readable = msg.readableBytes();
        if (readable < Packet.SIZE_OF) {
            if (log.isTraceEnabled()) {
                log.trace("recv too short packet: {} bytes from {}", readable, ctx.channel().remoteAddress());
            }
            return;
        }

        byte[] arr = new byte[readable];
        msg.readBytes(arr);
        ByteBuffer buf = ByteBuffer.wrap(arr).order(ByteOrder.LITTLE_ENDIAN);

        // 跳过 length(2) + encKeyIndex(1) + encrypted(1)
        int pktHeader = buf.getInt(4);
        PacketHeader packetHeader = PacketHeader.fromValue(pktHeader);

        if (packetHeader != PacketHeader.PKTHDR_Version) {
            log.info("recv {}(0x{}), size:{}, from: {}", packetHeader, Integer.toHexString(pktHeader), readable, ctx.channel().remoteAddress());
        }
        analyzePacket(ctx, packetHeader, buf);
    }

    /**
     * Java 版 AnalyzePacket。
     *
     * 对应 C++: BOOL PacketServer::AnalyzePacket(User* pcUser, PacketReceiving* p).
     * 这里只实现与 LoginServer 直接相关的分发逻辑（PKTHDR_Ping / PKTHDR_LoginUser 等），
     * 其余包体在后续逐步按 C++ 对照补齐。
     */
    public void analyzePacket(ChannelHandlerContext ctx, PacketHeader pktHeader, ByteBuffer buf) {
        BiConsumer<ChannelHandlerContext, ByteBuffer> handler = handlers.get(pktHeader);
        if (handler != null) {
            handler.accept(ctx, buf);
        } else {
            log.info("unsupported packet header:{} from:{}", pktHeader, ctx.channel().remoteAddress());
        }
    }

    /**
     * 统一的发包入口。
     * 当前仅简单委托给 PacketSender，后续如需对齐 C++ PacketServer::Send 的调试输出，
     * 可以在这里扩展。
     */
    public void sendPacket(ChannelHandlerContext ctx, Packet packet) {
        PacketSender.sendPacket(ctx, packet);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.warn("channel error from {}: {}", ctx.channel().remoteAddress(), cause.getMessage());
        ctx.close();
    }
}

