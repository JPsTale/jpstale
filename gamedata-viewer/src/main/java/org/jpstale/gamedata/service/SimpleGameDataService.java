package org.jpstale.gamedata.service;

import org.jpstale.gamedata.model.*;

import java.io.File;
import java.util.List;

/**
 * 简化版游戏数据服务接口
 */
public interface SimpleGameDataService {
    void loadGameData(File gameServerDir);
    List<SimpleMonsterData> getAllMonsters();
    List<SimpleNPCData> getAllNPCs();
    List<SimpleItemData> getAllItems();
    List<SimpleMapData> getAllMaps();
}