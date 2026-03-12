package org.jpstale.server.common.enums;

/**
 * 元素 ID（对应 packets.h 中 EElementID，unsigned short）。
 * 与物品/技能元素类型对应。
 */
public enum ElementId {
    /** 生物/有机 */
    Organic(0),
    /** 土/自然（未使用） */
    Earth(1),
    /** 火 */
    Fire(2),
    /** 冰 */
    Ice(3),
    /** 雷 */
    Lightning(4),
    /** 毒 */
    Poison(5),
    /** 水（未使用） */
    Water(6),
    /** 风（未使用） */
    Wind(7),
    /** 无 */
    None(15);

    private final int value;

    ElementId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ElementId fromValue(int value) {
        for (ElementId e : values()) {
            if (e.value == value) return e;
        }
        return None;
    }
}
