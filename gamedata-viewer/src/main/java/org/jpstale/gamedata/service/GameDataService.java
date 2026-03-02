package org.jpstale.gamedata.service;

import org.jpstale.gamedata.model.*;

import java.io.File;
import java.util.List;

/**
 * 简化版游戏数据服务接口
 */
public interface GameDataService {
    void loadGameData(File gameServerDir);

    /** 返回上次加载的 GameServer 所在目录的父路径（游戏根目录）；未加载过目录时可为 null。 */
    String getGameRootPath();

    /**
     * 返回客户端资源根目录（含 char/、image/ 等），用于 3D 预览加载模型与贴图。
     * 若未单独设置，则与 getGameRootPath() 一致；若客户端在另一目录（如 PTCN2020），需通过「设置客户端资源目录」指定。
     */
    String getClientRootPath();

    void setClientRootPath(String path);

    List<SimpleMonsterData> getAllMonsters();
    List<SimpleNPCData> getAllNPCs();
    List<SimpleItemData> getAllItems();
    List<SimpleMapData> getAllMaps();
}