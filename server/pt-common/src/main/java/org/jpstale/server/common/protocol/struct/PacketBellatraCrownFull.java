package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraCrownFull : Packet。
 */

@Data
public class PacketBellatraCrownFull extends Packet {

    private int bellatraCrownGoldClanId;  // int iBellatraCrownGoldClanId
    private int bellatraCrownSilverClanId;  // int iBellatraCrownSilverClanId
    private int bellatraCrownBronzeClanId;  // int iBellatraCrownBronzeClanId

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
