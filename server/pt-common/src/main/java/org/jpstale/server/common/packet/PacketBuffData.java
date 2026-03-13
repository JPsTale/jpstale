package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBuffData : Packet。
 * <p>
 * C 端包体为 union：同一段内存可为多种 struct 变体，由包头 {@link Packet#getPktHeader() iHeader} 区分
 * （例如 PTKHDR_Effect_Debuff 表示按 Debuff 解释）。当前仅生成 union 中第一个 struct 的字段布局；
 * 若协议中仅使用该变体，则语义一致。
 */

@Data
public class PacketBuffData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private byte poison;  // BYTE bPoison  size: 1 bytes
    private byte burning;  // BYTE bBurning  size: 1 bytes
    private byte distortion;  // BYTE bDistortion  size: 1 bytes
    private byte curse;  // BYTE bCurse  size: 1 bytes
    private byte spare1;  // BYTE bSpare1  size: 1 bytes
    private byte iceOverlay;  // BYTE bIceOverlay  size: 1 bytes
    private byte spare3;  // BYTE bSpare3  size: 1 bytes
    private byte spare4;  // BYTE bSpare4  size: 1 bytes
    private int stunCount;  // int iStunCount  size: 4 bytes
    private int damageReduction;  // int iDamageReduction  size: 4 bytes
    private int[] spare = new int[4];  // int iaSpare[4]  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
