package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PartyUserInfo（队伍成员简要：ObjectID/等级/HP 等）。
 */
@Data
public final class PartyUserInfo {
    public static final int SIZE_OF = 28;

    private int objectId;  // DWORD dwObjectID
    private int level;     // int iLevel
    private CurMax hp;      // CurMax sHP
    private int jobCode;   // int iJobCode
    private int gold;      // int iGold
    private int x;         // int iX
    private int z;         // int iZ

    public void readFrom(ByteBuffer in) {
        objectId = in.getInt();
        level = in.getInt();
        if (hp == null) hp = new CurMax();
        hp.readFrom(in);
        jobCode = in.getInt();
        gold = in.getInt();
        x = in.getInt();
        z = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(level);
        if (hp != null) hp.writeTo(out);
        out.putInt(jobCode);
        out.putInt(gold);
        out.putInt(x);
        out.putInt(z);
    }
}
