package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct ElementalAttackSetting（8 字节：持续时间、几率、参数等）。
 */
@Data
public final class ElementalAttackSetting {
    private byte spare;           // BYTE bSpare
    private byte durationSec;     // BYTE bDurationSec
    private byte chance;         // BYTE bChance
    private byte parameter;      // union: bSpeedReduction / bParameter
    private short sParameter;    // union: sParameter / sLifeStealPercent / sDamageReduction / sStack
    private short percentOfAP;   // short sPercentOfAP

    public void readFrom(ByteBuffer in) {
        spare = in.get();
        durationSec = in.get();
        chance = in.get();
        parameter = in.get();
        sParameter = in.getShort();
        percentOfAP = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.put(spare);
        out.put(durationSec);
        out.put(chance);
        out.put(parameter);
        out.putShort(sParameter);
        out.putShort(percentOfAP);
    }
}
