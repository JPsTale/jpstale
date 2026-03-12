package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.DamageTextType;


/**
 * 对应 packets.h 中 struct PacketDebugDamageInfo : Packet。
 */

@Data
public class PacketDebugDamageInfo extends Packet {

    private int objectId;  // ID dwObjectID
    private DamageTextType typeAction;  // EDamageTextType sTypeAction
    private short parameter;  // short sParameter
    private int value;  // int iValue
    private int attackerId;  // ID dwAttackerID

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        typeAction = DamageTextType.fromValue(in.getInt());
        parameter = in.getShort();
        value = in.getInt();
        attackerId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(typeAction.getValue());
        out.putShort(parameter);
        out.putInt(value);
        out.putInt(attackerId);
    }
}
