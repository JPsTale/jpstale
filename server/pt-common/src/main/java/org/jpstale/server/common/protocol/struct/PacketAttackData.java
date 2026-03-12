package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAttackData : Packet。
 */

@Data
public class PacketAttackData extends Packet {

    private int destObjectSerial;  // DWORD dwDestObjectSerial
    private int tarObjectSerial;  // DWORD dwTarObjectSerial
    private Point3D position;  // Point3D sPosition
    private int range;  // int iRange
    private int damage;  // int iDamage
    private int chkSum;  // DWORD dwChkSum
    private short[] rating = new short[2];  // short sRating[2]
    private int damageChkSum;  // DWORD dwDamageChkSum

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
