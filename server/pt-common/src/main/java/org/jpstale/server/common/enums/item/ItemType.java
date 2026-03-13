package org.jpstale.server.common.enums.item;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应 C++ item.h 中 EItemType : unsigned int，4 字节。
 */
public enum ItemType {
    ANY(0xFFFFFFFF),
    NONE(0x00000000),
    RECIPE(0x0A020000),
    AXE(0x01010000),
    CLAW(0x01020000),
    HAMMER(0x01030000),
    WAND(0x01040000),
    SCYTHE(0x01050000),
    BOW(0x01060000),
    SWORD(0x01070000),
    JAVELIN(0x01080000),
    PHANTOM(0x01090000),
    DAGGER(0x010A0000),
    ARMOR(0x02010000),
    COSTUME(0x02100000),
    COSTUME2(0x02110000),
    COSTUME3(0x02060000),
    COSTUME4(0x02070000),
    BOOTS(0x02020000),
    GAUNTLETS(0x02030000),
    SHIELD(0x02040000),
    ROBE(0x02050000),
    SHELTOM(0x02350000),
    AMULET(0x03010000),
    BRACELETS(0x03020000),
    ORB(0x03030000),
    RING(0x03040000),
    FORCE_ORB(0x03060000),
    RESPEC(0x03070000),
    SMELTING(0x03090000),
    CRAFTING(0x03100000),
    EVENT_PR5(0x03130000),
    RING2(0x03050000),
    MANA_POTION(0x04010000),
    HEALTH_POTION(0x04020000),
    STAMINA_POTION(0x04030000),
    GOLD_AND_EXP(0x05010000),
    BELLATO_STONE(0x05020000),
    ETHER_CORE(0x06010000),
    QUEST(0x07010000),
    MORION_T2_QUEST(0x09020000),
    COOKIE(0x08010000),
    MONSTER_CRYSTAL(0x08020000),
    WING(0x08030000),
    GIFT(0x08040000),
    PUZZLE1(0x08060000),
    PUZZLE2(0x08070000),
    CHOCOLATE(0x08080000),
    BELLATRA(0x08090000),
    BLESS_CASTLE(0x080A0000),
    PREMIUM1(0x080B0000),
    PREMIUM2(0x080C0000),
    MONEY_CHEST(0x080D0000),
    PUZZLE4(0x080E0000),
    HAIR_POTION_CODE2(0x08110000),
    MIX_STONE(0x08A00000),
    MATURE_STONE(0x08B00000),
    CRYSTAL(0x08C00000),
    BARS(0x08D00000),
    PET_EGGS(0x08E00000),
    EVENT(0x08F00000);

    private final int value;

    private static final Map<Integer, ItemType> BY_VALUE = new HashMap<>();

    static {
        for (ItemType e : values()) {
            BY_VALUE.putIfAbsent(e.value, e);
        }
    }

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemType fromValue(int value) {
        return BY_VALUE.getOrDefault(value, NONE);
    }
}
