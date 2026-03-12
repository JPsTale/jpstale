package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataGroupBot : Packet。
 */

@Data
public class PacketPlayDataGroupBot extends Packet {

    private int playDataCount;  // int iPlayDataCount
    private int sendCode;  // DWORD dwSendCode
    private PacketPlayData playData;  // PacketPlayData sPlayData
    private PlayBufferData playBuffData;  // PlayBufferData sPlayBuffData
    private PacketItemShopBot packet;  // PacketItemShopBot sPacket

    @Override
    protected void readBody(ByteBuffer in) {
        playDataCount = in.getInt();
        sendCode = in.getInt();
        if (playData == null) playData = new PacketPlayData(); playData.readBody(in);
        if (playBuffData == null) playBuffData = new PlayBufferData(); playBuffData.readFrom(in);
        if (packet == null) packet = new PacketItemShopBot(); packet.readBody(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(playDataCount);
        out.putInt(sendCode);
        if (playData != null) playData.writeBody(out);
        if (playBuffData != null) playBuffData.writeTo(out);
        if (packet != null) packet.writeBody(out);
    }
}
