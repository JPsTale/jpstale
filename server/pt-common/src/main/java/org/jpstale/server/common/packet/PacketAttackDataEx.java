package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.AttackProperty;
import org.jpstale.server.common.enums.packets.AttackState;


/**
 * 对应 packets.h 中 struct PacketAttackDataEx : PacketAttackData。
 */

@Data
public class PacketAttackDataEx extends PacketAttackData {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private AttackState attackState;  // EAttackState eAttackState  size: 2 bytes
    private AttackProperty attackProperty;  // EAttackProperty iAttackProperty  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
