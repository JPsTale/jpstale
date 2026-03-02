package org.jpstale.gamedata.model;

/**
 * 简化版地图数据模型，不使用 Lombok
 */
public class SimpleMapData {
    private String id;
    private String name;
    private int minLevel;
    private int maxLevel;
    private String monsters;
    private String npcs;
    private int monsterCount;
    private int respawnTime;
    private boolean hasStartPoint;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMinLevel() { return minLevel; }
    public void setMinLevel(int minLevel) { this.minLevel = minLevel; }

    public int getMaxLevel() { return maxLevel; }
    public void setMaxLevel(int maxLevel) { this.maxLevel = maxLevel; }

    public String getMonsters() { return monsters; }
    public void setMonsters(String monsters) { this.monsters = monsters; }

    public String getNpcs() { return npcs; }
    public void setNpcs(String npcs) { this.npcs = npcs; }

    public int getMonsterCount() { return monsterCount; }
    public void setMonsterCount(int monsterCount) { this.monsterCount = monsterCount; }

    public int getRespawnTime() { return respawnTime; }
    public void setRespawnTime(int respawnTime) { this.respawnTime = respawnTime; }

    public boolean isHasStartPoint() { return hasStartPoint; }
    public void setHasStartPoint(boolean hasStartPoint) { this.hasStartPoint = hasStartPoint; }

    @Override
    public String toString() {
        return id + ":" + name;
    }
}