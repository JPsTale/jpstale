package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWarehouse : Packet。
 */

@Data
public class PacketWarehouse extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 28;

    private int userMoney;  // int UserMoney  size: 4 bytes
    private int whmode;  // DWORD dwWHMode  size: 4 bytes
    private int[] temp = new int[4];  // DWORD dwTemp[4]  size: 16 bytes
    private int dataLength;  // int iDataLength  size: 4 bytes
    private final byte[] data = new byte[0];  // BYTE baData[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userMoney = in.getInt();
        whmode = in.getInt();
        for (int i = 0; i < temp.length; i++) { temp[i] = in.getInt(); }
        dataLength = in.getInt();
        in.get(data);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userMoney);
        out.putInt(whmode);
        for (int i = 0; i < temp.length; i++) { out.putInt(temp[i]); }
        out.putInt(dataLength);
        out.put(data);
    }
}
