package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTransCommand : Packet。
 */

@Data
public class PacketTransCommand extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int lParam;  // int LParam  size: 4 bytes
    private int wParam;  // int WParam  size: 4 bytes
    private int sParam;  // int SParam  size: 4 bytes
    private int eParam;  // int EParam  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        lParam = in.getInt();
        wParam = in.getInt();
        sParam = in.getInt();
        eParam = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(lParam);
        out.putInt(wParam);
        out.putInt(sParam);
        out.putInt(eParam);
    }
}
