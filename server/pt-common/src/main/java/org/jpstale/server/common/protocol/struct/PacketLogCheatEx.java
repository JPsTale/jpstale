package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLogCheatEx : Packet。
 */

@Data
public class PacketLogCheatEx extends Packet {

    private int lparam;  // int LParam
    private int cheatId;  // int iCheatID
    private int sParam;  // int SParam
    private int eParam;  // int EParam
    private int lxParam;  // int LxParam
    private int wxParam;  // int WxParam
    private int sxParam;  // int SxParam
    private int exParam;  // int ExParam
    private String szParam;  // char szParam[256]

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
        szParam = readCString(in, 256);
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
        writeCString(out, szParam, 256);
    }
}
