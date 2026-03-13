package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EAsmQuestCode : DWORD，4 字节。
 */
public enum AsmQuestCode {
    CHANGE_JOB1(0x0001),
    CHANGE_JOB2_M(0x0002),
    CHANGE_JOB2_D(0x0003),
    CHANGE_JOB3(0x0004),
    CHANGE_JOB4(0x0010),
    LEVEL30(0x0005),
    LEVEL55(0x0006),
    LEVEL55_2(0x0007),
    LEVEL70(0x0008),
    LEVEL80(0x0009),
    LEVEL85(0x000A),
    LEVEL90(0x000B),
    LEVEL80_2(0x000C),
    LEVEL90_2(0x000D);

    private final int value;

    AsmQuestCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AsmQuestCode fromValue(int value) {
        for (AsmQuestCode c : values()) {
            if (c.value == value) return c;
        }
        return CHANGE_JOB1;
    }
}
