package org.jpstale.app;


import com.jme3.app.SimpleApplication;

import org.jpstale.assets.AssetFactory;

/**
 * 测试基类，主要是注册SmdLoader之类的东西。
 * 
 * @author yanmaoyuan
 *
 */
public abstract class TestBase extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);

        stateManager.attach(new CheckerBoardState());

        init();
    }

    public abstract void init();
}
