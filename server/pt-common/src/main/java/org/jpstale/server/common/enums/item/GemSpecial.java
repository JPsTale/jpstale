package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EGemSpecial（未指定底层类型，按 int），4 字节。
 */
public enum GemSpecial {
    NONE(0),
    WPN_MAX_ATK_POW_ADD_1(1),       // +1 Max Atk Pow on Weapon
    WPN_MAX_ATK_POW_ADD_2(2),       // +2 Max Atk Pow on Weapon
    WPN_REQ_DEC_5_PERCENT_STRENGHT(3),  // -5% Strenght on Weapon
    WPN_ATK_POW_ADD_1(4),           // +1 Min & Max Atk Pow on Weapon
    HP_ADD_10(5),                   // +10 HP
    WEIGHT_ADD_100(6),              // +100 iWeight
    ABSORB_ADD_5(7),                // +5 fAbsorbRating
    BLOCK_ADD_10_PERCENT(8),        // +10% Block
    WPN_REQ_DEC_5_PERCENT_SPIRIT(9),    // -5% Spirit
    HP_REGEN_1(10),                 // 1.0 Regen HP
    FIRE_RESISTANCE_10(11),         // +10 Fire saElementalDef
    MP_ADD_100(12),                 // +100 MP
    MP_REGEN_2(13),                 // 2.0 Regen MP
    SP_ADD_200(14),                 // +200 SP
    ICE_RESISTANCE_10(15),          // +10 Ice saElementalDef
    WPN_REQ_DEC_5_PERCENT_TALENT(16),   // -5% Talent
    ATK_RTG_ADD_20(17),             // +20 Attack Rating
    DEFENSE_ADD_30(18),             // +30 Defense
    WPN_RANGE_ADD_10(19),           // +10 Range on Weapon
    ORGANIC_RESISTANCE_ADD_10(20),  // +10 Organic saElementalDef
    WPN_REQ_DEC_5_PERCENT_AGILITY(21),  // -5% Agility on Weapon
    ATK_RTG_ADD_30(22),             // +30 Attack Rating
    DEFENSE_ADD_40(23),             // +40 Defense
    RUN_SPEED_ADD_1(24),            // +1 Run fMovementSpeed
    LIGHTNING_RESISTANCE_ADD_10(25),   // +10 Lightning saElementalDef
    BLOCK_ADD_1_PERCENT(26),        // +1% Block
    HP_ADD_25(27),                  // +25 HP
    ABSORB_ADD_8(28),               // +8 fAbsorbRating
    ALL_STATS_DEC_2_PERCENT(29),    // -2% All Stats
    HP_REGEN_2(30),                 // 2.0 HP Regen
    DEFENSE_ADD_50(31),             // +50 Defense
    POISON_RESISTANCE_ADD_10(32);   // +10 Poison saElementalDef

    private final int value;

    GemSpecial(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GemSpecial fromValue(int value) {
        for (GemSpecial e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
