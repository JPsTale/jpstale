package org.jpstale.server.common.enums;

/**
 * 对应 shared/quest.h 中 enum class EQuestPartyType : BYTE。
 */
public enum QuestPartyType {
    SOLO_ONLY(0),
    PARTY_ONLY(1),
    SOLO_AND_PARTY(2),
    PARTY_AND_RAID(3),
    SOLO_PARTY_AND_RAID(4),
    RAID_ONLY(5),
    SOLO_ANY(6),
    SOLO_PARTY_ANY(7);

    private final int value;

    QuestPartyType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestPartyType fromValue(int value) {
        for (QuestPartyType t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        return SOLO_ONLY;
    }
}

