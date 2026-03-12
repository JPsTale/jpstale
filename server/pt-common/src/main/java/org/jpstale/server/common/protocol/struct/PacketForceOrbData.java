package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketForceOrbData : Packet。
 */

@Data
public class PacketForceOrbData extends Packet {

    private boolean isInCityStage;  // BOOL bIsInCityStage
    private ItemPremium forceOrb;  // ItemPremium sForceOrb

    @Override
    protected void readBody(ByteBuffer in) {
        isInCityStage = in.getInt() != 0;
        if (forceOrb == null) forceOrb = new ItemPremium(); forceOrb.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(isInCityStage ? 1 : 0);
        if (forceOrb != null) forceOrb.writeTo(out);
    }
}
