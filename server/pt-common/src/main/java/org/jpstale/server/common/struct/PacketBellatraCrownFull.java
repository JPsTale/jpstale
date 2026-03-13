package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraCrownFull : Packet。
 */

@Data
public class PacketBellatraCrownFull extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int bellatraCrownGoldClanId;  // int iBellatraCrownGoldClanId  size: 4 bytes
    private int bellatraCrownSilverClanId;  // int iBellatraCrownSilverClanId  size: 4 bytes
    private int bellatraCrownBronzeClanId;  // int iBellatraCrownBronzeClanId  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        bellatraCrownGoldClanId = in.getInt();
        bellatraCrownSilverClanId = in.getInt();
        bellatraCrownBronzeClanId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(bellatraCrownGoldClanId);
        out.putInt(bellatraCrownSilverClanId);
        out.putInt(bellatraCrownBronzeClanId);
    }
}
