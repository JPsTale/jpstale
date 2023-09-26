package org.jpstale.test;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.Materials;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.system.AppSettings;

/**
 * desc:
 *
 * @author yanmaoyuan
 * @date 2023/9/21
 */
public class TestSimplified extends SimpleApplication {
    @Override
    public void simpleInitApp() {
        Geometry model = (Geometry) assetManager.loadModel("simplify_styled.obj");
        Material material = new Material(assetManager, Materials.UNSHADED);
        material.getAdditionalRenderState().setWireframe(true);
        material.setColor("Color", ColorRGBA.Red);
        model.setMaterial(material);
        rootNode.attachChild(model);

        model = (Geometry) assetManager.loadModel("styled.obj");
        material = new Material(assetManager, Materials.UNSHADED);
        material.getAdditionalRenderState().setWireframe(true);
        material.setColor("Color", ColorRGBA.Green);
        model.setMaterial(material);
        //rootNode.attachChild(model);
        flyCam.setMoveSpeed(100);
    }

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setSamples(4);
        TestSimplified app = new TestSimplified();
        app.setSettings(settings);
        app.start();
    }
}
