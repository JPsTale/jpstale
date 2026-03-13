package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EQuestMonsterID，4 字节（int）。
 */
public enum QuestMonsterId {
    RATOO(10),
    BRONZE_WOLVERINE(1191),
    SILVER_WOLVERINE(1192),
    GOLDEN_WOLVERINE(1193),
    MINIGUE_SILVER(1031),
    BEE_DOG(1029),
    IRON_GUARD(24),
    CRYSTAL_TOWER(2105);

    private final int value;

    QuestMonsterId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestMonsterId fromValue(int value) {
        for (QuestMonsterId id : values()) {
            if (id.value == value) return id;
        }
        return RATOO;
    }
}
