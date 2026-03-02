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
    private int fire;
    private int ice;
    private int lightning;
    private int poison;
    private int earth;
    private float moveSpeed;
    private int sight;
    private String dropItems; // 掉落物信息

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

    public int getFire() { return fire; }
    public void setFire(int fire) { this.fire = fire; }

    public int getIce() { return ice; }
    public void setIce(int ice) { this.ice = ice; }

    public int getLightning() { return lightning; }
    public void setLightning(int lightning) { this.lightning = lightning; }

    public int getPoison() { return poison; }
    public void setPoison(int poison) { this.poison = poison; }

    public int getEarth() { return earth; }
    public void setEarth(int earth) { this.earth = earth; }

    public float getMoveSpeed() { return moveSpeed; }
    public void setMoveSpeed(float moveSpeed) { this.moveSpeed = moveSpeed; }

    public int getSight() { return sight; }
    public void setSight(int sight) { this.sight = sight; }

    public String getDropItems() { return dropItems; }
    public void setDropItems(String dropItems) { this.dropItems = dropItems; }

    @Override
    public String toString() {
        return level + ":" + id + ":" + name;
    }
}