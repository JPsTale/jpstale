package org.jpstale.gamedata.model;

/**
 * 简化版物品数据模型，不使用 Lombok
 */
public class SimpleItemData {
    private String id;
    private String name;
    private int category;
    private int level;
    private int price;

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
}