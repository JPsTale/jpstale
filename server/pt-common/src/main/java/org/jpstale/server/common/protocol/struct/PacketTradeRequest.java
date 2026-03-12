package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTradeRequest : Packet。
 */

@Data
public class PacketTradeRequest extends Packet {

    private int type;  // int iType
    private int senderId;  // int iSenderID
    private int receiverId;  // int iReceiverID

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
