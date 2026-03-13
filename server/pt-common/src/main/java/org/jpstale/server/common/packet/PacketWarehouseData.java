package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWarehouseData : Packet。
 */

@Data
public class PacketWarehouseData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private int checkSum;  // DWORD dwCheckSum  size: 4 bytes
    private short page;  // WORD wPage  size: 2 bytes
    private short version;  // WORD wVersion  size: 2 bytes
    private int wareHouseMoney;  // int WareHouseMoney  size: 4 bytes
    private int userMoney;  // int UserMoney  size: 4 bytes
    private int[] temp = new int[5];  // DWORD dwTemp[5]  size: 20 bytes
    private int dataSize;  // int DataSize  size: 4 bytes
    private final byte[] data = new byte[0];  // BYTE Data[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        checkSum = in.getInt();
        page = in.getShort();
        version = in.getShort();
        wareHouseMoney = in.getInt();
        userMoney = in.getInt();
        for (int i = 0; i < temp.length; i++) { temp[i] = in.getInt(); }
        dataSize = in.getInt();
        in.get(data);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(checkSum);
        out.putShort(page);
        out.putShort(version);
        out.putInt(wareHouseMoney);
        out.putInt(userMoney);
        for (int i = 0; i < temp.length; i++) { out.putInt(temp[i]); }
        out.putInt(dataSize);
        out.put(data);
    }
}
