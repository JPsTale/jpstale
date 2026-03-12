package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetTradeCoin : Packet。
 */

@Data
public class PacketNetTradeCoin extends Packet {

    private int id;  // int iID
    private int receiverId;  // int iReceiverID

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        receiverId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(receiverId);
    }
}
