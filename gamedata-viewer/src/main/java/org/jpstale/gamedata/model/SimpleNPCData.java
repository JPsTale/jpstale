package org.jpstale.gamedata.model;

/**
 * 简化版NPC数据模型，不使用 Lombok
 */
public class SimpleNPCData {
    private String id;
    private String name;
    private String modelName;
    private int level;
    private boolean shopkeeper;

    // 商店数据
    private String[] sellAttackItems;    // 出售的攻击类装备
    private String[] sellDefenceItems;   // 出售的防御类装备
    private String[] sellEtcItems;      // 出售的其他道具

    // 特殊功能
    private String functions;           // 特殊功能说明（如：仓库、锻造、技能导师等）

    // 对话信息
    private String[] messages;          // NPC对话内容

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public boolean isShopkeeper() { return shopkeeper; }
    public void setShopkeeper(boolean shopkeeper) { this.shopkeeper = shopkeeper; }

    public String[] getSellAttackItems() { return sellAttackItems; }
    public void setSellAttackItems(String[] sellAttackItems) { this.sellAttackItems = sellAttackItems; }

    public String[] getSellDefenceItems() { return sellDefenceItems; }
    public void setSellDefenceItems(String[] sellDefenceItems) { this.sellDefenceItems = sellDefenceItems; }

    public String[] getSellEtcItems() { return sellEtcItems; }
    public void setSellEtcItems(String[] sellEtcItems) { this.sellEtcItems = sellEtcItems; }

    public String getFunctions() { return functions; }
    public void setFunctions(String functions) { this.functions = functions; }

    public String[] getMessages() { return messages; }
    public void setMessages(String[] messages) { this.messages = messages; }

    @Override
    public String toString() {
        return level + ":" + id + ":" + name;
    }
}