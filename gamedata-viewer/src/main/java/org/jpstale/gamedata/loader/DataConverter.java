package org.jpstale.gamedata.loader;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;
import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.script.character.FallItem;
import org.jpstale.assets.plugins.script.character.Monster;
import org.jpstale.entity.item.ItemInfo;
import org.jpstale.entity.field.RespawnList;
import org.jpstale.entity.field.StartPoint;
import org.jpstale.entity.field.StgMonster;
import org.jpstale.entity.field.StgBoss;
import org.jpstale.assets.plugins.script.field.CharacterTransform;
import org.jpstale.gamedata.model.SimpleMonsterData;
import org.jpstale.gamedata.model.SimpleNPCData;
import org.jpstale.gamedata.model.SimpleItemData;
import org.jpstale.gamedata.model.SimpleMapData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于将AssetFactory加载的原始数据转换为简化版的GUI数据模型
 */
public class DataConverter {
    private static String gameRootPath;

    /**
     * 从GameServer目录加载所有数据
     */
    public static void loadAllData(File gameServerDir, GameDataContainer container) {
        if (gameServerDir == null || !gameServerDir.exists()) {
            return;
        }

        // 获取游戏根目录（GameServer的上一级目录）
        gameRootPath = gameServerDir.getParent();
        if (gameRootPath == null || !new File(gameRootPath).exists()) {
            return;
        }

        // 初始化资源管理器
        AssetManager assetManager = new DesktopAssetManager();
        AssetFactory.setAssetManager(assetManager);

        // 设置游戏资源目录
        AssetFactory.setFolder(gameRootPath);

        // 加载怪物数据
        loadMonsterData(container);

        // 加载NPC数据
        loadNPCData(container);

        // 加载道具数据
        loadItemData(container);

        // 加载地图数据
        loadMapData(container);
    }

