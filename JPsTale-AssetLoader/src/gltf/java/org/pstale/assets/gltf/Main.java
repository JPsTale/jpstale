package org.pstale.assets.gltf;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.scene.plugins.smd.stage.Stage;
import com.jme3.system.JmeSystem;

import org.pstale.assets.AssetFactory;
import org.pstale.assets.utils.SceneBuilder;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * @title Main
 * @author yanmaoyuan
 * @date 2018年8月1日
 * @version 1.0
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader()
            .getResource("com/jme3/asset/Desktop.cfg");
        System.out.println(url);
        AssetManager assetManager = JmeSystem.newAssetManager(url);
        AssetFactory.setAssetManager(assetManager);

        Stage stage = AssetFactory.loadSmdStage("Field/forest/fore-1.ASE");

        // 场景
        Node scene = SceneBuilder.buildScene3D(stage, "fore-1");
        System.out.println(scene);

        // 碰撞网格
        Mesh mesh = SceneBuilder.buildCollisionMesh(stage);

    }

    static void write(Mesh mesh) throws IOException {
        VertexBuffer vb = mesh.getBuffer(Type.Position);
        VertexBuffer ib = mesh.getBuffer(Type.Index);

        System.out.println(vb);
        System.out.println(ib);

        FloatBuffer vBuffer = (FloatBuffer) vb.getData();
        IntBuffer iBuffer = (IntBuffer) ib.getData();

        System.out.println(vb.getNumComponents());
        System.out.println(vb.getNumElements());
        System.out.println(vBuffer.order());
        System.out.println(vBuffer.capacity());
        System.out.println(vBuffer.limit());

        System.out.println(ib.getNumComponents());
        System.out.println(ib.getNumElements());
        System.out.println(iBuffer.order());
        System.out.println(iBuffer.capacity());
        System.out.println(iBuffer.limit());

        float s = 1f / 256;
        DataOutputStream out = new DataOutputStream(new FileOutputStream("scene.bin"));
        int limit = vBuffer.limit();
        for (int i = 0; i < limit; i += 3) {
            float f0 = vBuffer.get(i) * s;
            float f1 = vBuffer.get(i + 1) * s;
            float f2 = vBuffer.get(i + 2) * s;

            write(out, f0);
            write(out, f1);
            write(out, f2);
        }

        limit = iBuffer.limit();
        for (int i = 0; i < limit; i++) {
            int v = iBuffer.get(i);
            write(out, v);
        }

        out.flush();
        out.close();
    }

    static void write(OutputStream out, float value) throws IOException {
        write(out, Float.floatToRawIntBits(value));
    }

    static void write(OutputStream out, int value) throws IOException {
        out.write((value >>> 0) & 0xFF);
        out.write((value >>> 8) & 0xFF);
        out.write((value >>> 16) & 0xFF);
        out.write((value >>> 24) & 0xFF);
    }

}
