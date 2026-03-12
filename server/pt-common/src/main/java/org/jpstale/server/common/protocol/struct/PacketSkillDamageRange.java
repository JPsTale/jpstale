package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.AttackProperty;
import org.jpstale.server.common.enums.AttackState;


/**
 * 对应 packets.h 中 struct PacketSkillDamageRange : Packet。
 */

@Data
public class PacketSkillDamageRange extends Packet {

    private int targetReceiveDamageId;  // int iTargetReceiveDamageID
    private Point3D position;  // Point3D sPosition
    private AttackState attackState;  // EAttackState eAttackState
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty
    private int range;  // int iRange
    private int damage;  // int iDamage
    private int chkSum;  // DWORD dwChkSum
    private int count;  // int iCount
    private int[] targetId = new int[128];  // int iaTargetID[128]

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
