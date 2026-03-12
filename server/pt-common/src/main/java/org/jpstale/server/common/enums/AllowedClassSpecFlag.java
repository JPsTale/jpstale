package org.jpstale.server.common.enums;

/**
 * 允许的职业专精标志位（对应 packets.h 中 EAllowedClassSpecFlag，位掩码）。
 */
public final class AllowedClassSpecFlag {

    private AllowedClassSpecFlag() {}

    public static final int None = 0;
    public static final int Fighter = 1 << 0;
    public static final int Mechanician = 1 << 1;
    public static final int Archer = 1 << 2;
    public static final int Pikeman = 1 << 3;
    public static final int Assassin = 1 << 4;
    public static final int Atalanta = 1 << 8;
    public static final int Knight = 1 << 9;
    public static final int Magician = 1 << 10;
    public static final int Priestess = 1 << 11;
    public static final int Shaman = 1 << 12;
}
