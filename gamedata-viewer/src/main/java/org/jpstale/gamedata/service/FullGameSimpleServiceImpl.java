package org.jpstale.gamedata.service;

import org.jpstale.gamedata.model.*;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**
 * 简化版完整游戏数据服务实现
 * 暂时不使用 AssetFactory，避免依赖问题
 */
public class FullGameSimpleServiceImpl implements SimpleGameDataService {

    private List<SimpleMonsterData> monsters = new ArrayList<>();
    private List<SimpleNPCData> npcs = new ArrayList<>();
    private List<SimpleItemData> items = new ArrayList<>();
    private List<SimpleMapData> maps = new ArrayList<>();

    @Override
    public void loadGameData(File gameServerDir) {
        // 为演示目的，创建更多的测试数据
        loadExtendedTestData();
    }

    private void loadExtendedTestData() {
        // 加载更多怪物数据
        for (int i = 0; i < 10; i++) {
            SimpleMonsterData monster = new SimpleMonsterData();
            monster.setId("monster_" + (i + 1));
            monster.setName("完整加载器怪物 " + (i + 1));
            monster.setLevel(10 + i * 5);
            monster.setLife(100 + i * 50);
            monster.setMinAttack(15 + i * 5);
            monster.setMaxAttack(25 + i * 5);
            monster.setDefense(5 + i * 3);
            monster.setExperience(100 + i * 100);
            monsters.add(monster);
        }

        // 加载更多NPC数据
        for (int i = 0; i < 5; i++) {
            SimpleNPCData npc = new SimpleNPCData();
            npc.setId("npc_" + (i + 1));
            npc.setName("完整加载器NPC " + (i + 1));
            if (i % 2 == 0) {
                npc.setShopkeeper(true);
            } else {
                npc.setShopkeeper(false);
            }
            npcs.add(npc);
        }

        // 加载更多道具数据
        for (int i = 0; i < 20; i++) {
            SimpleItemData item = new SimpleItemData();
            item.setId("item_" + (i + 1));
            item.setName("完整加载器道具 " + (i + 1));
            item.setCategory(i % 4 + 1);
            item.setLevel(i + 1);
            item.setPrice(100 * (i + 1));
            items.add(item);
        }

        // 加载更多地图数据
        for (int i = 0; i < 5; i++) {
            SimpleMapData map = new SimpleMapData();
            map.setId("map_" + (i + 1));
            map.setName("完整加载器地图 " + (i + 1));
            map.setMinLevel(1 + i * 10);
            map.setMaxLevel(10 + i * 10);
            maps.add(map);
        }
    }

    @Override
    public List<SimpleMonsterData> getAllMonsters() {
        return monsters;
    }

    @Override
    public List<SimpleNPCData> getAllNPCs() {
        return npcs;
    }

    @Override
    public List<SimpleItemData> getAllItems() {
        return items;
    }

    @Override
    public List<SimpleMapData> getAllMaps() {
        return maps;
    }
}