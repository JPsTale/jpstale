package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 enum EGemItem : unsigned char。size: 1 byte
 */
public enum GemItem {
    NONE(0),
    EMERALD(1),
    RUBY(2),
    AQUAMARINE(3),
    AMETHYST(4),
    TOPAZ(5),
    RAINBOW_OPAL(6),
    DEMON_SLAYER(7),
    BLOODY_PERL(8),
    NAVY_PERL(9),
    TEMPSKRON_MARTYR(10),
    MORION_MARTYR(11),
    ROYAL_DIAMOND(12),
    POLISHED_CITRINE(13),
    ELEMENTAL_TOURMALINE(14),
    DIVINE_HEART(15),
    LUCKY_CIRCLET(16);

    private final int value;

    GemItem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GemItem fromValue(int value) {
        for (GemItem e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
