package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 enum class EMixTypeName : unsigned int。size: 4 bytes
 * 仅列出常用值；其余数值通过 fromValue 按整数处理。
 */
public enum MixTypeName {
    NONE(0),
    LEGACY_DO_NOT_USE(1),

    LUCIDY1(101),
    SERENEO1(102),
    FADEO1(103),
    SPARKY1(104),
    RAIDENT1(105),
    TRANSPARO1(106),
    MURKY1(107),
    DEVINE1(108),
    CELESTO1(109),
    MIRAGE1(110),
    INFERNA1(111),
    ENIGMA1(112),
    BELLUM1(113),
    OREDO1(114),

    LUCIDY2(201),
    SERENEO2(202),
    FADEO2(203),
    SPARKY2(204),
    RAIDENT2(205),
    TRANSPARO2(206),
    MURKY2(207),
    DEVINE2(208),
    CELESTO2(209),
    MIRAGE2(210),
    INFERNA2(211),
    ENIGMA2(212),
    BELLUM2(213),
    OREDO2(214),

    LUCIDY3(301),
    SERENEO3(302),
    FADEO3(303),
    SPARKY3(304),
    RAIDENT3(305),
    TRANSPARO3(306),
    MURKY3(307),
    DEVINE3(308),
    CELESTO3(309),
    MIRAGE3(310),
    INFERNA3(311),
    ENIGMA3(312),
    BELLUM3(313),
    OREDO3(314),

    LUCIDY4(401),
    SERENEO4(402),
    FADEO4(403),
    SPARKY4(404),
    RAIDENT4(405),
    TRANSPARO4(406),
    MURKY4(407),
    DEVINE4(408),
    CELESTO4(409),
    MIRAGE4(410),
    INFERNA4(411),
    ENIGMA4(412),
    BELLUM4(413),
    OREDO4(414),

    LUCIDY5(501),
    SERENEO5(502),
    FADEO5(503),
    SPARKY5(504),
    RAIDENT5(505),
    TRANSPARO5(506),
    MURKY5(507),
    DEVINE5(508),
    CELESTO5(509),
    MIRAGE5(510),
    INFERNA5(511),
    ENIGMA5(512),
    BELLUM5(513),
    OREDO5(514),

    LUCIDY6(601),
    SERENEO6(602),
    FADEO6(603),
    SPARKY6(604),
    RAIDENT6(605),
    TRANSPARO6(606),
    MURKY6(607),
    DEVINE6(608),
    CELESTO6(609),
    MIRAGE6(610),
    INFERNA6(611),
    ENIGMA6(612),
    BELLUM6(613),
    OREDO6(614),

    LUCIDY7(701),
    SERENEO7(702),
    FADEO7(703),
    SPARKY7(704),
    RAIDENT7(705),
    TRANSPARO7(706),
    MURKY7(707),
    DEVINE7(708),
    CELESTO7(709),
    MIRAGE7(710),
    INFERNA7(711),
    ENIGMA7(712),
    BELLUM7(713),
    OREDO7(714),

    LUCIDY8(801),
    SERENEO8(802),
    FADEO8(803),
    SPARKY8(804),
    RAIDENT8(805),
    TRANSPARO8(806),
    MURKY8(807),
    DEVINE8(808),
    CELESTO8(809),
    MIRAGE8(810),
    INFERNA8(811),
    ENIGMA8(812),
    BELLUM8(813),
    OREDO8(814),

    LUCIDY9(901),
    SERENEO9(902),
    FADEO9(903),
    SPARKY9(904),
    RAIDENT9(905),
    TRANSPARO9(906),
    MURKY9(907),
    DEVINE9(908),
    CELESTO9(909),
    MIRAGE9(910),
    INFERNA9(911),
    ENIGMA9(912),
    BELLUM9(913),
    OREDO9(914);

    private final int value;

    MixTypeName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MixTypeName fromValue(int value) {
        for (MixTypeName e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
