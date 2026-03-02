package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.*;

import java.io.File;

/**
 * 测试所有功能
 */
public class TestAllFeatures {
    public static void main(String[] args) {
        System.out.println("=== JPsTale GameServer 配置查看器 - 功能测试 ===\n");

        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 加载数据
        long startTime = System.currentTimeMillis();
        DataConverter.loadAllData(gameServerDir, container);
        long loadTime = System.currentTimeMillis() - startTime;

        // 显示加载结果
        System.out.println("数据加载完成，耗时: " + loadTime + " ms");
        System.out.println("------------------------------------");
        System.out.println("怪物数量: " + container.getMonsters().size());
        System.out.println("NPC数量: " + container.getNpcs().size());
        System.out.println("道具数量: " + container.getItems().size());
        System.out.println("地图数量: " + container.getMaps().size());

        // 统计分析
        System.out.println("\n=== 数据统计 ===");

        // 怪物等级统计
        int maxLevel = 0;
        int minLevel = Integer.MAX_VALUE;
        for (SimpleMonsterData monster : container.getMonsters()) {
            maxLevel = Math.max(maxLevel, monster.getLevel());
            minLevel = Math.min(minLevel, monster.getLevel());
        }
        System.out.printf("怪物等级范围: %d - %d\n", minLevel, maxLevel);

        // NPC商人统计
        int shopkeeperCount = 0;
        for (SimpleNPCData npc : container.getNpcs()) {
            if (npc.isShopkeeper()) {
                shopkeeperCount++;
            }
        }
        System.out.printf("商人数量: %d / %d\n", shopkeeperCount, container.getNpcs().size());

        // 有怪物的地图
        int mapsWithMonsters = 0;
        for (SimpleMapData map : container.getMaps()) {
            if (map.getMonsterCount() > 0) {
                mapsWithMonsters++;
            }
        }
        System.out.printf("有怪物的地图: %d / %d\n", mapsWithMonsters, container.getMaps().size());

        // 示例数据
        System.out.println("\n=== 示例数据 ===");

        // 显示一个高级怪物
        System.out.println("\n高级怪物示例:");
        for (SimpleMonsterData monster : container.getMonsters()) {
            if (monster.getLevel() >= 120) {
                System.out.printf("  %-20s 等级:%3d 生命:%5d 攻击:%3d-%3d 经验:%6d\n",
                    monster.getName(), monster.getLevel(), monster.getLife(),
                    monster.getMinAttack(), monster.getMaxAttack(), monster.getExperience());
                break;
            }
        }

        // 显示一个商人
        System.out.println("\n商人NPC示例:");
        for (SimpleNPCData npc : container.getNpcs()) {
            if (npc.isShopkeeper()) {
                System.out.printf("  %s (ID: %s)\n", npc.getName(), npc.getId());
                break;
            }
        }

        // 显示一个有怪物的地图
        System.out.println("\n地图示例 (刷怪最多的地图):");
        SimpleMapData maxMonsterMap = null;
        for (SimpleMapData map : container.getMaps()) {
            if (maxMonsterMap == null || map.getMonsterCount() > maxMonsterMap.getMonsterCount()) {
                maxMonsterMap = map;
            }
        }
        if (maxMonsterMap != null) {
            System.out.printf("  %-20s 怪物数:%3d 等级:%3d-%3d\n",
                maxMonsterMap.getName(), maxMonsterMap.getMonsterCount(),
                maxMonsterMap.getMinLevel(), maxMonsterMap.getMaxLevel());
            if (maxMonsterMap.getMonsters() != null) {
                System.out.println("  主要怪物: " + maxMonsterMap.getMonsters());
            }
        }

        // 显示常见掉落物
        System.out.println("\n=== 掉落物统计 (前5个) ===");
        java.util.Map<String, Integer> dropCount = new java.util.TreeMap<>();
        for (SimpleMonsterData monster : container.getMonsters()) {
            if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                String drops = monster.getDropItems();
                String[] items = drops.split(", ");
                for (String item : items) {
                    if (item.contains("[")) {
                        String code = item.substring(item.indexOf("[") + 1, item.indexOf("]"));
                        dropCount.put(code, dropCount.getOrDefault(code, 0) + 1);
                    }
                }
            }
        }

        java.util.List<java.util.Map.Entry<String, Integer>> sortedDrops = new java.util.ArrayList<>(dropCount.entrySet());
        sortedDrops.sort(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByValue()));

        int count = 0;
        for (java.util.Map.Entry<String, Integer> entry : sortedDrops) {
            if (count >= 5) break;
            System.out.printf("  物品代码: %-10s 掉落该物品的怪物数: %3d\n", entry.getKey(), entry.getValue());
            count++;
        }

        System.out.println("\n=== 测试完成 ===");
        System.out.println("提示: 运行 GameDataViewer 类可以使用图形界面查看所有数据");
    }
}