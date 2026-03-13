package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataGroupBot : Packet。
 */

@Data
public class PacketPlayDataGroupBot extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 171;

    private int playDataCount;  // int iPlayDataCount  size: 4 bytes
    private int sendCode;  // DWORD dwSendCode  size: 4 bytes
    private PacketPlayData playData;  // PacketPlayData sPlayData  size: 99 bytes
    private PlayBufferData playBuffData;  // PlayBufferData sPlayBuffData  size: 40 bytes
    private PacketItemShopBot packet;  // PacketItemShopBot sPacket  size: 24 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
