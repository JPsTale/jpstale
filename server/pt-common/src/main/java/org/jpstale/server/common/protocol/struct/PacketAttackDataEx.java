package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.AttackProperty;
import org.jpstale.server.common.enums.AttackState;


/**
 * 对应 packets.h 中 struct PacketAttackDataEx : PacketAttackData。
 */

@Data
public class PacketAttackDataEx extends PacketAttackData {

    private AttackState attackState;  // EAttackState eAttackState
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        attackState = AttackState.fromValue((int) in.getShort());
        attackProperty = AttackProperty.fromValue((int) in.getShort());
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putShort((short) attackState.getValue());
        out.putShort((short) attackProperty.getValue());
    }
}
