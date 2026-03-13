package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PartyUserData（队伍成员详情：名/模型/头/HP 等）。
 */
@Data
public final class PartyUserData {
    public static final int SIZE_OF = 196;

    private String name;    // char szName[32]
    private String model;  // char szModel[64]
    private String head;   // char szHead[64]
    private int objectId;  // DWORD dwObjectID
    private int level;     // int iLevel
    private CurMax hp;      // CurMax sHP
    private int jobCode;   // int iJobCode
    private int gold;      // int iGold
    private int x;         // int iX
    private int z;         // int iZ

    public void readFrom(ByteBuffer in) {
        name = Packet.readCString(in, 32);
        model = Packet.readCString(in, 64);
        head = Packet.readCString(in, 64);
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
        Packet.writeCString(out, name, 32);
        Packet.writeCString(out, model, 64);
        Packet.writeCString(out, head, 64);
        out.putInt(objectId);
        out.putInt(level);
        if (hp != null) hp.writeTo(out);
        out.putInt(jobCode);
        out.putInt(gold);
        out.putInt(x);
        out.putInt(z);
    }
}
