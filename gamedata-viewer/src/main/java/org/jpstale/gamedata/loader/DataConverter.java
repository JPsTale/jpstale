package org.jpstale.gamedata.loader;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;
import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.script.character.FallItem;
import org.jpstale.assets.plugins.script.character.Monster;
import org.jpstale.entity.item.Item;
import org.jpstale.entity.item.ItemConstant;
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
import java.util.Map;
import java.util.HashMap;

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

        // 先加载道具数据，以便怪物/NPC 的掉落与商店能解析为真实物品名
        loadItemData(container);

        Map<Long, SimpleItemData> codeToItem = buildCodeToItemMap(container.getItems());

        // 加载怪物数据（使用 codeToItem 解析掉落物）
        loadMonsterData(container, codeToItem);

        // 加载NPC数据（使用 codeToItem 解析商店物品）
        loadNPCData(container, codeToItem);

        // 加载地图数据
        loadMapData(container);
    }

    /**
     * 根据已加载的道具列表构建 code -> SimpleItemData 映射
     */
    private static Map<Long, SimpleItemData> buildCodeToItemMap(List<SimpleItemData> items) {
        Map<Long, SimpleItemData> map = new HashMap<>();
        if (items != null) {
            for (SimpleItemData item : items) {
                map.put(item.getItemCode(), item);
            }
        }
        return map;
    }

    /**
     * 加载怪物数据
     */
    private static void loadMonsterData(GameDataContainer container, Map<Long, SimpleItemData> codeToItem) {
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
                    SimpleMonsterData simpleData = convertToSimpleMonsterData(monster, baseName, codeToItem);
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
    private static void loadNPCData(GameDataContainer container, Map<Long, SimpleItemData> codeToItem) {
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
                    SimpleNPCData simpleData = convertToSimpleNPCData(npc, baseName, codeToItem);
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

        // 两件不通过文件加载的写死道具（与 ItemLoader 注释中的 Gold/Exp 一致）
        SimpleItemData gold = new SimpleItemData();
        gold.setId("GG101");
        gold.setItemCode(0x05010100L);
        gold.setName("Gold");
        gold.setCategory((int) (0x05010100L / 1000));
        gold.setWeight(0);
        items.add(gold);

        SimpleItemData exp = new SimpleItemData();
        exp.setId("GG102");
        exp.setItemCode(0x05010200L);
        exp.setName("Exp");
        exp.setCategory((int) (0x05010200L / 1000));
        exp.setWeight(0);
        items.add(exp);

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
    private static SimpleMonsterData convertToSimpleMonsterData(Monster monster, String id, Map<Long, SimpleItemData> codeToItem) {
        SimpleMonsterData data = new SimpleMonsterData();

        data.setId(id);
        data.setName(monster.szName != null ? monster.szName : id);
        data.setModelName(monster.szModelName);
        data.setLevel(monster.Level);

        // 基础属性
        data.setStrength(monster.Strength);
        data.setSpirit(monster.Spirit);
        data.setTalent(monster.Talent);
        data.setDexterity(monster.Dexterity);
        data.setHealth(monster.Health);
        data.setSizeLevel(monster.SizeLevel);
        data.setUndead(monster.Undead);

        // 怪物性质（主动/被动）
        data.setNature(monster.Nature == 0 ? "被动" : "主动");

        // 生命值使用最大值
        if (monster.Life != null && monster.Life.length > 1) {
            data.setLife(monster.Life[1]);
        }

        // 攻击力范围
        if (monster.Attack_Damage != null && monster.Attack_Damage.length >= 2) {
            data.setMinAttack(monster.Attack_Damage[0]);
            data.setMaxAttack(monster.Attack_Damage[1]);
        }

        // 战斗属性
        data.setAttackSpeed(monster.Attack_Speed);
        data.setAttackRating(monster.Attack_Rating);
        data.setCriticalHit(monster.Critical_Hit);
        data.setShootingRange(monster.Shooting_Range);
        data.setDefense(monster.Defence);
        data.setChanceBlock(monster.Chance_Block);
        data.setAbsorption(monster.Absorption);
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

        // 普通掉落物：名称 (0xCODE) (百分比%)
        if (monster.FallItems != null) {
            for (FallItem item : monster.FallItems) {
                if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                    if (dropInfo.length() > 0) dropInfo.append(", ");
                    dropInfo.append(itemCodeToDisplay(item.dwItemCode, codeToItem)).append(" (")
                           .append(item.Percentage).append("%)");
                }
            }
        }

        // 特殊掉落物（打孔宝石等稀有物品）
        if (monster.FallItems_Plus != null) {
            for (FallItem item : monster.FallItems_Plus) {
                if (item != null && item.dwItemCode > 0 && item.Percentage > 0) {
                    if (dropInfo.length() > 0) dropInfo.append(", ");
                    dropInfo.append("[+]").append(itemCodeToDisplay(item.dwItemCode, codeToItem)).append(" (")
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
    private static SimpleNPCData convertToSimpleNPCData(Monster npc, String id, Map<Long, SimpleItemData> codeToItem) {
        SimpleNPCData data = new SimpleNPCData();

        data.setId(id);
        data.setName(npc.szName != null ? npc.szName : id);
        data.setModelName(npc.szModelName);
        data.setLevel(npc.Level);

        // 判断是否是商人（通过检查是否有商品）
        boolean isShopkeeper = (npc.SellAttackItemCount > 0 ||
                               npc.SellDefenceItemCount > 0 ||
                               npc.SellEtcItemCount > 0);
        data.setShopkeeper(isShopkeeper);

        // 提取商店商品：名称 (0xCODE)
        if (isShopkeeper) {
            String[] attackItems = new String[npc.SellAttackItemCount];
            for (int i = 0; i < npc.SellAttackItemCount; i++) {
                attackItems[i] = itemCodeToDisplay(npc.SellAttackItem[i], codeToItem);
            }
            data.setSellAttackItems(attackItems);

            String[] defenceItems = new String[npc.SellDefenceItemCount];
            for (int i = 0; i < npc.SellDefenceItemCount; i++) {
                defenceItems[i] = itemCodeToDisplay(npc.SellDefenceItem[i], codeToItem);
            }
            data.setSellDefenceItems(defenceItems);

            String[] etcItems = new String[npc.SellEtcItemCount];
            for (int i = 0; i < npc.SellEtcItemCount; i++) {
                etcItems[i] = itemCodeToDisplay(npc.SellEtcItem[i], codeToItem);
            }
            data.setSellEtcItems(etcItems);
        }

        // 特殊功能
        StringBuilder functions = new StringBuilder();
        if (npc.SkillMaster == 1) functions.append("技能导师, ");
        if (npc.SkillChangeJob == 1) functions.append("转职NPC, ");
        if (npc.WareHouseMaster == 1) functions.append("仓库管理员, ");
        if (npc.ItemMix == 1) functions.append("物品合成, ");
        if (npc.ItemAging == 1) functions.append("装备锻造, ");
        if (npc.Smelting == 1) functions.append("装备精炼, ");
        if (npc.Manufacture == 1) functions.append("装备制造, ");
        if (npc.MixtureReset == 1) functions.append("属性重置, ");
        if (npc.SoketNPC == 1) functions.append("打孔镶嵌, ");
        if (npc.TelePortNpc == 1) functions.append("传送NPC, ");

        // 去掉最后的逗号空格
        if (functions.length() > 0) {
            functions = new StringBuilder(functions.substring(0, functions.length() - 2));
        }
        data.setFunctions(functions.toString());

        // NPC对话信息（取前3条）
        if (npc.NpcMessage != null && npc.NpcMsgCount > 0) {
            String[] messages = new String[Math.min(3, npc.NpcMsgCount)];
            for (int i = 0; i < messages.length; i++) {
                if (npc.NpcMessage[i] != null && !npc.NpcMessage[i].isEmpty()) {
                    messages[i] = npc.NpcMessage[i];
                }
            }
            data.setMessages(messages);
        }

        return data;
    }

    /**
     * 转换ItemInfo到SimpleItemData
     */
    private static SimpleItemData convertToSimpleItemData(ItemInfo item, String id) {
        SimpleItemData data = new SimpleItemData();

        data.setId(id);
        long code = item.CODE;
        // 若 loader 未解析出数值 CODE（仍为 0），用脚本中的字符串 code 在 ItemConstant 中查表
        if (code == 0 && item.code != null && !item.code.trim().isEmpty()) {
            String codeStr = item.code.trim().replace("\"", "");
            for (Item it : ItemConstant.itemDataBase) {
                if (it != null && it.category != null && it.category.equalsIgnoreCase(codeStr)) {
                    code = it.code & 0xFFFFFFFFL;
                    break;
                }
            }
        }
        data.setItemCode(code);
        data.setName((item.localeName != null && !item.localeName.isEmpty()) ? item.localeName : id);
        data.setEnName(item.enName);
        data.setCategory((int) (code / 1000)); // 简单的类别计算

        // 基础属性
        data.setPrice(item.Price);
        data.setWeight(item.Weight);

        // 需求属性
        if (item.require != null) {
            data.setLevel(item.require.level);
            data.setStrengthReq(item.require.strength);
            data.setSpiritReq(item.require.spirit);
            data.setTalentReq(item.require.talent);
            data.setDexterityReq(item.require.dexterity);
            data.setHealthReq(item.require.health);
        }

        // 攻击属性
        if (item.attack != null) {
            if (item.attack.Damage != null && item.attack.Damage.length >= 2) {
                data.setMinDamage(item.attack.Damage[0]);
                data.setMaxDamage(item.attack.Damage[1]);
            }
            data.setAttackSpeed(item.attack.Attack_Speed);
            if (item.attack.Attack_Rating != null && item.attack.Attack_Rating.length >= 2) {
                data.setAttackRating(item.attack.Attack_Rating[0]);
            }
            data.setCriticalHit(item.attack.Critical_Hit);
        }

        // 防御属性
        if (item.defence != null) {
            if (item.defence.Defence != null && item.defence.Defence.length >= 1) {
                data.setDefense((int) item.defence.Defence[0]);
            }
            if (item.defence.Block_Rating != null && item.defence.Block_Rating.length >= 1) {
                data.setChanceBlock((int) item.defence.Block_Rating[0]);
            }
            if (item.defence.Absorb != null && item.defence.Absorb.length >= 1) {
                data.setAbsorption((int) item.defence.Absorb[0]);
            }
        }

        // 元素抗性
        if (item.resistance != null) {
            if (item.resistance.Fire != null && item.resistance.Fire.length >= 1) {
                data.setFireResist(item.resistance.Fire[0]);
            }
            if (item.resistance.Ice != null && item.resistance.Ice.length >= 1) {
                data.setIceResist(item.resistance.Ice[0]);
            }
            if (item.resistance.Lighting != null && item.resistance.Lighting.length >= 1) {
                data.setLightningResist(item.resistance.Lighting[0]);
            }
            if (item.resistance.Poison != null && item.resistance.Poison.length >= 1) {
                data.setPoisonResist(item.resistance.Poison[0]);
            }
            if (item.resistance.Earth != null && item.resistance.Earth.length >= 1) {
                data.setEarthResist(item.resistance.Earth[0]);
            }
        }

        // 耐久度
        if (item.durability != null) {
            data.setDurability(item.durability.durabilityCur);
            data.setMaxDurability(item.durability.durabilityMax);
        }

        // 特殊效果（简化处理）
        StringBuilder effect = new StringBuilder();
        if (item.speed != null && item.speed.Speed != null && item.speed.Speed.length >= 1) {
            effect.append("移动速度+").append(item.speed.Speed[0]);
        }
        // 这里可以添加更多特殊效果的检测
        data.setSpecialEffect(effect.toString());

        return data;
    }


    /**
     * 将物品代码转换为展示字符串：名称 (0xCODE)；若未在道具表中则返回 未知(0xCODE)
     */
    private static String itemCodeToDisplay(long code, Map<Long, SimpleItemData> codeToItem) {
        String hex = String.format("0x%08X", code);
        SimpleItemData item = codeToItem != null ? codeToItem.get(code) : null;
        String name = (item != null && item.getName() != null) ? item.getName() : "未知";
        return name + " (" + hex + ")";
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