package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.AttackProperty;
import org.jpstale.server.common.enums.AttackState;


/**
 * 对应 packets.h 中 struct PacketSingleTargetSkillData : Packet。
 */

@Data
public class PacketSingleTargetSkillData extends Packet {

    private int chkSum;  // DWORD dwChkSum
    private int destObjectSerial;  // DWORD dwDestObjectSerial
    private int tarObjectSerial;  // DWORD dwTarObjectSerial
    private Point3D position;  // Point3D sPosition
    private AttackState attackState;  // EAttackState eAttackState
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty
    private int range;  // int iRange
    private short attackPowerMin;  // short AttackPowerMin
    private short attackPowerMax;  // short AttackPowerMax
    private short criticalChance;  // short sCriticalChance
    private short criticalDmgBoost;  // short sCriticalDmgBoost
    private int skillCode;  // int iSkillCode
    private int time;  // DWORD dwTime
    private int attackCount;  // int AttackCount
    private short motionEventNum;  // short MotionEventNum
    private short primaryStats;  // short sPrimaryStats
    private int weaponCode;  // DWORD dwWeaponCode
    private short stageId;  // short StageId
    private short spare2;  // short spare2
    private int questData;  // int iQuestData
    private int attackRating;  // int iAttackRating

    @Override
    protected void readBody(ByteBuffer in) {
        chkSum = in.getInt();
        destObjectSerial = in.getInt();
        tarObjectSerial = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        attackState = AttackState.fromValue((int) in.getShort());
        attackProperty = AttackProperty.fromValue((int) in.getShort());
        range = in.getInt();
        attackPowerMin = in.getShort();
        attackPowerMax = in.getShort();
        criticalChance = in.getShort();
        criticalDmgBoost = in.getShort();
        skillCode = in.getInt();
        time = in.getInt();
        attackCount = in.getInt();
        motionEventNum = in.getShort();
        primaryStats = in.getShort();
        weaponCode = in.getInt();
        stageId = in.getShort();
        spare2 = in.getShort();
        questData = in.getInt();
        attackRating = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(chkSum);
        out.putInt(destObjectSerial);
        out.putInt(tarObjectSerial);
        if (position != null) position.writeTo(out);
        out.putShort((short) attackState.getValue());
        out.putShort((short) attackProperty.getValue());
        out.putInt(range);
        out.putShort(attackPowerMin);
        out.putShort(attackPowerMax);
        out.putShort(criticalChance);
        out.putShort(criticalDmgBoost);
        out.putInt(skillCode);
        out.putInt(time);
        out.putInt(attackCount);
        out.putShort(motionEventNum);
        out.putShort(primaryStats);
        out.putInt(weaponCode);
        out.putShort(stageId);
        out.putShort(spare2);
        out.putInt(questData);
        out.putInt(attackRating);
    }
}
