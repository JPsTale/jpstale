package org.jpstale.gamedata;

import org.jpstale.gamedata.loader.DataConverter;
import org.jpstale.gamedata.model.SimpleMonsterData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * 测试数据导出功能
 */
public class TestDataExport {
    public static void main(String[] args) {
        System.out.println("测试数据导出功能...");

        // 设置GameServer目录
        File gameServerDir = new File("/Users/yanmaoyuan/3060/GameServer");

        DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();

        // 加载数据
        DataConverter.loadAllData(gameServerDir, container);

        if (container.getMonsters() != null && !container.getMonsters().isEmpty()) {
            System.out.println("成功加载数据，怪物数量: " + container.getMonsters().size());

            // 测试JSON导出
            try {
                System.out.println("\n=== 测试JSON导出 ===");
                Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

                Map<String, Object> data = new HashMap<>();
                // 只导出前5个怪物作为测试
                data.put("monsters", container.getMonsters().subList(0, Math.min(5, container.getMonsters().size())));
                data.put("exportTime", new Date().toString());

                try (FileWriter writer = new FileWriter("test_export.json")) {
                    gson.toJson(data, writer);
                }

                System.out.println("JSON导出完成: test_export.json");

                // 测试Groovy导出
                System.out.println("\n=== 测试Groovy导出 ===");
                try (PrintWriter out = new PrintWriter(new FileWriter("test_export.groovy"))) {
                    out.println("// JPsTale GameServer Data Export");
                    out.println("// Exported at: " + new Date());
                    out.println();

                    // 导出前3个怪物作为测试
                    int count = 0;
                    for (SimpleMonsterData monster : container.getMonsters()) {
                        if (count >= 3) break;

                        out.printf("monster {\n");
                        out.printf("    id = '%s'\n", monster.getId());
                        out.printf("    name = '%s'\n", monster.getName());
                        out.printf("    level = %d\n", monster.getLevel());
                        out.printf("    life = %d\n", monster.getLife());
                        out.printf("    attack = [%d, %d]\n", monster.getMinAttack(), monster.getMaxAttack());
                        out.printf("    defense = %d\n", monster.getDefense());
                        out.printf("    exp = %d\n", monster.getExperience());
                        if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                            out.printf("    drops = '%s'\n", monster.getDropItems());
                        }
                        out.printf("}\n\n");

                        count++;
                    }
                }

                System.out.println("Groovy导出完成: test_export.groovy");

            } catch (Exception e) {
                System.err.println("导出失败: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            System.out.println("加载数据失败");
        }
    }
}