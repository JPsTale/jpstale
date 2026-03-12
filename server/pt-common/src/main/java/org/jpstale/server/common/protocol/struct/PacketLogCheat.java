package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLogCheat : Packet。
 */

@Data
public class PacketLogCheat extends Packet {

    private int lparam;  // int LParam
    private int cheatId;  // int iCheatID
    private int sParam;  // int SParam
    private int eParam;  // int EParam
    private int lxParam;  // int LxParam
    private int wxParam;  // int WxParam
    private int sxParam;  // int SxParam
    private int exParam;  // int ExParam
    private String buffer1;  // char szBuffer1[256]
    private String buffer2;  // char szBuffer2[32]

    @Override
    protected void readBody(ByteBuffer in) {
        lparam = in.getInt();
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
        out.putInt(lparam);
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
