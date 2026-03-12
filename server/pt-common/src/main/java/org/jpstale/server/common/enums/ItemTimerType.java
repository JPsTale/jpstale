package org.jpstale.server.common.enums;

/**
 * 道具计时器类型（对应 premiumstruct.h 中 EItemTimerType）。
 */
public enum ItemTimerType {
    None(0),
    ExpUp(1),
    ThirdEye(2),
    Phoenix(3),
    PhoenixFire(4),
    PhoenixIce(5),
    PhoenixLightning(6),
    PhoenixHeal(7),
    MPDown(8),
    SPDown(9),
    HPUp(10),
    MPUp(11),
    BigHead(12),
    WeightStone(13),
    MatureStone(14),
    SkillStone(15),
    CartolaHat(16),
    WitchHat(17),
    SheepHat(18),
    GiraffeHat(19),
    SoccerHat(20),
    ChristmasGreenHat(21),
    ChristmasRedHat(22),
    BigHeadHappiness(23),
    BigHeadLove(24),
    BigHeadSadness(25),
    BigHeadShyness(26),
    BigHeadAngry(27),
    BigHeadSurprised(28),
    BigHeadSensual(29),
    BCBuff(30),
    PumpkinHat(31),
    BigHeadValentine(32),
    EasterSheepHat(33),
    ForceOrb(34),
    HoneyDamage(35),
    HoneyFast(36),
    HoneySmart(37),
    HoneyDefense(38),
    SoccerHatSpeed(39),
    ChelseaSoccer(40),
    ManchesterSoccer(41),
    PhoenixFireSmall(42),
    PhoenixIceSmall(43),
    PhoenixLightningSmall(44),
    PhoenixHealingSmall(45),
    SixthSense(46),
    SHPRegen(47),
    SSPRegen(48),
    SMPRegen(49),
    SMPDown(50),
    SSPDown(51),
    SBonusDamage(52),
    SBonusAbsorb(53),
    SMoveSpeed(54),
    SExpBuff(55),
    SDropBuff(56),
    IceResistanceBuff(57),
    PetSystem(58);

    private final int value;

    ItemTimerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemTimerType fromValue(int value) {
        for (ItemTimerType t : values()) {
            if (t.value == value) return t;
        }
        return None;
    }
}
