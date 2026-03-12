package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLogCheat : Packet。
 */

@Data
public class PacketLogCheat extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 320;

    private int lParam;  // int LParam  size: 4 bytes
    private int cheatId;  // int iCheatID  size: 4 bytes
    private int sParam;  // int SParam  size: 4 bytes
    private int eParam;  // int EParam  size: 4 bytes
    private int lxParam;  // int LxParam  size: 4 bytes
    private int wxParam;  // int WxParam  size: 4 bytes
    private int sxParam;  // int SxParam  size: 4 bytes
    private int exParam;  // int ExParam  size: 4 bytes
    private String buffer1;  // char szBuffer1[256]  size: 256 bytes
    private String buffer2;  // char szBuffer2[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        lParam = in.getInt();
        cheatId = in.getInt();
        sParam = in.getInt();
        eParam = in.getInt();
        lxParam = in.getInt();
        wxParam = in.getInt();
        sxParam = in.getInt();
        exParam = in.getInt();
        buffer1 = readCString(in, 256);
        buffer2 = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(lParam);
        out.putInt(cheatId);
        out.putInt(sParam);
        out.putInt(eParam);
        out.putInt(lxParam);
        out.putInt(wxParam);
        out.putInt(sxParam);
        out.putInt(exParam);
        writeCString(out, buffer1, 256);
        writeCString(out, buffer2, 32);
    }
}
