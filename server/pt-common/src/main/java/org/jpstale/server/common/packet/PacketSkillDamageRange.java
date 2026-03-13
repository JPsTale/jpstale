package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.AttackProperty;
import org.jpstale.server.common.enums.packets.AttackState;


/**
 * 对应 packets.h 中 struct PacketSkillDamageRange : Packet。
 */

@Data
public class PacketSkillDamageRange extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 548;

    private int targetReceiveDamageId;  // int iTargetReceiveDamageID  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private AttackState attackState;  // EAttackState eAttackState  size: 2 bytes
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty  size: 2 bytes
    private int range;  // int iRange  size: 4 bytes
    private int damage;  // int iDamage  size: 4 bytes
    private int chkSum;  // DWORD dwChkSum  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private int[] targetId = new int[128];  // int iaTargetID[128]  size: 512 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        targetReceiveDamageId = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        attackState = AttackState.fromValue((int) in.getShort());
        attackProperty = AttackProperty.fromValue((int) in.getShort());
        range = in.getInt();
        damage = in.getInt();
        chkSum = in.getInt();
        count = in.getInt();
        for (int i = 0; i < targetId.length; i++) { targetId[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(targetReceiveDamageId);
        if (position != null) position.writeTo(out);
        out.putShort((short) attackState.getValue());
        out.putShort((short) attackProperty.getValue());
        out.putInt(range);
        out.putInt(damage);
        out.putInt(chkSum);
        out.putInt(count);
        for (int i = 0; i < targetId.length; i++) { out.putInt(targetId[i]); }
    }
}
