package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdateClanLevel : Packet。
 */

@Data
public class PacketUpdateClanLevel extends Packet {

    private int level;  // DWORD dwLevel
    private int codeOp;  // DWORD dwCodeOP
    private int clanCode;  // DWORD dwClanCode
    private int updateInfo;  // DWORD dwUpdateInfo

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
