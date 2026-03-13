package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.AttackProperty;
import org.jpstale.server.common.enums.packets.AttackState;


/**
 * 对应 packets.h 中 struct PacketSingleTargetSkillData : Packet。
 */

@Data
public class PacketSingleTargetSkillData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 72;

    private int chkSum;  // DWORD dwChkSum  size: 4 bytes
    private int destObjectSerial;  // DWORD dwDestObjectSerial  size: 4 bytes
    private int tarObjectSerial;  // DWORD dwTarObjectSerial  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private AttackState attackState;  // EAttackState eAttackState  size: 2 bytes
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty  size: 2 bytes
    private int range;  // int iRange  size: 4 bytes
    private short attackPowerMin;  // short AttackPowerMin  size: 2 bytes
    private short attackPowerMax;  // short AttackPowerMax  size: 2 bytes
    private short criticalChance;  // short sCriticalChance  size: 2 bytes
    private short criticalDmgBoost;  // short sCriticalDmgBoost  size: 2 bytes
    private int skillCode;  // int iSkillCode  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private int attackCount;  // int AttackCount  size: 4 bytes
    private short motionEventNum;  // short MotionEventNum  size: 2 bytes
    private short primaryStats;  // short sPrimaryStats  size: 2 bytes
    private int weaponCode;  // DWORD dwWeaponCode  size: 4 bytes
    private short stageId;  // short StageId  size: 2 bytes
    private short spare2;  // short spare2  size: 2 bytes
    private int questData;  // int iQuestData  size: 4 bytes
    private int attackRating;  // int iAttackRating  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
