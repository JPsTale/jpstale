package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyMemberData，SIZE = 26 bytes.
 */
@Data
public final class PartyMemberData {

    public static final int SIZE_OF = 26;

    /** int iID; size: 4 bytes */
    private int id;

    /** short sLevel; size: 2 bytes */
    private short level;

    /** CurMax sHP; size: 4 bytes */
    private CurMax hp = new CurMax();

    /** CurMax sMP; size: 4 bytes */
    private CurMax mp = new CurMax();

    /** Point3D sPosition; size: 12 bytes */
    private Point3D position = new Point3D();

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        id = in.getInt();
        level = in.getShort();
        hp.readFrom(in);
        mp.readFrom(in);
        position.readFrom(in);
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(id);
        out.putShort(level);
        hp.writeTo(out);
        mp.writeTo(out);
        position.writeTo(out);
    }
}

