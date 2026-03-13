package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUnitInfo : Packet。
 */

@Data
public class PacketUnitInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 36;

    private int characterData;  // CharacterData sCharacterData  size: 4 bytes
    private int id;  // ID iID  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private Point3D angle;  // Point3D sAngle  size: 12 bytes
    private boolean active;  // BOOL bActive  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        characterData = in.getInt();
        id = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        if (angle == null) angle = new Point3D(); angle.readFrom(in);
        active = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(characterData);
        out.putInt(id);
        if (position != null) position.writeTo(out);
        if (angle != null) angle.writeTo(out);
        out.putInt(active ? 1 : 0);
    }
}
