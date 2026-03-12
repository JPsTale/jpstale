package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTransCommand : Packet。
 */

@Data
public class PacketTransCommand extends Packet {

    private int lparam;  // int LParam
    private int wParam;  // int WParam
    private int sParam;  // int SParam
    private int eParam;  // int EParam

    @Override
    protected void readBody(ByteBuffer in) {
        lparam = in.getInt();
        wParam = in.getInt();
        sParam = in.getInt();
        eParam = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(lparam);
        out.putInt(wParam);
        out.putInt(sParam);
        out.putInt(eParam);
    }
}
