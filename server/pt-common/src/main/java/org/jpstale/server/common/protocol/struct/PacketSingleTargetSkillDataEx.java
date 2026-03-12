package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.AttackProperty;
import org.jpstale.server.common.enums.AttackState;


/**
 * 对应 packets.h 中 struct PacketSingleTargetSkillDataEx : PacketSingleTargetSkillData。
 */

@Data
public class PacketSingleTargetSkillDataEx extends PacketSingleTargetSkillData {

    private AttackState secondaryAttackState;  // EAttackState eSecondaryAttackState
    private AttackProperty secondaryAttackProperty;  // EAttackProperty eSecondaryAttackProperty
    private ElementalAttackSetting secondaryElementalAttackSetting;  // ElementalAttackSetting sSecondaryElementalAttackSetting

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
