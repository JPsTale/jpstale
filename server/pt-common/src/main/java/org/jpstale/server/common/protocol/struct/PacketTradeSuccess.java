package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTradeSuccess : Packet。
 */

@Data
public class PacketTradeSuccess extends Packet {

    private int senderId;  // int iSenderID
    private int receiverId;  // int iReceiverID
    private int checkSum;  // DWORD dwCheckSum
    private int[] tempData = new int[4];  // DWORD dwaTempData[4]
    private final byte[] data = new byte[4000];  // BYTE baData[4000]

    @Override
    protected void readBody(ByteBuffer in) {
        senderId = in.getInt();
        receiverId = in.getInt();
        checkSum = in.getInt();
        for (int i = 0; i < tempData.length; i++) { tempData[i] = in.getInt(); }
        in.get(data);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(senderId);
        out.putInt(receiverId);
        out.putInt(checkSum);
        for (int i = 0; i < tempData.length; i++) { out.putInt(tempData[i]); }
        out.put(data);
    }
}
