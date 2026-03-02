package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.*;

import java.io.File;

/**
 * 测试详细数据展示
 */
public class TestDetailedDisplay {
    public static void main(String[] args) {
        System.out.println("=== 测试详细数据展示 ===\n");

        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 加载数据
        DataConverter.loadAllData(gameServerDir, container);

        // 测试怪物详细信息
        System.out.println("===== 怪物详细信息 =====");
        for (SimpleMonsterData monster : container.getMonsters()) {
            if (monster.getLevel() >= 120) {
                System.out.println("\n怪物名称: " + monster.getName());
                System.out.println("ID: " + monster.getId());
                System.out.println("模型: " + (monster.getModelName() != null ? monster.getModelName() : "未知"));
                System.out.println("等级: " + monster.getLevel());
                System.out.println("性质: " + (monster.getNature() != null ? monster.getNature() : "未知"));
                System.out.println("不死属性: " + (monster.getUndead() > 0 ? "是" : "否"));

                System.out.println("\n基础属性:");
                System.out.println("  力量: " + monster.getStrength());
                System.out.println("  精神: " + monster.getSpirit());
                System.out.println("  才能: " + monster.getTalent());
                System.out.println("  敏捷: " + monster.getDexterity());
                System.out.println("  体质: " + monster.getHealth());

                System.out.println("\n战斗属性:");
                System.out.println("  生命值: " + monster.getLife());
                System.out.println("  攻击力: " + monster.getMinAttack() + " - " + monster.getMaxAttack());
                System.out.println("  攻击速度: " + monster.getAttackSpeed());
                System.out.println("  命中率: " + monster.getAttackRating());
                System.out.println("  必杀率: " + monster.getCriticalHit());
                System.out.println("  攻击范围: " + monster.getShootingRange());
                System.out.println("  防御力: " + monster.getDefense());
                System.out.println("  格挡率: " + monster.getChanceBlock());
                System.out.println("  吸收率: " + monster.getAbsorption());
                System.out.println("  经验值: " + monster.getExperience());

                System.out.println("\n元素抗性:");
                System.out.println("  火焰: " + monster.getFire());
                System.out.println("  冰霜: " + monster.getIce());
                System.out.println("  雷电: " + monster.getLightning());
                System.out.println("  毒素: " + monster.getPoison());
                System.out.println("  大地: " + monster.getEarth());

                System.out.println("\n移动属性:");
                System.out.println("  移动速度: " + monster.getMoveSpeed());
                System.out.println("  视野范围: " + monster.getSight());
                System.out.println("  尺寸等级: " + monster.getSizeLevel());

                break;
            }
        }

        // 测试NPC详细信息
        System.out.println("\n\n===== NPC详细信息 =====");
        for (SimpleNPCData npc : container.getNpcs()) {
            if (npc.isShopkeeper() && npc.getFunctions() != null && !npc.getFunctions().isEmpty()) {
                System.out.println("\nNPC名称: " + npc.getName());
                System.out.println("ID: " + npc.getId());
                System.out.println("模型: " + (npc.getModelName() != null ? npc.getModelName() : "未知"));
                System.out.println("等级: " + npc.getLevel());
                System.out.println("类型: 商人");

                System.out.println("\n特殊功能:");
                System.out.println("  " + npc.getFunctions());

                if (npc.getSellAttackItems() != null && npc.getSellAttackItems().length > 0) {
                    System.out.println("\n攻击装备出售:");
                    for (String item : npc.getSellAttackItems()) {
                        if (item != null) {
                            System.out.println("  - " + item);
                        }
                    }
                }

                if (npc.getMessages() != null && npc.getMessages().length > 0) {
                    System.out.println("\nNPC对话:");
                    for (String msg : npc.getMessages()) {
                        if (msg != null) {
                            System.out.println("  " + msg);
                        }
                    }
                }

                break;
            }
        }

        // 测试道具详细信息
        System.out.println("\n\n===== 道具详细信息 =====");
        for (SimpleItemData item : container.getItems()) {
            if (item.getCategory() == 1 && item.getLevel() >= 50) { // 高级武器
                System.out.println("\n道具名称: " + item.getName());
                if (item.getEnName() != null && !item.getEnName().isEmpty()) {
                    System.out.println("英文名: " + item.getEnName());
                }
                System.out.println("ID: " + item.getId());
                System.out.println("类别: " + item.getCategory() + " (武器)");
                System.out.println("等级需求: " + item.getLevel());
                System.out.println("价格: " + item.getPrice());
                System.out.println("重量: " + item.getWeight());

                if (item.getStrengthReq() > 0 || item.getSpiritReq() > 0 ||
                    item.getTalentReq() > 0 || item.getDexterityReq() > 0 ||
                    item.getHealthReq() > 0) {
                    System.out.println("\n属性需求:");
                    if (item.getStrengthReq() > 0) System.out.println("  力量: " + item.getStrengthReq());
                    if (item.getSpiritReq() > 0) System.out.println("  精神: " + item.getSpiritReq());
                    if (item.getTalentReq() > 0) System.out.println("  才能: " + item.getTalentReq());
                    if (item.getDexterityReq() > 0) System.out.println("  敏捷: " + item.getDexterityReq());
                    if (item.getHealthReq() > 0) System.out.println("  体质: " + item.getHealthReq());
                }

                if (item.getMinDamage() > 0 || item.getMaxDamage() > 0) {
                    System.out.println("\n攻击属性:");
                    System.out.println("  攻击力: " + item.getMinDamage() + " - " + item.getMaxDamage());
                    if (item.getAttackSpeed() > 0) System.out.println("  攻击速度: " + item.getAttackSpeed());
                    if (item.getAttackRating() > 0) System.out.println("  命中率: " + item.getAttackRating());
                    if (item.getCriticalHit() > 0) System.out.println("  必杀率: " + item.getCriticalHit());
                }

                if (item.getDurability() > 0 || item.getMaxDurability() > 0) {
                    System.out.println("\n耐久度:");
                    System.out.println("  当前: " + item.getDurability());
                    System.out.println("  最大: " + item.getMaxDurability());
                }

                break;
            }
        }

        System.out.println("\n\n=== 测试完成 ===");
    }
}