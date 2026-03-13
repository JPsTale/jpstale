package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.Point3D;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUnitStatusMove : Packet。
 */

@Data
public class PacketUnitStatusMove extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int id;  // ID lID  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private short spare;  // short sSpare  size: 2 bytes
    private short angleY;  // short sAngleY  size: 2 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private short animationType;  // short sAnimationType  size: 2 bytes
    private int frame;  // int iFrame  size: 4 bytes
    private int hashCharacterName;  // DWORD dwHashCharacterName  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
        spare = in.getShort();
        angleY = in.getShort();
        mapId = in.getShort();
        animationType = in.getShort();
        frame = in.getInt();
        hashCharacterName = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        if (position != null) position.writeTo(out);
        out.putShort(spare);
        out.putShort(angleY);
        out.putShort(mapId);
        out.putShort(animationType);
        out.putInt(frame);
        out.putInt(hashCharacterName);
    }
}
