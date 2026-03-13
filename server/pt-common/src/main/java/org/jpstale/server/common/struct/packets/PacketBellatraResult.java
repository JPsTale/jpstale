package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraResult : Packet。
 */

@Data
public class PacketBellatraResult extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 208;

    private int unk;  // int iUnk  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private boolean show;  // BOOL bShow  size: 4 bytes
    private short[] teamRound = new short[2];  // short saTeamRound[2]  size: 4 bytes
    private int[] dwUnk = new int[15];  // DWORD dwUnk[15]  size: 60 bytes
    private int resultCount;  // int iResultCount  size: 4 bytes
    private int[] result = new int[32];  // BellatraResult saResult[32]  size: 128 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        time = in.getInt();
        show = in.getInt() != 0;
        for (int i = 0; i < teamRound.length; i++) { teamRound[i] = in.getShort(); }
        for (int i = 0; i < dwUnk.length; i++) { dwUnk[i] = in.getInt(); }
        resultCount = in.getInt();
        for (int i = 0; i < result.length; i++) { result[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(time);
        out.putInt(show ? 1 : 0);
        for (int i = 0; i < teamRound.length; i++) { out.putShort(teamRound[i]); }
        for (int i = 0; i < dwUnk.length; i++) { out.putInt(dwUnk[i]); }
        out.putInt(resultCount);
        for (int i = 0; i < result.length; i++) { out.putInt(result[i]); }
    }
}
