package org.jpstale.gamedata.model;

/**
 * 简化版NPC数据模型，不使用 Lombok
 */
public class SimpleNPCData {
    private String id;
    private String name;
    private boolean shopkeeper;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isShopkeeper() { return shopkeeper; }
    public void setShopkeeper(boolean shopkeeper) { this.shopkeeper = shopkeeper; }
}