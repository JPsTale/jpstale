package org.jpstale.gamedata.model;

/**
 * 简化版道具数据模型，不使用 Lombok
 */
public class SimpleItemData {
    private String id;
    private String name;
    private String enName;          // 英文名称
    private int category;          // 类别
    private int level;             // 等级需求

    // 基础属性
    private int price;             // 价格
    private int weight;            // 重量

    // 需求属性
    private int strengthReq;       // 力量需求
    private int spiritReq;         // 精神需求
    private int talentReq;         // 才能需求
    private int dexterityReq;      // 敏捷需求
    private int healthReq;         // 体质需求

    // 攻击属性
    private int minDamage;         // 最小伤害
    private int maxDamage;         // 最大伤害
    private int attackSpeed;       // 攻击速度
    private int attackRating;      // 命中率
    private int criticalHit;       // 必杀率

    // 防御属性
    private int defense;           // 防御
    private int chanceBlock;       // 格挡率
    private int absorption;        // 吸收率

    // 元素属性
    private int fireResist;        // 火抗
    private int iceResist;         // 冰抗
    private int lightningResist;   // 雷抗
    private int poisonResist;      // 毒抗
    private int earthResist;       // 土抗

    // 耐久度
    private int durability;        // 耐久度
    private int maxDurability;     // 最大耐久度

    // 特殊属性
    private String specialEffect;  // 特殊效果描述

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCategory() { return category; }
    public void setCategory(int category) { this.category = category; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public String getEnName() { return enName; }
    public void setEnName(String enName) { this.enName = enName; }

    public int getStrengthReq() { return strengthReq; }
    public void setStrengthReq(int strengthReq) { this.strengthReq = strengthReq; }

    public int getSpiritReq() { return spiritReq; }
    public void setSpiritReq(int spiritReq) { this.spiritReq = spiritReq; }

    public int getTalentReq() { return talentReq; }
    public void setTalentReq(int talentReq) { this.talentReq = talentReq; }

    public int getDexterityReq() { return dexterityReq; }
    public void setDexterityReq(int dexterityReq) { this.dexterityReq = dexterityReq; }

    public int getHealthReq() { return healthReq; }
    public void setHealthReq(int healthReq) { this.healthReq = healthReq; }

    public int getMinDamage() { return minDamage; }
    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }

    public int getMaxDamage() { return maxDamage; }
    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public int getAttackSpeed() { return attackSpeed; }
    public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; }

    public int getAttackRating() { return attackRating; }
    public void setAttackRating(int attackRating) { this.attackRating = attackRating; }

    public int getCriticalHit() { return criticalHit; }
    public void setCriticalHit(int criticalHit) { this.criticalHit = criticalHit; }

    public int getChanceBlock() { return chanceBlock; }
    public void setChanceBlock(int chanceBlock) { this.chanceBlock = chanceBlock; }

    public int getAbsorption() { return absorption; }
    public void setAbsorption(int absorption) { this.absorption = absorption; }

    public int getFireResist() { return fireResist; }
    public void setFireResist(int fireResist) { this.fireResist = fireResist; }

    public int getIceResist() { return iceResist; }
    public void setIceResist(int iceResist) { this.iceResist = iceResist; }

    public int getLightningResist() { return lightningResist; }
    public void setLightningResist(int lightningResist) { this.lightningResist = lightningResist; }

    public int getPoisonResist() { return poisonResist; }
    public void setPoisonResist(int poisonResist) { this.poisonResist = poisonResist; }

    public int getEarthResist() { return earthResist; }
    public void setEarthResist(int earthResist) { this.earthResist = earthResist; }

    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    public int getMaxDurability() { return maxDurability; }
    public void setMaxDurability(int maxDurability) { this.maxDurability = maxDurability; }

    public String getSpecialEffect() { return specialEffect; }
    public void setSpecialEffect(String specialEffect) { this.specialEffect = specialEffect; }

    @Override
    public String toString() {
        return level + ":" + id + ":" + name;
    }
}