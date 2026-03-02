package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.SimpleMapData;

import java.io.File;

/**
 * 测试Field数据加载
 */
public class TestFieldData {
    public static void main(String[] args) {
        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        System.out.println("测试Field数据加载功能...");
        System.out.println("GameServer目录: " + gameServerDir.getAbsolutePath());

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 只加载Field数据
        DataConverter.loadAllData(gameServerDir, container);

        // 显示加载的地图信息
        if (container.getMaps() != null && !container.getMaps().isEmpty()) {
            System.out.println("\n成功加载的地图数量: " + container.getMaps().size());
            System.out.println("------------------------");

            int count = 0;
            for (SimpleMapData map : container.getMaps()) {
                count++;
                System.out.println("\n地图 " + count + ": " + map.getName());
                System.out.println("  ID: " + map.getId());
                System.out.println("  怪物数量: " + map.getMonsterCount());

                if (map.getRespawnTime() > 0) {
                    System.out.println("  刷新间隔: " + map.getRespawnTime() + " 秒");
                }

                if (map.getMonsters() != null && !map.getMonsters().isEmpty()) {
                    System.out.println("  怪物列表: " + map.getMonsters());
                }

                if (map.isHasStartPoint()) {
                    System.out.println("  ✓ 有出生点");
                }

                if (count >= 5) {
                    System.out.println("\n... (显示前5个地图)");
                    break;
                }
            }
        } else {
            System.out.println("没有加载到任何地图数据");
        }
    }
}