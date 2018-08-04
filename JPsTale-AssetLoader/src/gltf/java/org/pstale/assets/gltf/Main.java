package org.pstale.assets.gltf;

import com.jme3.asset.AssetManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.plugins.smd.material.SmMaterial;
import com.jme3.scene.plugins.smd.material.TEXTURE;
import com.jme3.scene.plugins.smd.stage.Stage;
import com.jme3.scene.plugins.smd.stage.StageFace;
import com.jme3.scene.plugins.smd.stage.StageVertex;
import com.jme3.system.JmeSystem;

import org.json.JSONObject;
import org.pstale.assets.AssetFactory;
import org.pstale.assets.gltf.entity.Accessor;
import org.pstale.assets.gltf.entity.Asset;
import org.pstale.assets.gltf.entity.Buffer;
import org.pstale.assets.gltf.entity.BufferView;
import org.pstale.assets.gltf.entity.GlTF;
import org.pstale.assets.gltf.entity.Mesh;
import org.pstale.assets.gltf.entity.MeshPrimitive;
import org.pstale.assets.gltf.entity.Node;
import org.pstale.assets.gltf.entity.Scene;
import org.pstale.assets.gltf.enums.ComponentType;
import org.pstale.assets.gltf.enums.GltfType;
import org.pstale.assets.gltf.enums.Target;
import org.pstale.assets.utils.SceneBuilder;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
        URL url = Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg");

        AssetManager assetManager = JmeSystem.newAssetManager(url);
        AssetFactory.setAssetManager(assetManager);

        String name = "Field/Ice/ice_2.smd";
        String fname = "ice";
        Stage stage = AssetFactory.loadSmdStage(name);

        // 顶点数量
        int nVertex = stage.nVertex;
        // 法线
        Vector3f[] normals = SceneBuilder.computeOrginNormals(stage);
        Vector3f[] positions = new Vector3f[nVertex];
        ColorRGBA[] colors = new ColorRGBA[nVertex];
        for (int i = 0; i < nVertex; i++) {
            StageVertex sv = stage.Vertex[i];
            positions[i] = sv.v.mult(0.01f);
            colors[i] = sv.vectorColor;
        }

        // 三角形
        int nFace = stage.nFace;
        int[] indices = new int[nFace * 3];
        Vector2f[] uv = new Vector2f[nVertex];
        for (int i = 0; i < nFace; i++) {
            StageFace sf = stage.Face[i];
            int idx = i*3;
            indices[idx] = sf.v[0];
            indices[idx + 1] = sf.v[1];
            indices[idx + 2] = sf.v[2];
            // float[] u = sf.TexLink.u;
            // float[] v = sf.TexLink.v;
        }
        
        makeGltf(fname, positions, normals, colors, indices);
        
        // 材质
        // 材质数量
        int nMaterial = stage.materialGroup.materialCount;
        int nImage = 0;
        int nInUse = 0;
        //printMaterials(stage.materials);
        for (int i = 0; i < nMaterial; i++) {
            SmMaterial mat = stage.materials[i];
            nImage += mat.TextureCounter;
            nInUse += mat.InUse;
        }

        System.out.printf("nMaterial:%d, nInUse:%d, nImage:%d, nFace:%d, nVertex:%d\n", nMaterial, nInUse, nImage,
            nFace, nVertex);
    }

    static void makeGltf(String name, Vector3f[] positions, Vector3f[] normals, ColorRGBA[] colors, int[] indices) throws IOException {
        
        /**
         * Asset
         */
        Asset asset = new Asset();
        asset.setVersion("2.0");
        asset.setMinVersion("2.0");
        asset.setCopyright("www.jmecn.net");
        asset.setGenerator("JPsTale-0.1.0-SNAPSHOT");
        
        /**
         * Buffer views
         */
        List<BufferView> bufferViews = new ArrayList<BufferView>();
        bufferViews.add(new BufferView());// vertex position
        bufferViews.add(new BufferView());// vertex normal
        bufferViews.add(new BufferView());// vertex color
        bufferViews.add(new BufferView());// indices
        
        bufferViews.get(0).setName("positionsBufferView");
        bufferViews.get(0).setByteLength(positions.length * ComponentType.FLOAT.getBytes() * GltfType.VEC3.getComponents() );
        bufferViews.get(0).setTarget(Target.VERTEX_ATTRIBUTE.getValue());
        
        bufferViews.get(1).setName("normalsBufferView");
        bufferViews.get(1).setByteLength(normals.length * ComponentType.FLOAT.getBytes() * GltfType.VEC3.getComponents() );
        
        bufferViews.get(2).setName("colorsBufferView");
        bufferViews.get(2).setByteLength(colors.length * ComponentType.FLOAT.getBytes() * GltfType.VEC4.getComponents() );
        
        bufferViews.get(3).setName("indicesBufferView");
        bufferViews.get(3).setTarget(Target.VERTEX_INDIX.getValue());
        bufferViews.get(3).setByteLength(indices.length * ComponentType.UNSIGNED_SHORT.getBytes() * GltfType.SCALAR.getComponents());
        
        // 计算偏移量
        for(int i=1; i<bufferViews.size(); i++) {
            BufferView front = bufferViews.get(i-1);
            BufferView cur = bufferViews.get(i);
            cur.setByteOffset(front.getByteOffset() + front.getByteLength());
        }
        
        /**
         * 缓存
         */
        List<Buffer> buffers = new ArrayList<Buffer>();
        buffers.add(new Buffer());
        
        buffers.get(0).setName("Buffer0");
        
        int byteLength = 0;
        for(int i=0; i<bufferViews.size(); i++) {
            BufferView cur = bufferViews.get(i);
            byteLength += cur.getByteLength();
        }
        buffers.get(0).setByteLength(byteLength);
        
        System.out.println(byteLength);
        
        /**
         * 写入数据
         */
        ByteArrayOutputStream out = new ByteArrayOutputStream(byteLength);
        
        Vector3f pMax = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        Vector3f pMin = new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        for(Vector3f v : positions) {
            write(out, v.x);
            write(out, v.y);
            write(out, v.z);
            
            if (v.x > pMax.x) pMax.x = v.x;
            if (v.y > pMax.y) pMax.y = v.y;
            if (v.z > pMax.z) pMax.z = v.z;
            
            if (v.x < pMin.x) pMin.x = v.x;
            if (v.y < pMin.y) pMin.y = v.y;
            if (v.z < pMin.z) pMin.z = v.z;
            
        }
        
        Vector3f nMax = new Vector3f(-1f, -1f, -1f);
        Vector3f nMin = new Vector3f(1f, 1f, 1f);
        for(Vector3f v : normals) {
            write(out, v.x);
            write(out, v.y);
            write(out, v.z);
            
            if (v.x > nMax.x) nMax.x = v.x;
            if (v.y > nMax.y) nMax.y = v.y;
            if (v.z > nMax.z) nMax.z = v.z;
            
            if (v.x < nMin.x) nMin.x = v.x;
            if (v.y < nMin.y) nMin.y = v.y;
            if (v.z < nMin.z) nMin.z = v.z;
        }
        
        Vector4f cMax = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        Vector4f cMin = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        for(ColorRGBA v : colors) {
            write(out, v.r);
            write(out, v.g);
            write(out, v.b);
            write(out, v.a);
            
            if (v.r > cMax.x) cMax.x = v.r;
            if (v.g > cMax.y) cMax.y = v.g;
            if (v.b > cMax.z) cMax.z = v.b;
            if (v.a > cMax.w) cMax.w = v.a;
            
            if (v.r < cMin.x) cMin.x = v.r;
            if (v.g < cMin.y) cMin.y = v.g;
            if (v.b < cMin.z) cMin.z = v.b;
            if (v.a < cMin.w) cMin.w = v.a;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : indices) {
            writeShort(out, i);
            
            if (i > max) max = i;
            if (i < min) min = i;
        }
        
        byte[] data = out.toByteArray();
        
        //Base64.Encoder encoder = Base64.getEncoder();
        //final String encodedText = encoder.encodeToString(data);
        //buffers.get(0).setUri("data:application/octet-stream;base64," + encodedText);
        
        OutputStream bin = new FileOutputStream("scene.bin");
        bin.write(data);
        bin.flush();
        bin.close();
        buffers.get(0).setUri("scene.bin");
        
        /**
         * Accessors
         */
        List<Accessor> accessors = new ArrayList<Accessor>();
        accessors.add(new Accessor());// positions
        accessors.add(new Accessor());// normals
        accessors.add(new Accessor());// colors
        accessors.add(new Accessor());// indices
        
        accessors.get(0).setName("Positions");
        accessors.get(0).setBufferView(0);
        accessors.get(0).setComponentType(ComponentType.FLOAT.getValue());
        accessors.get(0).setType(GltfType.VEC3.name());
        accessors.get(0).setCount(positions.length);
        accessors.get(0).setMax(new Float[] {pMax.x, pMax.y, pMax.z});
        accessors.get(0).setMin(new Float[] {pMin.x, pMin.y, pMin.z});
        
        accessors.get(1).setName("Normals");
        accessors.get(1).setBufferView(1);
        accessors.get(1).setComponentType(ComponentType.FLOAT.getValue());
        accessors.get(1).setType(GltfType.VEC3.name());
        accessors.get(1).setCount(normals.length);
        accessors.get(1).setMax(new Float[] {nMax.x, nMax.y, nMax.z});
        accessors.get(1).setMin(new Float[] {nMin.x, nMin.y, nMin.z});
        
        accessors.get(2).setName("VertexColors");
        accessors.get(2).setBufferView(2);
        accessors.get(2).setComponentType(ComponentType.FLOAT.getValue());
        accessors.get(2).setType(GltfType.VEC4.name());
        accessors.get(2).setCount(colors.length);
        accessors.get(2).setMax(new Float[] {cMax.x, cMax.y, cMax.z, cMax.w});
        accessors.get(2).setMin(new Float[] {cMin.x, cMin.y, cMin.z, cMin.w});
        
        accessors.get(3).setName("Indices");
        accessors.get(3).setBufferView(3);
        accessors.get(3).setComponentType(ComponentType.UNSIGNED_SHORT.getValue());
        accessors.get(3).setType(GltfType.SCALAR.name());
        accessors.get(3).setCount(indices.length);
        accessors.get(3).setMax(new Integer[] {max});
        accessors.get(3).setMin(new Integer[] {min});
        
        /**
         * Node
         */
        List<Mesh> meshes= new ArrayList<Mesh>();
        meshes.add(new Mesh());
        
        MeshPrimitive primitive = new MeshPrimitive();
        primitive.addAttributes("POSITION", 0);
        primitive.addAttributes("NORMAL", 1);
        primitive.addAttributes("COLOR_0", 2);
        primitive.setIndices(3);
        
        meshes.get(0).setName(name);
        meshes.get(0).addPrimitives(primitive);
        
        /**
         * Nodes
         */
        List<Node> nodes = new ArrayList<Node>();
        nodes.add( new Node() );
        
        nodes.get(0).setName("rootNode");
        nodes.get(0).setMesh(0);
        
        /**
         * Scenes
         */
        List<Scene> scenes = new ArrayList<Scene>();
        scenes.add(new Scene());
        
        scenes.get(0).setName(name);
        scenes.get(0).setNodes(Arrays.asList(0));
        
        /**
         * GlTF
         */
        GlTF glTF = new GlTF();
        glTF.setAccessors(accessors);
        glTF.setAsset(asset);
        glTF.setBuffers(buffers);
        glTF.setBufferViews(bufferViews);
        glTF.setNodes(nodes);
        glTF.setMeshes(meshes);
        glTF.setScene(0);
        glTF.setScenes(scenes);
        
        
        /**
         * output
         */
        JSONObject json = new JSONObject(glTF);
        OutputStream gltf = new FileOutputStream("scene.gltf");
        data = json.toString().getBytes("UTF-8");
        gltf.write(data);
        gltf.close();
    }
    
    static void printMaterials(SmMaterial[] materials) throws IOException {

        PrintStream out = new PrintStream(new FileOutputStream("materials.csv"));
        out = System.out;
        
        out.print("ID, InUse, Tex0, Tex1, TextureCnt, BlendType, MapOpacity, Transparency, MeshState, Shade, TwoSide, SelfIllum, TextureSwap, TextureClip");
        int nMaterial = materials.length;
        Map<String, Set<SmMaterial>> texNames = new TreeMap<>();
        for (int i = 0; i < nMaterial; i++) {
            SmMaterial mat = materials[i];
            String[] texs = { "", "" };
            for (int j = 0; j < mat.TextureCounter; j++) {
                TEXTURE tex = mat.smTexture[j];
                texs[j] = tex.Name;
                
                String key = tex.Name.toLowerCase();
                Set<SmMaterial> mats = texNames.get(key);
                if (mats == null) {
                    mats = new HashSet<>();
                    texNames.put(key, mats);
                }
                mats.add(mat);
            }

            out.println();
            out.printf("%d, %d, %s, %s, %d, %d, %d, %.02f, %d, %d, %d, %.02f, %d, %d", i, mat.InUse, texs[0], texs[1], mat.TextureCounter, mat.BlendType,
                mat.MapOpacity, mat.Transparency, mat.MeshState, mat.Shade, mat.TwoSide, mat.SelfIllum, mat.TextureSwap, mat.TextureClip);

        }
        
        System.out.println();
       
        System.out.println(texNames.size());
        
        texNames.entrySet().forEach(it -> {
            System.out.println(it.getKey() + " ~ " + it.getValue().size());
        });;
        //out.close();
    }

    static void write(OutputStream out, float value) throws IOException {
        writeInt(out, Float.floatToRawIntBits(value));
    }

    static void writeInt(OutputStream out, int value) throws IOException {
        out.write((value >>> 0) & 0xFF);
        out.write((value >>> 8) & 0xFF);
        out.write((value >>> 16) & 0xFF);
        out.write((value >>> 24) & 0xFF);
    }
    
    static void writeShort(OutputStream out, int value) throws IOException {
        out.write((value >>> 0) & 0xFF);
        out.write((value >>> 8) & 0xFF);
    }

}
