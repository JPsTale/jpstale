package org.jpstale.server.common.enums.pet;

/**
 * 对应 shared/CStable.h 中 StablePetRarity : BYTE。
 */
public enum StablePetRarity {
    COMMON(1),
    UNCOMMON(2),
    RARE(3),
    EPIC(4),
    LEGENDARY(5);

    private final int value;

    StablePetRarity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StablePetRarity fromValue(int value) {
        for (StablePetRarity r : values()) {
            if (r.value == value) {
                return r;
            }
        }
        return COMMON;
    }
}

