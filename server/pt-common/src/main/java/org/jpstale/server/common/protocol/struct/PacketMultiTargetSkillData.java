package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.AttackProperty;
import org.jpstale.server.common.enums.AttackState;


/**
 * 对应 packets.h 中 struct PacketMultiTargetSkillData : Packet。
 */

@Data
public class PacketMultiTargetSkillData extends Packet {

    private int targetReceiveDamageId;  // int iTargetReceiveDamageID
    private int chkSum;  // DWORD dwChkSum
    private Point3D position;  // Point3D sPosition
    private int damageState;  // int iDamageState
    private int range;  // int iRange
    private MinMax attackPower;  // MinMax sAttackPower
    private short[] weaponAttackPower = new short[2];  // short WeaponAttackPower[2]
    private short criticalChance;  // short sCriticalChance
    private short criticalDmgBoost;  // short sCriticalDmgBoost
    private int skillId;  // int iSkillID
    private int time;  // DWORD dwTime
    private int damageCount;  // int iDamageCount
    private short[] motionCount = new short[2];  // short MotionCount[2]
    private int weaponCode;  // DWORD dwWeaponCode
    private short mapId;  // short sMapID
    private AttackProperty secondaryAttackProperty;  // EAttackProperty eSecondaryAttackProperty
    private AttackState secondaryAttackState;  // EAttackState eSecondaryAttackState
    private short attackRange;  // short sAttackRange
    private short attackRating;  // short sAttackRating
    private short primaryStats;  // short sPrimaryStats
    private int targetId;  // ID iTargetID
    private int targetCount;  // int iTargetCount
    private int[] iaTargetID = new int[128];  // int iaTargetID[128]

    @Override
    protected void readBody(ByteBuffer in) {
        targetReceiveDamageId = in.getInt();
        chkSum = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        damageState = in.getInt();
        range = in.getInt();
        if (attackPower == null) attackPower = new MinMax(); attackPower.readFrom(in);
        for (int i = 0; i < weaponAttackPower.length; i++) { weaponAttackPower[i] = in.getShort(); }
        criticalChance = in.getShort();
        criticalDmgBoost = in.getShort();
        skillId = in.getInt();
        time = in.getInt();
        damageCount = in.getInt();
        for (int i = 0; i < motionCount.length; i++) { motionCount[i] = in.getShort(); }
        weaponCode = in.getInt();
        mapId = in.getShort();
        secondaryAttackProperty = AttackProperty.fromValue((int) in.getShort());
        secondaryAttackState = AttackState.fromValue((int) in.getShort());
        attackRange = in.getShort();
        attackRating = in.getShort();
        primaryStats = in.getShort();
        targetId = in.getInt();
        targetCount = in.getInt();
        for (int i = 0; i < iaTargetID.length; i++) { iaTargetID[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(targetReceiveDamageId);
        out.putInt(chkSum);
        if (position != null) position.writeTo(out);
        out.putInt(damageState);
        out.putInt(range);
        if (attackPower != null) attackPower.writeTo(out);
        for (int i = 0; i < weaponAttackPower.length; i++) { out.putShort(weaponAttackPower[i]); }
        out.putShort(criticalChance);
        out.putShort(criticalDmgBoost);
        out.putInt(skillId);
        out.putInt(time);
        out.putInt(damageCount);
        for (int i = 0; i < motionCount.length; i++) { out.putShort(motionCount[i]); }
        out.putInt(weaponCode);
        out.putShort(mapId);
        out.putShort((short) secondaryAttackProperty.getValue());
        out.putShort((short) secondaryAttackState.getValue());
        out.putShort(attackRange);
        out.putShort(attackRating);
        out.putShort(primaryStats);
        out.putInt(targetId);
        out.putInt(targetCount);
        for (int i = 0; i < iaTargetID.length; i++) { out.putInt(iaTargetID[i]); }
    }
}
