package org.jpstale.loader;

import java.util.ArrayList;

import com.jme3.system.JmeSystem;
import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.script.field.CharacterTransform;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;

@Slf4j
public class TestSpcLoader {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // JmeSystem.newAssetManager();
        // 初始化资源管理器
        AssetManager assetManager = new DesktopAssetManager();
        AssetFactory.setAssetManager(assetManager);

        // 读取地图的spc文件
        ArrayList<CharacterTransform> npcs = (ArrayList<CharacterTransform>) assetManager.loadAsset("GameServer/Field/fore-3.ase.spc");
        for (CharacterTransform npc : npcs) {
            log.info("" + npc.charInfo.szModelName);
            log.info("" + npc.charInfo.szModelName2);
            log.info("Lv:" + npc.charInfo.Level);
            log.info("HP:" + npc.charInfo.Life[0] + "/" + npc.charInfo.Life[1]);
            log.info("MP:" + npc.charInfo.Mana[0] + "/" + npc.charInfo.Mana[1]);
            log.info("SP:" + npc.charInfo.Stamina[0] + "/" + npc.charInfo.Stamina[1]);
            log.info("Position(" + npc.x + ", " + npc.y + ", " + npc.z + ")");
            log.info("Direction(" + npc.ax + ", " + npc.ay + ", " + npc.az + ")");
        }
    }

}
