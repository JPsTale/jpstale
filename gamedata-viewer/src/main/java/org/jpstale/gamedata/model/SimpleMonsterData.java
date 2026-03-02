package org.jpstale.gamedata.model;

/**
 * 简化版怪物数据模型，不使用 Lombok
 */
public class SimpleMonsterData {
    private String id;
    private String name;
    private String modelName;
    private int level;
    private int minAttack;
    private int maxAttack;
    private int defense;
    private int life;
    private int experience;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getMinAttack() { return minAttack; }
    public void setMinAttack(int minAttack) { this.minAttack = minAttack; }

    public int getMaxAttack() { return maxAttack; }
    public void setMaxAttack(int maxAttack) { this.maxAttack = maxAttack; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
}