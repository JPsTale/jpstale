package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopData : Packet。
 */

@Data
public class PacketBlessCastleTopData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 128;

    private int tCode;  // int tCode  size: 4 bytes
    private int objectSerial;  // DWORD dwObjectSerial  size: 4 bytes
    private int nameCode;  // DWORD dwNameCode  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private int charCode;  // DWORD dwCharCode  size: 4 bytes
    private int updateTime;  // DWORD dwUpdateTime  size: 4 bytes
    private int totalDamage;  // DWORD dwTotalDamage  size: 4 bytes
    private final byte[] crystalTowerCount = new byte[4];  // BYTE baCrystalTowerCount[4]  size: 4 bytes
    private int[] free = new int[2];  // DWORD dwFree[2]  size: 8 bytes
    private int[] damage = new int[10];  // int iaDamage[10]  size: 40 bytes
    private int[] counter = new int[10];  // int iaCounter[10]  size: 40 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
