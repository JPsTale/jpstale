package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.AttackProperty;
import org.jpstale.server.common.enums.packets.AttackState;


/**
 * 对应 packets.h 中 struct PacketSingleTargetSkillDataEx : PacketSingleTargetSkillData。
 */

@Data
public class PacketSingleTargetSkillDataEx extends PacketSingleTargetSkillData {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private AttackState secondaryAttackState;  // EAttackState eSecondaryAttackState  size: 2 bytes
    private AttackProperty secondaryAttackProperty;  // EAttackProperty eSecondaryAttackProperty  size: 2 bytes
    private ElementalAttackSetting secondaryElementalAttackSetting;  // ElementalAttackSetting sSecondaryElementalAttackSetting  size: 8 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        secondaryAttackState = AttackState.fromValue((int) in.getShort());
        secondaryAttackProperty = AttackProperty.fromValue((int) in.getShort());
        if (secondaryElementalAttackSetting == null) secondaryElementalAttackSetting = new ElementalAttackSetting(); secondaryElementalAttackSetting.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putShort((short) secondaryAttackState.getValue());
        out.putShort((short) secondaryAttackProperty.getValue());
        if (secondaryElementalAttackSetting != null) secondaryElementalAttackSetting.writeTo(out);
    }
}
