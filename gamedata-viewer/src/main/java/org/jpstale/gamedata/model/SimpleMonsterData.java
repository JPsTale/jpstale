package org.jpstale.gamedata.model;

/**
 * 简化版怪物数据模型，不使用 Lombok
 */
public class SimpleMonsterData {
    private String id;
    private String name;
    private String modelName;
    private int level;

    // 基础属性
    private int strength;      // 力量
    private int spirit;        // 精神
    private int talent;        // 才能
    private int dexterity;     // 敏捷
    private int health;        // 体质

    // 战斗属性
    private int minAttack;
    private int maxAttack;
    private int attackSpeed;   // 攻击速度
    private int attackRating;  // 命中率
    private int criticalHit;   // 必杀率
    private int shootingRange; // 攻击范围
    private int defense;
    private int chanceBlock;   // 格挡率
    private int absorption;    // 吸收率
    private int life;
    private int experience;

    // 元素属性
    private int fire;
    private int ice;
    private int lightning;
    private int poison;
    private int earth;

    // 移动和视野
    private float moveSpeed;
    private int sight;
    private int sizeLevel;     // 尺寸等级

    // 其他属性
    private String dropItems;  // 掉落物信息
    private int undead;        // 不死属性
    private String nature;     // 怪物性质（主动/被动）

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

    // 基础属性的getter和setter
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getSpirit() { return spirit; }
    public void setSpirit(int spirit) { this.spirit = spirit; }

    public int getTalent() { return talent; }
    public void setTalent(int talent) { this.talent = talent; }

    public int getDexterity() { return dexterity; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    // 战斗属性的getter和setter
    public int getAttackSpeed() { return attackSpeed; }
    public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; }

    public int getAttackRating() { return attackRating; }
    public void setAttackRating(int attackRating) { this.attackRating = attackRating; }

    public int getCriticalHit() { return criticalHit; }
    public void setCriticalHit(int criticalHit) { this.criticalHit = criticalHit; }

    public int getShootingRange() { return shootingRange; }
    public void setShootingRange(int shootingRange) { this.shootingRange = shootingRange; }

    public int getChanceBlock() { return chanceBlock; }
    public void setChanceBlock(int chanceBlock) { this.chanceBlock = chanceBlock; }

    public int getAbsorption() { return absorption; }
    public void setAbsorption(int absorption) { this.absorption = absorption; }

    // 其他属性
    public int getSizeLevel() { return sizeLevel; }
    public void setSizeLevel(int sizeLevel) { this.sizeLevel = sizeLevel; }

    public int getUndead() { return undead; }
    public void setUndead(int undead) { this.undead = undead; }

    public String getNature() { return nature; }
    public void setNature(String nature) { this.nature = nature; }

    public String getDropItems() { return dropItems; }
    public void setDropItems(String dropItems) { this.dropItems = dropItems; }

    @Override
    public String toString() {
        return level + ":" + id + ":" + name;
    }
}