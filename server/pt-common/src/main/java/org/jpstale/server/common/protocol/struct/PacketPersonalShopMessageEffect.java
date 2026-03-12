package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPersonalShopMessageEffect : Packet。
 */

@Data
public class PacketPersonalShopMessageEffect extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private int msgcode;  // DWORD dwMSGCode  size: 4 bytes
    private int colorBlink;  // int ColorBlink  size: 4 bytes
    private short[] colors = new short[4];  // short sColors[4]  size: 8 bytes
    private int dispEffect;  // DWORD DispEffect  size: 4 bytes
    private int blinkScale;  // DWORD BlinkScale  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        msgcode = in.getInt();
        colorBlink = in.getInt();
        for (int i = 0; i < colors.length; i++) { colors[i] = in.getShort(); }
        dispEffect = in.getInt();
        blinkScale = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(msgcode);
        out.putInt(colorBlink);
        for (int i = 0; i < colors.length; i++) { out.putShort(colors[i]); }
        out.putInt(dispEffect);
        out.putInt(blinkScale);
    }
}
