package org.jpstale.loader;

import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.AssetFactory;
import org.jpstale.entity.field.RespawnList;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;

import java.util.logging.Logger;

@Slf4j
public class TestSpmLoader {

    public static void main(String[] args) {
        // 初始化资源管理器
        AssetManager assetManager = new DesktopAssetManager();
        AssetFactory.setAssetManager(assetManager);

        // 读取地图的spc文件
        RespawnList respawn = (RespawnList) assetManager.loadAsset("GameServer/Field/Fore-3.ase.spm");

        log.info("limitMax:{}, intervalTime:{}, openLimit:{}, percentageCtn:{}", respawn.LimitMax, respawn.IntervalTime, respawn.OpenLimit, respawn.PercentageCnt);
        log.info("hasMonster:{}, bossCount:{}, bossList:{}, monsterList:{}", respawn.hasMonster(), respawn.BossMonsterCount, respawn.bossList, respawn.monsterList);
    }

}
