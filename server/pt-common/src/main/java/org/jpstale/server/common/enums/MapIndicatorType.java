package org.jpstale.server.common.enums;

/**
 * 地图指示器类型（对应 packets.h 中 MapIndicator::Type）。
 */
public enum MapIndicatorType {
    None(0),
    /** iValue 为下一张地图 ID */
    NextMapArrow(1),
    HellSpawnMain(2),
    HellSpawnSecondary(3),
    BossIcon(4);

    private final int value;

    MapIndicatorType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MapIndicatorType fromValue(int value) {
        for (MapIndicatorType t : values()) {
            if (t.value == value) return t;
        }
        return None;
    }
}
