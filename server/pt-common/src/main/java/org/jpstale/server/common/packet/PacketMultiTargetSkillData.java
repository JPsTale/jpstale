package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.AttackProperty;
import org.jpstale.server.common.enums.packets.AttackState;


/**
 * 对应 packets.h 中 struct PacketMultiTargetSkillData : Packet。
 */

@Data
public class PacketMultiTargetSkillData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 592;

    private int targetReceiveDamageId;  // int iTargetReceiveDamageID  size: 4 bytes
    private int chkSum;  // DWORD dwChkSum  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private int damageState;  // int iDamageState  size: 4 bytes
    private int range;  // int iRange  size: 4 bytes
    private MinMax attackPower;  // MinMax sAttackPower  size: 4 bytes
    private short[] weaponAttackPower = new short[2];  // short WeaponAttackPower[2]  size: 4 bytes
    private short criticalChance;  // short sCriticalChance  size: 2 bytes
    private short criticalDmgBoost;  // short sCriticalDmgBoost  size: 2 bytes
    private int skillId;  // int iSkillID  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private int damageCount;  // int iDamageCount  size: 4 bytes
    private short[] motionCount = new short[2];  // short MotionCount[2]  size: 4 bytes
    private int weaponCode;  // DWORD dwWeaponCode  size: 4 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private AttackProperty secondaryAttackProperty;  // EAttackProperty eSecondaryAttackProperty  size: 2 bytes
    private AttackState secondaryAttackState;  // EAttackState eSecondaryAttackState  size: 2 bytes
    private short attackRange;  // short sAttackRange  size: 2 bytes
    private short attackRating;  // short sAttackRating  size: 2 bytes
    private short primaryStats;  // short sPrimaryStats  size: 2 bytes
    private int targetId;  // ID iTargetID  size: 4 bytes
    private int targetCount;  // int iTargetCount  size: 4 bytes
    private int[] iaTargetID = new int[128];  // int iaTargetID[128]  size: 512 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
