package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBuffData : Packet。
 * <p>
 * C 端包体为 union：同一段内存可为多种 struct 变体，由包头 {@link Packet#getHeader() iHeader} 区分
 * （例如 PTKHDR_Effect_Debuff 表示按 Debuff 解释）。当前仅生成 union 中第一个 struct 的字段布局；
 * 若协议中仅使用该变体，则语义一致。
 */

@Data
public class PacketBuffData extends Packet {

    private byte poison;  // BYTE bPoison
    private byte burning;  // BYTE bBurning
    private byte distortion;  // BYTE bDistortion
    private byte curse;  // BYTE bCurse
    private byte spare1;  // BYTE bSpare1
    private byte iceOverlay;  // BYTE bIceOverlay
    private byte spare3;  // BYTE bSpare3
    private byte spare4;  // BYTE bSpare4
    private int stunCount;  // int iStunCount
    private int damageReduction;  // int iDamageReduction
    private int[] spare = new int[4];  // int iaSpare[4]

    @Override
    protected void readBody(ByteBuffer in) {
        poison = in.get();
        burning = in.get();
        distortion = in.get();
        curse = in.get();
        spare1 = in.get();
        iceOverlay = in.get();
        spare3 = in.get();
        spare4 = in.get();
        stunCount = in.getInt();
        damageReduction = in.getInt();
        for (int i = 0; i < spare.length; i++) { spare[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(poison);
        out.put(burning);
        out.put(distortion);
        out.put(curse);
        out.put(spare1);
        out.put(iceOverlay);
        out.put(spare3);
        out.put(spare4);
        out.putInt(stunCount);
        out.putInt(damageReduction);
        for (int i = 0; i < spare.length; i++) { out.putInt(spare[i]); }
    }
}
