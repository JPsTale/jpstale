package org.jpstale.gamedata.model;

/**
 * 简化版道具数据模型，不使用 Lombok
 */
public class SimpleItemData {
    private String id;
    private String name;
    private int category;
    private int level;
    private int price;
    private int weight;
    private int minDamage;
    private int maxDamage;
    private int defense;

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

    public int getMinDamage() { return minDamage; }
    public void setMinAttack(int minDamage) { this.minDamage = minDamage; }

    public int getMaxDamage() { return maxDamage; }
    public void setMaxAttack(int maxDamage) { this.maxDamage = maxDamage; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    @Override
    public String toString() {
        return level + ":" + id + ":" + name;
    }
}