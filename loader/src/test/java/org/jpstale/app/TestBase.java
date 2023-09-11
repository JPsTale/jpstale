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

    public TestBase() {
        super();
        AppSettings settings = new AppSettings(true);
        settings.setResolution(1280, 720);
        settings.setSamples(4);
        super.setSettings(settings);
    }

    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);

        stateManager.attach(new CheckerBoardState());
        stateManager.attach(new AxisAppState());

        init();
    }

    public abstract void init();
}
