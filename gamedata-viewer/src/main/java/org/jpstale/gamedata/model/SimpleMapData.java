package org.jpstale.gamedata.model;

/**
 * 简化版地图数据模型，不使用 Lombok
 */
public class SimpleMapData {
    private String id;
    private String name;
    private int minLevel;
    private int maxLevel;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMinLevel() { return minLevel; }
    public void setMinLevel(int minLevel) { this.minLevel = minLevel; }

    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) { this.maxLevel = maxLevel; }
}