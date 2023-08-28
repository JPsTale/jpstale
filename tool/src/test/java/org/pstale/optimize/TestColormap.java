package org.pstale.optimize;

import com.jme3.app.DetailedProfilerState;
import com.jme3.app.SimpleApplication;
import com.jme3.bounding.BoundingBox;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.texture.FrameBuffer;
import com.jme3.texture.Image.Format;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.ui.Picture;
import com.jme3.util.BufferUtils;

import org.jpstale.assets.AssetFactory;

import java.nio.ByteBuffer;

public class TestColormap extends SimpleApplication {
    private Spatial scene;

    private ViewPort offView;

    int size = 512;

    FrameBuffer offBuffer;
    ByteBuffer  outBuf;

    public Texture2D setupOffscreenView() {
        outBuf = BufferUtils.createByteBuffer(size * size * 4);

        BoundingBox bb = (BoundingBox) scene.getWorldBound();
        Vector3f center = bb.getCenter();
        float xextent = bb.getXExtent();
        float zextent = bb.getZExtent();

        Camera offCamera = new Camera(size, size);
        offCamera.setLocation(center);
        offCamera.lookAtDirection(new Vector3f(0, -1, 0), Vector3f.UNIT_Y);
        offCamera.setParallelProjection(true);
        offCamera.setFrustum(-1000, 1000, -xextent / 2, xextent / 2, zextent / 2,  -zextent / 2);

        // setup framebuffer's texture
        Texture2D colorTexture = new Texture2D(size, size, Format.RGBA8);
        colorTexture.setMinFilter(Texture.MinFilter.Trilinear);
        colorTexture.setMagFilter(Texture.MagFilter.Bilinear);

        offBuffer = new FrameBuffer(size, size, 1);
        offBuffer.setColorBuffer(Format.RGBA8);
        offBuffer.setColorTexture(colorTexture);

        offView = renderManager.createPreView("Map View", offCamera);
        offView.setClearFlags(true, true, true);
        offView.setBackgroundColor(ColorRGBA.Black);
        offView.setOutputFrameBuffer(offBuffer);
        offView.attachScene(scene);

        return colorTexture;
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(new DetailedProfilerState());
        AssetFactory.setAssetManager(assetManager);

        scene = AssetFactory.loadStage3D("Field/desert/de-1.smd");
        scene.scale(0.05f);
        rootNode.attachChild(scene);

        BoundingBox bb = (BoundingBox) scene.getWorldBound();
        Vector3f center = bb.getCenter();
        cam.setLocation(center);
        cam.lookAtDirection(new Vector3f(0, -1, 0), Vector3f.UNIT_Y);

        Texture2D offTex = setupOffscreenView();

        Picture pic = new Picture("colormap");
        pic.setTexture(assetManager, offTex, false);
        pic.setWidth(size);
        pic.setHeight(size);
        pic.setPosition(0, cam.getHeight() - size);
        guiNode.attachChild(pic);
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    public static void main(String[] args) {
        TestColormap app = new TestColormap();
        app.start();
    }

}
