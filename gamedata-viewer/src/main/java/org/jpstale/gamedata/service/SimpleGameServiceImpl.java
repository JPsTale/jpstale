package org.jpstale.gamedata.service;

import org.jpstale.gamedata.model.*;
import org.jpstale.gamedata.loader.*;

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

    // private final MonsterLoader monsterLoader = new MonsterLoader();
    // private final NPCLoader npcLoader = new NPCLoader();
    private final ItemListLoader itemLoader = new ItemListLoader();
    private final MapListLoader mapLoader = new MapListLoader();

    @Override
    public void loadGameData(File gameServerDir) {
        // 暂时不调用实际的加载器，防止编译错误
        // 使用测试数据
        loadTestData();
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