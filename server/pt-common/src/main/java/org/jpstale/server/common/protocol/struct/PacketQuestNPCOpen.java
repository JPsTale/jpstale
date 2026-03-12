package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestNPCOpen : Packet。
 */

@Data
public class PacketQuestNPCOpen extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2124;

    private int id;  // int iID  size: 4 bytes
    private int type;  // int iType  size: 4 bytes
    private int autoItemRewardId;  // int iAutoItemRewardId  size: 4 bytes
    private String name;  // char szName[64]  size: 64 bytes
    private String message;  // char szMessage[2048]  size: 2048 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        type = in.getInt();
        autoItemRewardId = in.getInt();
        name = readCString(in, 64);
        message = readCString(in, 2048);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(type);
        out.putInt(autoItemRewardId);
        writeCString(out, name, 64);
        writeCString(out, message, 2048);
    }
}
