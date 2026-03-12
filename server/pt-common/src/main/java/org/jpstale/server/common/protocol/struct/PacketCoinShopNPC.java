package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCoinShopNPC : Packet。
 */

@Data
public class PacketCoinShopNPC extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 176;

    private short packetNumber;  // short sPacketNumber  size: 2 bytes
    private short packetMax;  // short sPacketMax  size: 2 bytes
    private int id;  // int iID  size: 4 bytes
    private String name;  // char szName[32]  size: 32 bytes
    private String message;  // char szMessage[128]  size: 128 bytes
    private int discount;  // int iDiscount  size: 4 bytes
    private int tabs;  // int iTabs  size: 4 bytes
    private int[] aTabs = new int[0];  // Tab aTabs[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        packetNumber = in.getShort();
        packetMax = in.getShort();
        id = in.getInt();
        name = readCString(in, 32);
        message = readCString(in, 128);
        discount = in.getInt();
        tabs = in.getInt();
        for (int i = 0; i < aTabs.length; i++) { aTabs[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(packetNumber);
        out.putShort(packetMax);
        out.putInt(id);
        writeCString(out, name, 32);
        writeCString(out, message, 128);
        out.putInt(discount);
        out.putInt(tabs);
        for (int i = 0; i < aTabs.length; i++) { out.putInt(aTabs[i]); }
    }
}
