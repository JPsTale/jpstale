package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyRaidMemberData，SIZE = 24 bytes.
 */
@Data
public final class PartyRaidMemberData {

    public static final int SIZE_OF = 24;

    /** int iID; size: 4 bytes */
    private int id;

    /** CurMax sHP; size: 4 bytes */
    private CurMax hp = new CurMax();

    /** Point3D sPosition; size: 12 bytes */
    private Point3D position = new Point3D();

    /** padding to reach 24 bytes; size: 4 bytes */
    private final byte[] padding = new byte[4];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        id = in.getInt();
        hp.readFrom(in);
        position.readFrom(in);
        in.get(padding);
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(id);
        hp.writeTo(out);
        position.writeTo(out);
        out.put(padding);
    }
}

