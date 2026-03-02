package org.jpstale.gamedata.service;

import org.jpstale.gamedata.model.*;
import org.jpstale.gamedata.loader.DataConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 简化版游戏数据服务实现
 */
public class SimpleGameServiceImpl implements SimpleGameDataService {

    private List<SimpleMonsterData> monsters = new ArrayList<>();
    private List<SimpleNPCData> npcs = new ArrayList<>();
    private List<SimpleItemData> items = new ArrayList<>();
    private List<SimpleMapData> maps = new ArrayList<>();

    @Override
    public void loadGameData(File gameServerDir) {
        if (gameServerDir == null) {
            // 如果没有指定目录，加载测试数据
            loadTestData();
        } else {
            System.out.println("正在从GameServer目录加载数据: " + gameServerDir.getAbsolutePath());

            // 使用 DataConverter 加载真实数据
            DataConverter.GameDataContainer container = new DataConverter.GameDataContainer();
            DataConverter.loadAllData(gameServerDir, container);

            // 将加载的数据保存到服务中
            monsters = container.getMonsters() != null ? container.getMonsters() : new ArrayList<>();
            npcs = container.getNpcs() != null ? container.getNpcs() : new ArrayList<>();
            items = container.getItems() != null ? container.getItems() : new ArrayList<>();
            maps = container.getMaps() != null ? container.getMaps() : new ArrayList<>();

            System.out.println("数据加载完成!");
            System.out.println(" - 怪物: " + monsters.size() + " 个");
            System.out.println(" - NPC: " + npcs.size() + " 个");
            System.out.println(" - 道具: " + items.size() + " 个");
            System.out.println(" - 地图: " + maps.size() + " 个");
        }
    }

    private void loadTestData() {
        // 测试怪物数据
        SimpleMonsterData monster = new SimpleMonsterData();
        monster.setId("test");
        monster.setName("测试怪物");
        monster.setLevel(10);
        monsters.add(monster);

        // 测试NPC数据
        SimpleNPCData npc = new SimpleNPCData();
        npc.setId("npc1");
        npc.setName("测试NPC");
        npc.setShopkeeper(true);
        npcs.add(npc);

        // 测试道具数据
        SimpleItemData item = new SimpleItemData();
        item.setId("item1");
        item.setName("测试道具");
        item.setCategory(1);
        item.setLevel(5);
        item.setPrice(100);
        items.add(item);

        // 测试地图数据
        SimpleMapData map = new SimpleMapData();
        map.setId("map1");
        map.setName("测试地图");
        map.setMinLevel(1);
        map.setMaxLevel(10);
        maps.add(map);
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