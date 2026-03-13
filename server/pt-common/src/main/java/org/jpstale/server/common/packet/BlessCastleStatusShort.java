package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct BlessCastleStatusShort（祝福城堡状态短结构）。
 */
@Data
public class BlessCastleStatusShort {
    /** 5*4 + 6*4 + 3*4 = 56 bytes */
    public static final int SIZE_OF = 56;

    private int clanId1;    // int iClanID1
    private int clanId2;    // int iClanID2
    private int clanId3;    // int iClanID3
    private int tax;        // int iTax
    private int skill;      // int iSkill
    private int[] towerType = new int[6];   // int iaTowerType[6]
    private int[] guardAmount = new int[3]; // int iaGuardAmount[3]

    public void readFrom(ByteBuffer in) {
        clanId1 = in.getInt();
        clanId2 = in.getInt();
        clanId3 = in.getInt();
        tax = in.getInt();
        skill = in.getInt();
        for (int i = 0; i < towerType.length; i++) {
            towerType[i] = in.getInt();
        }
        for (int i = 0; i < guardAmount.length; i++) {
            guardAmount[i] = in.getInt();
        }
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(clanId1);
        out.putInt(clanId2);
        out.putInt(clanId3);
        out.putInt(tax);
        out.putInt(skill);
        for (int v : towerType) {
            out.putInt(v);
        }
        for (int v : guardAmount) {
            out.putInt(v);
        }
    }
}
