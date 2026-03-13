package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.Point3D;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAttackData : Packet。
 */

@Data
public class PacketAttackData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private int destObjectSerial;  // DWORD dwDestObjectSerial  size: 4 bytes
    private int tarObjectSerial;  // DWORD dwTarObjectSerial  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private int range;  // int iRange  size: 4 bytes
    private int damage;  // int iDamage  size: 4 bytes
    private int chkSum;  // DWORD dwChkSum  size: 4 bytes
    private short[] rating = new short[2];  // short sRating[2]  size: 4 bytes
    private int damageChkSum;  // DWORD dwDamageChkSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        destObjectSerial = in.getInt();
        tarObjectSerial = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        range = in.getInt();
        damage = in.getInt();
        chkSum = in.getInt();
        for (int i = 0; i < rating.length; i++) { rating[i] = in.getShort(); }
        damageChkSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(destObjectSerial);
        out.putInt(tarObjectSerial);
        if (position != null) position.writeTo(out);
        out.putInt(range);
        out.putInt(damage);
        out.putInt(chkSum);
        for (int i = 0; i < rating.length; i++) { out.putShort(rating[i]); }
        out.putInt(damageChkSum);
    }
}
