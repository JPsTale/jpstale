package org.jpstale.gamedata;

import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.script.character.Monster;
import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;

/**
 * 测试单个怪物加载
 */
public class TestSingleMonster {
    public static void main(String[] args) {
        System.out.println("测试单个怪物加载...");

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

        // 尝试加载一个简单的怪物
        String monsterName = "00_Santagoblin-C";
        System.out.println("尝试加载怪物: " + monsterName);

        Monster monster = AssetFactory.loadMonsterScript(monsterName);

        if (monster != null) {
            System.out.println("成功加载怪物!");
            System.out.println("名称: " + monster.szName);
            System.out.println("等级: " + monster.Level);
            System.out.println("掉落物数量: " + (monster.FallItems != null ? monster.FallItems.length : 0));

            // 显示掉落物
            if (monster.FallItems != null) {
                for (int i = 0; i < monster.FallItems.length; i++) {
                    if (monster.FallItems[i].dwItemCode > 0) {
                        System.out.println("  掉落物 " + i + ": 代码=" + monster.FallItems[i].dwItemCode
                                + ", 概率=" + monster.FallItems[i].Percentage + "%");
                    }
                }
            }
        } else {
            System.out.println("加载失败");
        }
    }
}