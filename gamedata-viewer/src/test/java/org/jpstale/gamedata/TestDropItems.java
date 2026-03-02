package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.SimpleMonsterData;

import java.io.File;

/**
 * 测试怪物掉落物加载
 */
public class TestDropItems {
    public static void main(String[] args) {
        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        System.out.println("测试怪物掉落物加载功能...");
        System.out.println("GameServer目录: " + gameServerDir.getAbsolutePath());

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 只加载怪物数据
        DataConverter.loadAllData(gameServerDir, container);

        // 显示有掉落物的怪物
        if (container.getMonsters() != null && !container.getMonsters().isEmpty()) {
            System.out.println("\n成功加载的怪物数量: " + container.getMonsters().size());
            System.out.println("------------------------");

            int count = 0;
            int withDrops = 0;

            for (SimpleMonsterData monster : container.getMonsters()) {
                count++;

                if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                    withDrops++;
                    System.out.println("\n" + withDrops + ". " + monster.getName());
                    System.out.println("   等级: " + monster.getLevel());
                    System.out.println("   经验: " + monster.getExperience());
                    System.out.println("   掉落物: " + monster.getDropItems());
                }

                // 限制显示数量
                if (withDrops >= 10) {
                    System.out.println("\n... (显示前10个有掉落物的怪物)");
                    break;
                }
            }

            System.out.println("\n------------------------");
            System.out.println("在成功加载的 " + container.getMonsters().size() + " 个怪物中，有 " + withDrops + " 个配置了掉落物");
        } else {
            System.out.println("没有成功加载任何怪物数据");
        }
    }
}