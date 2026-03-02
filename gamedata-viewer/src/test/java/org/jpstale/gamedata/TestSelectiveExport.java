package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

/**
 * 测试选择性数据导出功能
 */
public class TestSelectiveExport {
    public static void main(String[] args) {
        System.out.println("测试选择性数据导出功能...");

        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 加载数据
        DataConverter.loadAllData(gameServerDir, container);

        if (container.getMonsters() != null && !container.getMonsters().isEmpty()) {
            System.out.println("成功加载数据");
            System.out.println("怪物数量: " + container.getMonsters().size());
            System.out.println("NPC数量: " + container.getNpcs().size());
            System.out.println("道具数量: " + container.getItems().size());
            System.out.println("地图数量: " + container.getMaps().size());

            // 测试按导出类型分类
            System.out.println("\n=== 按导出类型测试 ===");

            // 1. 导出怪物数据
            exportMonsters(container, "export_monsters.groovy");

            // 2. 导出NPC数据
            exportNPCs(container, "export_npcs.groovy");

            // 3. 导出地图数据（包含刷怪点）
            exportMaps(container, "export_maps.groovy");

            // 4. 导出商人数据
            exportShopkeepers(container, "export_shopkeepers.groovy");

            // 5. 导出指定等级范围的怪物
            exportMonstersByLevel(container, 50, 100, "export_monsters_50_100.json");

        } else {
            System.out.println("加载数据失败");
        }
    }

    /**
     * 导出怪物数据
     */
    private static void exportMonsters(DataConverter.GameDataContainer container, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("// 怪物数据导出");
            out.println("// 导出时间: " + new Date());
            out.println();

            for (SimpleMonsterData monster : container.getMonsters()) {
                out.printf("monster {\n");
                out.printf("    id = '%s'\n", monster.getId());
                out.printf("    name = '%s'\n", monster.getName());
                out.printf("    level = %d\n", monster.getLevel());
                out.printf("    life = %d\n", monster.getLife());
                if (monster.getMinAttack() > 0 || monster.getMaxAttack() > 0) {
                    out.printf("    attack = [%d, %d]\n", monster.getMinAttack(), monster.getMaxAttack());
                }
                if (monster.getDefense() > 0) {
                    out.printf("    defense = %d\n", monster.getDefense());
                }
                out.printf("    exp = %d\n", monster.getExperience());

                // 元素抗性
                if (monster.getFire() > 0 || monster.getIce() > 0 || monster.getLightning() > 0
                    || monster.getPoison() > 0 || monster.getEarth() > 0) {
                    out.printf("    resistance = [fire:%d, ice:%d, lightning:%d, poison:%d, earth:%d]\n",
                        monster.getFire(), monster.getIce(), monster.getLightning(),
                        monster.getPoison(), monster.getEarth());
                }

                // 掉落物
                if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                    out.printf("    drops = '%s'\n", monster.getDropItems());
                }
                out.printf("}\n\n");
            }
            System.out.println("怪物数据导出完成: " + filename);
        } catch (Exception e) {
            System.err.println("怪物数据导出失败: " + e.getMessage());
        }
    }

    /**
     * 导出NPC数据
     */
    private static void exportNPCs(DataConverter.GameDataContainer container, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("// NPC数据导出");
            out.println("// 导出时间: " + new Date());
            out.println();

            for (SimpleNPCData npc : container.getNpcs()) {
                out.printf("npc {\n");
                out.printf("    id = '%s'\n", npc.getId());
                out.printf("    name = '%s'\n", npc.getName());
                out.printf("    level = %d\n", npc.getLevel());
                out.printf("    isShopkeeper = %s\n", npc.isShopkeeper());
                out.printf("}\n\n");
            }
            System.out.println("NPC数据导出完成: " + filename);
        } catch (Exception e) {
            System.err.println("NPC数据导出失败: " + e.getMessage());
        }
    }

    /**
     * 导出地图数据
     */
    private static void exportMaps(DataConverter.GameDataContainer container, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("// 地图数据导出");
            out.println("// 导出时间: " + new Date());
            out.println();

            for (SimpleMapData map : container.getMaps()) {
                out.printf("map {\n");
                out.printf("    id = '%s'\n", map.getId());
                out.printf("    name = '%s'\n", map.getName());
                out.printf("    levelRange = [%d, %d]\n", map.getMinLevel(), map.getMaxLevel());

                if (map.getMonsterCount() > 0) {
                    out.printf("    monsterCount = %d\n", map.getMonsterCount());
                    out.printf("    respawnTime = %d\n", map.getRespawnTime());

                    if (map.getMonsters() != null && !map.getMonsters().isEmpty()) {
                        out.printf("    monsters = '%s'\n", map.getMonsters());
                    }
                }

                if (map.isHasStartPoint()) {
                    out.printf("    hasStartPoint = true\n");
                }

                out.printf("}\n\n");
            }
            System.out.println("地图数据导出完成: " + filename);
        } catch (Exception e) {
            System.err.println("地图数据导出失败: " + e.getMessage());
        }
    }

    /**
     * 导出商人数据
     */
    private static void exportShopkeepers(DataConverter.GameDataContainer container, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("// 商人数据导出");
            out.println("// 导出时间: " + new Date());
            out.println();

            int shopkeeperCount = 0;
            for (SimpleNPCData npc : container.getNpcs()) {
                if (npc.isShopkeeper()) {
                    shopkeeperCount++;
                    out.printf("shopkeeper {\n");
                    out.printf("    id = '%s'\n", npc.getId());
                    out.printf("    name = '%s'\n", npc.getName());
                    out.printf("    level = %d\n", npc.getLevel());
                    out.printf("}\n\n");
                }
            }
            System.out.println("商人数据导出完成: " + filename + " (共 " + shopkeeperCount + " 个商人)");
        } catch (Exception e) {
            System.err.println("商人数据导出失败: " + e.getMessage());
        }
    }

    /**
     * 按等级导出怪物数据（JSON格式）
     */
    private static void exportMonstersByLevel(DataConverter.GameDataContainer container,
                                           int minLevel, int maxLevel, String filename) {
        try {
            // 筛选指定等级范围的怪物
            List<SimpleMonsterData> filteredMonsters = new ArrayList<>();
            for (SimpleMonsterData monster : container.getMonsters()) {
                if (monster.getLevel() >= minLevel && monster.getLevel() <= maxLevel) {
                    filteredMonsters.add(monster);
                }
            }

            // 使用Gson导出
            Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

            Map<String, Object> data = new HashMap<>();
            data.put("levelRange", String.format("[%d, %d]", minLevel, maxLevel));
            data.put("monsters", filteredMonsters);
            data.put("count", filteredMonsters.size());
            data.put("exportTime", new Date().toString());

            try (FileWriter writer = new FileWriter(filename)) {
                gson.toJson(data, writer);
            }

            System.out.printf("等级 %d-%d 的怪物数据导出完成: %s (共 %d 个)\n",
                minLevel, maxLevel, filename, filteredMonsters.size());

        } catch (Exception e) {
            System.err.println("按等级导出怪物数据失败: " + e.getMessage());
        }
    }
}