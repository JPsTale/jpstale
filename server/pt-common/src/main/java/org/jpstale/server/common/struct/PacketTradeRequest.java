package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTradeRequest : Packet。
 */

@Data
public class PacketTradeRequest extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int type;  // int iType  size: 4 bytes
    private int senderId;  // int iSenderID  size: 4 bytes
    private int receiverId;  // int iReceiverID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        type = in.getInt();
        senderId = in.getInt();
        receiverId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type);
        out.putInt(senderId);
        out.putInt(receiverId);
    }
}
