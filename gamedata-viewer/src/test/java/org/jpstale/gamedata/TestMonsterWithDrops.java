package org.jpstale.gamedata;

import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.script.character.FallItem;
import org.jpstale.assets.plugins.script.character.Monster;
import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;

/**
 * 测试怪物掉落物详细显示
 */
public class TestMonsterWithDrops {
    public static void main(String[] args) {
        System.out.println("测试怪物掉落物详细显示...");

        // 设置路径
        String gameRootPath = "/Users/yanmaoyuan/3060";
        AssetManager assetManager = new DesktopAssetManager();
        AssetFactory.setAssetManager(assetManager);
        AssetFactory.setFolder(gameRootPath);

        // 确保路径正确
        if (!AssetFactory.checkServerRoot(gameRootPath)) {
            System.err.println("游戏根目录验证失败: " + gameRootPath);
            return;
        }

        // 测试几个不同的怪物
        String[] testMonsters = {
            "00_Santagoblin-C",  // 圣诞精灵
            "magic_war",       // 魔法魔兽兵
            "10_Mouse",        // 老鼠
            "20_Robot"         // 机器人
        };

        for (String monsterName : testMonsters) {
            System.out.println("\n=================" + monsterName + "=================");

            Monster monster = AssetFactory.loadMonsterScript(monsterName);

            if (monster != null) {
                System.out.println("怪物名称: " + monster.szName);
                System.out.println("等级: " + monster.Level);
                System.out.println("经验值: " + monster.GetExp);

                // 显示攻击力
                if (monster.Attack_Damage != null && monster.Attack_Damage.length >= 2) {
                    System.out.println("攻击力: " + monster.Attack_Damage[0] + " - " + monster.Attack_Damage[1]);
                }

                // 显示掉落物
                System.out.println("\n掉落物:");

                boolean hasItems = false;

                // 普通掉落物
                if (monster.FallItems != null) {
                    int count = 0;
                    for (FallItem item : monster.FallItems) {
                        if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                            System.out.println("  " + (++count) + ". [普通] " + item.dwItemCode
                                    + " (概率: " + item.Percentage + "%, 价格: "
                                    + (item.sPrice != null ? item.sPrice[0] + "-" + item.sPrice[1] : "未知") + ")");
                            hasItems = true;
                        }
                    }
                }

                // 特殊掉落物
                if (monster.FallItems_Plus != null) {
                    int count = 0;
                    for (FallItem item : monster.FallItems_Plus) {
                        if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                            System.out.println("  [+" + (++count) + ".] [特殊] " + item.dwItemCode
                                    + " (概率: " + item.Percentage + "%, 价格: "
                                    + (item.sPrice != null ? item.sPrice[0] + "-" + item.sPrice[1] : "未知") + ")");
                            hasItems = true;
                        }
                    }
                }

                if (!hasItems) {
                    System.out.println("  无掉落物配置");
                }

            } else {
                System.out.println("加载失败: " + monsterName);
            }
        }
    }
}