package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdateClanLevel : Packet。
 */

@Data
public class PacketUpdateClanLevel extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int level;  // DWORD dwLevel  size: 4 bytes
    private int codeOp;  // DWORD dwCodeOP  size: 4 bytes
    private int clanCode;  // DWORD dwClanCode  size: 4 bytes
    private int updateInfo;  // DWORD dwUpdateInfo  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        level = in.getInt();
        codeOp = in.getInt();
        clanCode = in.getInt();
        updateInfo = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(level);
        out.putInt(codeOp);
        out.putInt(clanCode);
        out.putInt(updateInfo);
    }
}
