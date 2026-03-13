package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.ItemPremium;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketForceOrbData : Packet。
 */

@Data
public class PacketForceOrbData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private boolean isInCityStage;  // BOOL bIsInCityStage  size: 4 bytes
    private ItemPremium forceOrb;  // ItemPremium sForceOrb  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
