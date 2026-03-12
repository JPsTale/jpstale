package org.jpstale.server.common.enums;

/**
 * 物品标志位（对应 packets.h 中 EItemFlag，unsigned char，8 位）。
 */
public final class ItemFlag {

    private ItemFlag() {}

    public static final int None = 0;
    /** 原不可丢弃但允许丢弃；按 A 键不显示 */
    public static final int ForceAllowDrop = 0x01;
    /** 寻宝模式 */
    public static final int TreasureHuntingMode = 0x02;
    public static final int UNUSED_3 = 0x04;
    public static final int UNUSED_4 = 0x08;
    public static final int UNUSED_5 = 0x10;
    public static final int UNUSED_6 = 0x20;
    public static final int UNUSED_7 = 0x40;
    public static final int UNUSED_8 = 0x80;
}
