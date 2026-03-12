package org.jpstale.server.common.enums;

/**
 * 道具 ID（对应 item.h 中 EItemID）。仅列出常用常量，其余通过 fromValue(int) 按值使用。
 */
public enum ItemId {
    None(0),
    RecipeCode(0x0A020000),
    RuneCodeManufacture1(0x03100000),
    HopyCrystal(0x08020100),
    HobgoblinCrystal(0x08020200),
    DecoyCrystal(0x08020300),
    BargonCrystal(0x08020400),
    HeadCutterCrystal(0x08020500),
    FigonCrystal(0x08020600),
    KingHopyCrystal(0x08020700),
    HulkCrystal(0x08020800),
    MysticCrystal(0x08020900),
    GuardianSaintCrystal(0x08020A00),
    WebCrystal(0x08020B00),
    DarkSpecterCrystal(0x08020C00),
    IronGuardCrystal(0x08020D00),
    RicartenMilitiaGuardCrystal(0x08020E00),
    RicartenGuardCrystal(0x08020F00),
    RoyalBlessGuardCrystal(0x08021000),
    OccultCrystal(0x08021100),
    DoomedCrystal(0x08021200),
    DuskyCrystal(0x08021300),
    MechanicCrystal(0x08021700),
    AbysmalCrystal(0x08021800),
    FieryCrystal(0x08021801),
    ArcticCrystal(0x08021900),
    MechanicKingCrystal(0x08022000),
    MatureStoneA(0x080B3400),
    MatureStoneB(0x080B3500),
    MatureStoneC(0x080B3600),
    BlueStone(0x080B0100),
    RedStone(0x080B0200),
    GreenStone(0x080B0300),
    SapphireStone(0x080B3900),
    RubyStone(0x080B3700),
    RicartenCore(0x06010100),
    NaviskoCore(0x06010200),
    AtlantisCore(0x06010300),
    PillaiCore(0x06010400),
    UnionCore(0x06010500),
    Athanasia(0x080A0100),
    DeadlyEdge(0x080A0200),
    AvailOfEvade(0x080A0300),
    BolsterRecovery(0x080A0400),
    Restoration(0x080A0500);

    private final int value;

    ItemId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemId fromValue(int value) {
        for (ItemId id : values()) {
            if (id.value == value) return id;
        }
        return None;
    }
}
