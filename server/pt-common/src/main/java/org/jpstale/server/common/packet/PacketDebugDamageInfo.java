package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.DamageTextType;


/**
 * 对应 packets.h 中 struct PacketDebugDamageInfo : Packet。
 */

@Data
public class PacketDebugDamageInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int objectId;  // ID dwObjectID  size: 4 bytes
    private DamageTextType typeAction;  // EDamageTextType sTypeAction  size: 2 bytes
    private short parameter;  // short sParameter  size: 2 bytes
    private int value;  // int iValue  size: 4 bytes
    private int attackerId;  // ID dwAttackerID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        typeAction = DamageTextType.fromValue((int) in.getShort());
        parameter = in.getShort();
        value = in.getInt();
        attackerId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putShort((short) typeAction.getValue());
        out.putShort(parameter);
        out.putInt(value);
        out.putInt(attackerId);
    }
}