    /**
     * 加载怪物数据
     */
    private static void loadMonsterData(GameDataContainer container) {
        File monsterDir = new File(gameRootPath, "GameServer/Monster");
        if (!monsterDir.exists()) {
            return;
        }

        File[] infFiles = monsterDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".inf"));
        if (infFiles == null) {
            return;
        }

        List<SimpleMonsterData> monsters = new ArrayList<>();
        for (File infFile : infFiles) {
            try {
                String fileName = infFile.getName();
                String baseName = fileName.substring(0, fileName.lastIndexOf('.'));

                Monster monster = AssetFactory.loadMonsterScript(baseName);
                if (monster != null) {
                    SimpleMonsterData simpleData = convertToSimpleMonsterData(monster, baseName);
                    monsters.add(simpleData);
                }
            } catch (Exception e) {
                System.err.println("Failed to load monster file: " + infFile.getName() + ", error: " + e.getMessage());
            }
        }

        container.setMonsters(monsters);
    }

    /**
     * 加载NPC数据
     */
    private static void loadNPCData(GameDataContainer container) {
        File npcDir = new File(gameRootPath, "GameServer/NPC");
        if (!npcDir.exists()) {
            return;
        }

        File[] npcFiles = npcDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".npc"));
        if (npcFiles == null) {
            return;
        }

        List<SimpleNPCData> npcs = new ArrayList<>();
        for (File npcFile : npcFiles) {
            try {
                String fileName = npcFile.getName();
                String baseName = fileName.substring(0, fileName.lastIndexOf('.'));

                Monster npc = AssetFactory.loadNpcScript(baseName);
                if (npc != null) {
                    SimpleNPCData simpleData = convertToSimpleNPCData(npc, baseName);
                    npcs.add(simpleData);
                }
            } catch (Exception e) {
                System.err.println("Failed to load NPC file: " + npcFile.getName() + ", error: " + e.getMessage());
            }
        }

        container.setNpcs(npcs);
    }

    /**
     * 加载道具数据
     */
    private static void loadItemData(GameDataContainer container) {
        File itemDir = new File(gameRootPath, "GameServer/OpenItem");
        if (!itemDir.exists()) {
            return;
        }

        File[] txtFiles = itemDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (txtFiles == null) {
            return;
        }

        List<SimpleItemData> items = new ArrayList<>();
        for (File txtFile : txtFiles) {
            try {
                String fileName = txtFile.getName();
                String baseName = fileName.substring(0, fileName.lastIndexOf('.'));

                ItemInfo item = AssetFactory.loadItemScript(baseName);
                if (item != null) {
                    SimpleItemData simpleData = convertToSimpleItemData(item, baseName);
                    items.add(simpleData);
                }
            } catch (Exception e) {
                System.err.println("Failed to load item file: " + txtFile.getName() + ", error: " + e.getMessage());
            }
        }

        container.setItems(items);
    }

    /**
     * 加载地图数据
     */
    private static void loadMapData(GameDataContainer container) {
        File fieldDir = new File(gameRootPath, "GameServer/Field");
        if (!fieldDir.exists()) {
            return;
        }

        // 获取所有地图文件（去掉扩展名后的唯一名称）
        List<String> mapNames = new ArrayList<>();
        File[] files = fieldDir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            String name = file.getName();
            if (name.endsWith(".spm") || name.endsWith(".spp") || name.endsWith(".spc")) {
                // 去掉扩展名
                String mapName = name.substring(0, name.lastIndexOf('.'));
                // 如果文件名是 XXX.ase.spm 格式，去掉 .ase
                if (mapName.endsWith(".ase")) {
                    mapName = mapName.substring(0, mapName.length() - 4);
                }
                if (!mapNames.contains(mapName)) {
                    mapNames.add(mapName);
                }
            }
        }

        List<SimpleMapData> maps = new ArrayList<>();
        for (String mapName : mapNames) {
            try {
                SimpleMapData simpleData = loadFieldData(mapName);
                if (simpleData != null) {
                    maps.add(simpleData);
                }
            } catch (Exception e) {
                System.err.println("Failed to load map data for: " + mapName + ", error: " + e.getMessage());
            }
        }

        container.setMaps(maps);
    }

    /**
     * 加载单个地图的所有Field数据
     */
    private static SimpleMapData loadFieldData(String mapName) {
        SimpleMapData mapData = new SimpleMapData();
        mapData.setId(mapName);
        mapData.setName(mapName);
        mapData.setMinLevel(1);
        mapData.setMaxLevel(100);

        // 加载刷怪点数据 (SPM)
        RespawnList respawnList = AssetFactory.loadSpm(mapName);
        if (respawnList != null && respawnList.hasMonster()) {
            mapData.setMonsterCount(respawnList.monsterList.size() + respawnList.bossList.size());
            mapData.setRespawnTime(respawnList.OpenInterval);

            // 设置怪物描述
            StringBuilder monsterDesc = new StringBuilder();
            for (StgMonster monster : respawnList.monsterList) {
                if (monsterDesc.length() > 0) monsterDesc.append(", ");
                monsterDesc.append(monster.name);
            }
            if (respawnList.bossList.size() > 0) {
                if (monsterDesc.length() > 0) monsterDesc.append("; ");
                monsterDesc.append("Boss: ");
                boolean firstBoss = true;
                for (StgBoss boss : respawnList.bossList) {
                    if (!firstBoss) {
                        monsterDesc.append(", ");
                    }
                    monsterDesc.append(boss.name);
                    firstBoss = false;
                }
            }
            mapData.setMonsters(monsterDesc.toString());
        }

        // 加载出生点数据 (SPP)
        ArrayList<StartPoint> startPoints = AssetFactory.loadSpp(mapName);
        if (startPoints != null && !startPoints.isEmpty()) {
            mapData.setHasStartPoint(true);
            // mapData.setSpawnPointCount(startPoints.size()); // TODO: 添加这个方法
        }

        // 加载NPC数据 (SPC)
        ArrayList<CharacterTransform> npcs = AssetFactory.loadSpc(mapName);
        if (npcs != null && !npcs.isEmpty()) {
            // mapData.setNpcCount(npcs.size()); // TODO: 添加这个方法
        }

        return mapData;
    }

    /**
     * 转换Monster到SimpleMonsterData
     */
    private static SimpleMonsterData convertToSimpleMonsterData(Monster monster, String id) {
        SimpleMonsterData data = new SimpleMonsterData();

        data.setId(id);
        data.setName(monster.szName != null ? monster.szName : id);
        data.setLevel(monster.Level);

        // 生命值使用最大值
        if (monster.Life != null && monster.Life.length > 1) {
            data.setLife(monster.Life[1]);
        }

        // 攻击力范围
        if (monster.Attack_Damage != null && monster.Attack_Damage.length >= 2) {
            data.setMinAttack(monster.Attack_Damage[0]);
            data.setMaxAttack(monster.Attack_Damage[1]);
        }

        data.setDefense(monster.Defence);
        data.setExperience(monster.GetExp);
        data.setMoveSpeed((float) (monster.Move_Speed / 100.0)); // 转换为浮点数
        data.setSight(monster.Sight);

        // 元素抗性（Resistance数组的前5个通常对应火、冰、雷、毒、土）
        if (monster.Resistance != null && monster.Resistance.length >= 5) {
            data.setFire(monster.Resistance[0]);
            data.setIce(monster.Resistance[1]);
            data.setLightning(monster.Resistance[2]);
            data.setPoison(monster.Resistance[3]);
            data.setEarth(monster.Resistance[4]);
        }

        // 提取掉落物信息
        StringBuilder dropInfo = new StringBuilder();

        // 普通掉落物
        if (monster.FallItems != null) {
            for (FallItem item : monster.FallItems) {
                // 检查item是否为null
                if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                    if (dropInfo.length() > 0) dropInfo.append(", ");
                    dropInfo.append(itemCodeToName(item.dwItemCode)).append(" (")
                           .append(item.Percentage).append("%)");
                }
            }
        }

        // 特殊掉落物（打孔宝石等稀有物品）
        if (monster.FallItems_Plus != null) {
            for (FallItem item : monster.FallItems_Plus) {
                // 检查item是否为null
                if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                    if (dropInfo.length() > 0) dropInfo.append(", ");
                    dropInfo.append("[+]").append(itemCodeToName(item.dwItemCode)).append(" (")
                           .append(item.Percentage).append("%)");
                }
            }
        }

        data.setDropItems(dropInfo.toString());

        return data;
    }

    /**
     * 转换Monster到SimpleNPCData
     */
    private static SimpleNPCData convertToSimpleNPCData(Monster npc, String id) {
        SimpleNPCData data = new SimpleNPCData();

        data.setId(id);
        data.setName(npc.szName != null ? npc.szName : id);
        data.setLevel(npc.Level);

        // 判断是否是商人（通过检查是否有商品）
        boolean isShopkeeper = (npc.SellAttackItemCount > 0 ||
                               npc.SellDefenceItemCount > 0 ||
                               npc.SellEtcItemCount > 0);
        data.setShopkeeper(isShopkeeper);

        return data;
    }

    /**
     * 转换ItemInfo到SimpleItemData
     */
    private static SimpleItemData convertToSimpleItemData(ItemInfo item, String id) {
        SimpleItemData data = new SimpleItemData();

        data.setId(id);
        data.setName((item.localeName != null && !item.localeName.isEmpty()) ? item.localeName : id);
        data.setCategory((int) (item.CODE / 1000)); // 简单的类别计算

        // 等级需求
        if (item.require != null) {
            data.setLevel(item.require.level);
        }

        data.setPrice(item.Price);
        data.setWeight(item.Weight);

        // 攻击力
        if (item.attack != null && item.attack.Damage != null && item.attack.Damage.length >= 2) {
            data.setMinAttack(item.attack.Damage[0]);
            data.setMaxAttack(item.attack.Damage[1]);
        }

        // 防御力
        if (item.defence != null && item.defence.Absorb != null && item.defence.Absorb.length >= 1) {
            data.setDefense((int) item.defence.Absorb[0]);
        }

        return data;
    }


    /**
     * 将物品代码转换为名称（简化版本）
     */
    private static String itemCodeToName(long code) {
        // 某些常见的物品代码映射
        switch ((int)code) {
            // 常见材料
            case 8: return "力量药水";
            case 9: return "魔法药水";
            case 10: return "体力药水";
            case 11: return "精神药水";
            case 12: return "全体药水";

            // 常见装备类型代码的前缀
            case 1: return "武器";
            case 2: return "防具";
            case 3: return "饰品";
            case 4: return "双手武器";
            case 5: return "消耗品";

            // 某些特殊物品
            case 1001: return "打孔钻1";
            case 1002: return "打孔钻2";
            case 1003: return "打孔钻3";

            default:
                // 根据物品代码返回分类
                int category = (int)(code / 1000);
                if (category == 1) return "武器[" + code + "]";
                if (category == 2) return "防具[" + code + "]";
                if (category == 3) return "饰品[" + code + "]";
                if (category == 4) return "双手[" + code + "]";
                if (category == 5) return "消耗品[" + code + "]";
                return "物品[" + code + "]";
        }
    }

    /**
     * 数据容器类，用于存储所有加载的数据
     */
    public static class GameDataContainer {
        private List<SimpleMonsterData> monsters;
        private List<SimpleNPCData> npcs;
        private List<SimpleItemData> items;
        private List<SimpleMapData> maps;

        public List<SimpleMonsterData> getMonsters() {
            return monsters;
        }

        public void setMonsters(List<SimpleMonsterData> monsters) {
            this.monsters = monsters;
        }

        public List<SimpleNPCData> getNpcs() {
            return npcs;
        }

        public void setNpcs(List<SimpleNPCData> npcs) {
            this.npcs = npcs;
        }

        public List<SimpleItemData> getItems() {
            return items;
        }

        public void setItems(List<SimpleItemData> items) {
            this.items = items;
        }

        public List<SimpleMapData> getMaps() {
            return maps;
        }

        public void setMaps(List<SimpleMapData> maps) {
            this.maps = maps;
        }
    }
}