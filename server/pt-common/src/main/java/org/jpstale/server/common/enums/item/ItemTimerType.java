package org.jpstale.server.common.enums.item;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应 premiumstruct.h 中 EItemTimerType（逻辑属物品，迁入 item 包），4 字节（int）。
 */
public enum ItemTimerType {
    NONE(0),
    EXP_UP(1),
    THIRD_EYE(2),
    PHOENIX(3),
    PHOENIX_FIRE(4),
    PHOENIX_ICE(5),
    PHOENIX_LIGHTNING(6),
    PHOENIX_HEAL(7),
    MP_DOWN(8),
    SP_DOWN(9),
    HP_UP(10),
    MP_UP(11),
    BIG_HEAD(12),
    WEIGHT_STONE(13),
    MATURE_STONE(14),
    SKILL_STONE(15),
    CARTOLA_HAT(16),
    WITCH_HAT(17),
    SHEEP_HAT(18),
    GIRAFFE_HAT(19),
    SOCCER_HAT(20),
    CHRISTMAS_GREEN_HAT(21),
    CHRISTMAS_RED_HAT(22),
    BIG_HEAD_HAPPINESS(23),
    BIG_HEAD_LOVE(24),
    BIG_HEAD_SADNESS(25),
    BIG_HEAD_SHYNESS(26),
    BIG_HEAD_ANGRY(27),
    BIG_HEAD_SURPRISED(28),
    BIG_HEAD_SENSUAL(29),
    BC_BUFF(30),
    PUMPKIN_HAT(31),
    BIG_HEAD_VALENTINE(32),
    EASTER_SHEEP_HAT(33),
    FORCE_ORB(34),
    HONEY_DAMAGE(35),
    HONEY_FAST(36),
    HONEY_SMART(37),
    HONEY_DEFENSE(38),
    SOCCER_HAT_SPEED(39),
    CHELSEA_SOCCER(40),
    MANCHESTER_SOCCER(41),
    PHOENIX_FIRE_SMALL(42),
    PHOENIX_ICE_SMALL(43),
    PHOENIX_LIGHTNING_SMALL(44),
    PHOENIX_HEALING_SMALL(45),
    SIXTH_SENSE(46),
    SHP_REGEN(47),
    SSP_REGEN(48),
    SMP_REGEN(49),
    SMP_DOWN(50),
    SSP_DOWN(51),
    S_BONUS_DAMAGE(52),
    S_BONUS_ABSORB(53),
    S_MOVE_SPEED(54),
    S_EXP_BUFF(55),
    S_DROP_BUFF(56),
    ICE_RESISTANCE_BUFF(57),
    PET_SYSTEM(58);

    private final int value;

    private static final Map<Integer, ItemTimerType> BY_VALUE = new HashMap<>();

    static {
        for (ItemTimerType t : values()) {
            BY_VALUE.putIfAbsent(t.value, t);
        }
    }

    ItemTimerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemTimerType fromValue(int value) {
        return BY_VALUE.getOrDefault(value, NONE);
    }
}
