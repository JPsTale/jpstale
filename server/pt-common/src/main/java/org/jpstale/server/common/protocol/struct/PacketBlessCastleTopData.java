package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopData : Packet。
 */

@Data
public class PacketBlessCastleTopData extends Packet {

    private int tCode;  // int tCode
    private int objectSerial;  // DWORD dwObjectSerial
    private int nameCode;  // DWORD dwNameCode
    private Point3D position;  // Point3D sPosition
    private int charCode;  // DWORD dwCharCode
    private int updateTime;  // DWORD dwUpdateTime
    private int totalDamage;  // DWORD dwTotalDamage
    private final byte[] crystalTowerCount = new byte[4];  // BYTE baCrystalTowerCount[4]
    private int[] free = new int[2];  // DWORD dwFree[2]
    private int[] damage = new int[10];  // int iaDamage[10]
    private int[] counter = new int[10];  // int iaCounter[10]

    @Override
    protected void readBody(ByteBuffer in) {
        tCode = in.getInt();
        objectSerial = in.getInt();
        nameCode = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        charCode = in.getInt();
        updateTime = in.getInt();
        totalDamage = in.getInt();
        in.get(crystalTowerCount);
        for (int i = 0; i < free.length; i++) { free[i] = in.getInt(); }
        for (int i = 0; i < damage.length; i++) { damage[i] = in.getInt(); }
        for (int i = 0; i < counter.length; i++) { counter[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(tCode);
        out.putInt(objectSerial);
        out.putInt(nameCode);
        if (position != null) position.writeTo(out);
        out.putInt(charCode);
        out.putInt(updateTime);
        out.putInt(totalDamage);
        out.put(crystalTowerCount);
        for (int i = 0; i < free.length; i++) { out.putInt(free[i]); }
        for (int i = 0; i < damage.length; i++) { out.putInt(damage[i]); }
        for (int i = 0; i < counter.length; i++) { out.putInt(counter[i]); }
    }
}
