package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTransCommandEx : Packet。
 */

@Data
public class PacketTransCommandEx extends Packet {

    private int lparam;  // int LParam
    private int wParam;  // int WParam
    private int sParam;  // int SParam
    private int eParam;  // int EParam
    private int lxParam;  // int LxParam
    private int wxParam;  // int WxParam
    private int sxParam;  // int SxParam
    private int exParam;  // int ExParam

    @Override
    protected void readBody(ByteBuffer in) {
        lparam = in.getInt();
        wParam = in.getInt();
        sParam = in.getInt();
        eParam = in.getInt();
        lxParam = in.getInt();
        wxParam = in.getInt();
        sxParam = in.getInt();
        exParam = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(lparam);
        out.putInt(wParam);
        out.putInt(sParam);
        out.putInt(eParam);
        out.putInt(lxParam);
        out.putInt(wxParam);
        out.putInt(sxParam);
        out.putInt(exParam);
    }
}
