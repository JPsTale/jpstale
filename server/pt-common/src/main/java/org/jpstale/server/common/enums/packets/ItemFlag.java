package org.jpstale.server.common.enums.packets;

/**
 * 物品标志位，对应 C++ packets.h 中
 * {@code enum class EItemFlag : unsigned char}，1 字节（8 位）。
 */
public enum ItemFlag {

    NONE(0),
    /** 原不可丢弃但允许丢弃；按 A 键不显示 */
    FORCE_ALLOW_DROP(0x01),
    /** 寻宝模式 */
    TREASURE_HUNTING_MODE(0x02),
    UNUSED_3(0x04),
    UNUSED_4(0x08),
    UNUSED_5(0x10),
    UNUSED_6(0x20),
    UNUSED_7(0x40),
    UNUSED_8(0x80);

    private final int value;

    ItemFlag(int value) {
        this.value = value;
    }

    /**
     * 返回对应的底层整型值（0–255）。
     */
    public int getValue() {
        return value;
    }

    /**
     * 根据底层整型值解析枚举；未知值返回 {@link #NONE}。
     */
    public static ItemFlag fromValue(int value) {
        for (ItemFlag flag : values()) {
            if (flag.value == value) {
                return flag;
            }
        }
        return NONE;
    }
}

