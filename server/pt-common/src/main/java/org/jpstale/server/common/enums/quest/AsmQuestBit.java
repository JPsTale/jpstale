package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EAsmQuestBit : DWORD，4 字节。位标志。
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
            if (b.value == value) return b;
        }
        return LEVEL_30;
    }
}
