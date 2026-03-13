package org.jpstale.server.common.enums.packets;

/**
 * 凤凰宠物类型（对应 packets.h 中 EPhoenixType）。
 * 注：C++ 中 Ice 与 ElementHealing 均为 2，此处用 Ice 表示，语义上 ElementHealing 同值。
 */
public enum PhoenixType {
    None(0),
    Fire(1),
    /** 冰；与 ElementHealing 同值 2 */
    Ice(2),
    Lightning(3),
    Healing(4),
    /** 删除掩码值 */
    DeleteMask(4_855_374);

    private final int value;

    PhoenixType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /** 元素治疗在 C++ 中与 Ice 同为 2 */
    public static final int ELEMENT_HEALING_VALUE = 2;

    public static PhoenixType fromValue(int value) {
        if (value == DeleteMask.value) return DeleteMask;
        for (PhoenixType t : values()) {
            if (t != DeleteMask && t.value == value) return t;
        }
        return None;
    }
}
