package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCoinBuy : Packet。
 */

@Data
public class PacketCoinBuy extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private int id;  // int iID  size: 4 bytes
    private int tabId;  // int iTabID  size: 4 bytes
    private int param1;  // int iParam1  size: 4 bytes
    private int param2;  // int iParam2  size: 4 bytes
    private int returnCode;  // int iReturnCode  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        tabId = in.getInt();
        param1 = in.getInt();
        param2 = in.getInt();
        returnCode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(tabId);
        out.putInt(param1);
        out.putInt(param2);
        out.putInt(returnCode);
    }
}
