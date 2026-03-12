package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPersonalShopMessageEffect : Packet。
 */

@Data
public class PacketPersonalShopMessageEffect extends Packet {

    private int msgcode;  // DWORD dwMSGCode
    private int colorBlink;  // int ColorBlink
    private short[] colors = new short[4];  // short sColors[4]
    private int dispEffect;  // DWORD DispEffect
    private int blinkScale;  // DWORD BlinkScale

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
