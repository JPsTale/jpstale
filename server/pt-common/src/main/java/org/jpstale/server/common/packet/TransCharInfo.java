package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct _TRANS_CHAR_INFO（角色简要：名称、模型、职业、等级、坐标等）。
 */
@Data
public final class TransCharInfo {
    public static final int SIZE_OF = 32 + 64 + 64 + 4 + 4 + 4 + 4 + 4 + 4 + 4 + 13 * 4; // 240

    private String name;           // char szName[32]
    private String modelName;     // char szModelName[64]
    private String modelName2;    // char szModelName2[64]
    private int jobCode;          // DWORD JobCode
    private int level;            // int iLevel
    private int brood;            // DWORD Brood
    private int armorCode;        // DWORD dwArmorCode
    private int startField;       // int StartField
    private int posX;             // int PosX
    private int posZ;             // int PosZ
    private final int[] temp = new int[13];  // DWORD dwTemp[13]

    public void readFrom(ByteBuffer in) {
        name = Packet.readCString(in, 32);
        modelName = Packet.readCString(in, 64);
        modelName2 = Packet.readCString(in, 64);
        jobCode = in.getInt();
        level = in.getInt();
        brood = in.getInt();
        armorCode = in.getInt();
        startField = in.getInt();
        posX = in.getInt();
        posZ = in.getInt();
        for (int i = 0; i < temp.length; i++) temp[i] = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, name, 32);
        Packet.writeCString(out, modelName, 64);
        Packet.writeCString(out, modelName2, 64);
        out.putInt(jobCode);
        out.putInt(level);
        out.putInt(brood);
        out.putInt(armorCode);
        out.putInt(startField);
        out.putInt(posX);
        out.putInt(posZ);
        for (int t : temp) out.putInt(t);
    }
}
