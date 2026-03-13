package org.jpstale.server.login.core;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.packets.PacketCharacterDataEx;
import org.jpstale.server.common.struct.packets.PacketCreateCharacter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java 版 CharacterServer（登录服侧）。
 *
 * 主要逻辑来源：
 * - Server/server/characterserver.cpp
 * - Server/server/packetserver.cpp 中：
 *   - case PKTHDR_CharacterDataEx:
 *   - case PKTHDR_CreateCharacter:
 */
@Component
public class CharacterServer {

    private static final Logger log = LoggerFactory.getLogger(CharacterServer.class);

    /**
     * 对应 C++:
     *   CHARACTERSERVER->HandlePacket(User* pcUser, PacketCharacterDataEx* psPacket)
     *
     * 登录服用于处理角色数据扩展（保存/加载角色信息）。
     */
    public void handleCharacterDataEx(ChannelHandlerContext ctx, PacketCharacterDataEx packet) {
        // TODO: 按照 characterserver.cpp 中逻辑更新 / 读取角色信息并回包。
        log.trace("handleCharacterDataEx (TODO) packet={}", packet);
    }

    /**
     * 对应 C++:
     *   CHARACTERSERVER->CharacterCreate(User* pcUser, PacketCreateCharacter* psPacket)
     *
     * 登录服处理创建新角色。
     */
    public void createCharacter(ChannelHandlerContext ctx, PacketCreateCharacter packet) {
        // TODO: 校验名字/职业/位置，写入数据库后回包结果。
        log.trace("createCharacter (TODO) packet={}", packet);
    }
}

