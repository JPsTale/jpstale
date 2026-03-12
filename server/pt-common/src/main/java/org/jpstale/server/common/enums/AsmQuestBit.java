package org.jpstale.server.common.enums;

/**
 * 对应 shared/quest.h 中的 EAsmQuestBit : DWORD。
 */
public enum AsmQuestBit {
    LEVEL_30(1 << 0),
    LEVEL_55(1 << 1),
    LEVEL_70(1 << 2),
    LEVEL_80(1 << 3),
    LEVEL_85(1 << 4),
    LEVEL_90(1 << 5),
    LEVEL_80_2(1 << 6),
    LEVEL_90_2(1 << 7);

    private final int value;

    AsmQuestBit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AsmQuestBit fromValue(int value) {
        for (AsmQuestBit b : values()) {
            if (b.value == value) {
                return b;
            }
        }
        return LEVEL_30;
    }
}

