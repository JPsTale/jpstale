package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.*;

import java.io.File;

/**
 * 测试数据加载功能
 */
public class TestDataLoading {
    public static void main(String[] args) {
        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        System.out.println("测试数据加载功能...");
        System.out.println("GameServer目录: " + gameServerDir.getAbsolutePath());
        System.out.println("目录存在: " + gameServerDir.exists());

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 加载数据
        long startTime = System.currentTimeMillis();
        DataConverter.loadAllData(gameServerDir, container);
        long endTime = System.currentTimeMillis();

        // 显示加载结果
        System.out.println("\n加载完成，耗时: " + (endTime - startTime) + " ms");
        System.out.println("------------------------");

        if (container.getMonsters() != null) {
            System.out.println("怪物数量: " + container.getMonsters().size());
            if (!container.getMonsters().isEmpty()) {
                System.out.println("示例怪物: " + container.getMonsters().get(0).getName());
            }
        }

        if (container.getNpcs() != null) {
            System.out.println("NPC数量: " + container.getNpcs().size());
            if (!container.getNpcs().isEmpty()) {
                System.out.println("示例NPC: " + container.getNpcs().get(0).getName());
            }
        }

        if (container.getItems() != null) {
            System.out.println("道具数量: " + container.getItems().size());
            if (!container.getItems().isEmpty()) {
                System.out.println("示例道具: " + container.getItems().get(0).getName());
            }
        }

        if (container.getMaps() != null) {
            System.out.println("地图数量: " + container.getMaps().size());
            if (!container.getMaps().isEmpty()) {
                System.out.println("示例地图: " + container.getMaps().get(0).getName());
            }
        }
    }
}