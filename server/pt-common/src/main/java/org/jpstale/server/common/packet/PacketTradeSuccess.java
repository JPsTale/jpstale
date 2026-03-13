package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTradeSuccess : Packet。
 */

@Data
public class PacketTradeSuccess extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4028;

    private int senderId;  // int iSenderID  size: 4 bytes
    private int receiverId;  // int iReceiverID  size: 4 bytes
    private int checkSum;  // DWORD dwCheckSum  size: 4 bytes
    private int[] tempData = new int[4];  // DWORD dwaTempData[4]  size: 16 bytes
    private final byte[] data = new byte[4000];  // BYTE baData[4000]  size: 4000 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
