package org.jpstale.app;


import com.jme3.app.SimpleApplication;

import com.jme3.system.AppSettings;
import org.jpstale.assets.AssetFactory;

/**
 * 测试基类，主要是注册SmdLoader之类的东西。
 * 
 * @author yanmaoyuan
 *
 */
public abstract class TestBase extends SimpleApplication {

    TestBase() {
        super();
        AppSettings settings = new AppSettings(true);
        super.setSettings(settings);
    }

    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);

        stateManager.attach(new CheckerBoardState());

        init();
    }

    public abstract void init();
}
