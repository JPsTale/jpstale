package org.pstale.assets.gltf;

import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.plugins.smd.material.SmMaterial;
import com.jme3.scene.plugins.smd.material.TEXLINK;
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
import org.pstale.assets.gltf.entity.Image;
import org.pstale.assets.gltf.entity.Material;
import org.pstale.assets.gltf.entity.MaterialPbrMetallicRoughness;
import org.pstale.assets.gltf.entity.Mesh;
import org.pstale.assets.gltf.entity.MeshPrimitive;
import org.pstale.assets.gltf.entity.Node;
import org.pstale.assets.gltf.entity.Sampler;
import org.pstale.assets.gltf.entity.Scene;
import org.pstale.assets.gltf.entity.Texture;
import org.pstale.assets.gltf.entity.TextureInfo;
import org.pstale.assets.gltf.enums.ComponentType;
import org.pstale.assets.gltf.enums.GltfType;
import org.pstale.assets.gltf.enums.MagFilter;
import org.pstale.assets.gltf.enums.MinFilter;
import org.pstale.assets.gltf.enums.Target;
import org.pstale.assets.utils.SceneBuilder;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Stage2Gltf {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        
        String[] names = {
//            "Field/forest/fore-1.smd",
//            "Field/forest/fore-2.smd",
//            "Field/forest/fore-3.smd",
//            "Field/forest/village-1.smd",
            "Field/Ricarten/village-2.smd",
//            "Field/Ruin/ruin-4.smd",
//            "Field/Ruin/ruin-3.smd",
//            "Field/Ruin/ruin-2.smd",
//            "Field/Ruin/ruin-1.smd",
//            "Field/forever-fall/forever-fall-01.smd",
//            "Field/forever-fall/forever-fall-02.smd",
//            "Field/forever-fall/forever-fall-03.smd",
//            "Field/forever-fall/forever-fall-04.smd",
            "Field/forever-fall/pilai.smd",
//            "Field/Greedy/Greedy.smd",
//            "Field/desert/De-1.smd",
//            "Field/desert/De-2.smd",
//            "Field/desert/De-3.smd",
//            "Field/desert/De-4.smd",
//            "Field/desert/de-5.smd",
//            "Field/Sod/sod-1.smd",
//            "Field/Sod/sod-2.smd",
//            "Field/cave/Dcave.smd",
//            "Field/cave/Tcave.smd",
//            "Field/cave/Mcave.smd",
//            "Field/Iron/iron-1.smd",
//            "Field/Iron/iron-2.smd",
//            "Field/Iron/iron3.smd",
//            "Field/Ice/ice1.smd",
//            "Field/Ice/ice_2.smd",
//            "Field/Ice/ice3.smd",
//            "Field/Ice/ice_ura.smd",
//            "Field/Boss/Boss.smd",
        };
        Stage2Gltf stage2gltf = new Stage2Gltf();

        stage2gltf.init();
        stage2gltf.outputFolder = "/Users/yan/Downloads/TestGLTF/";
        stage2gltf.isGenerateNormals = true;
        stage2gltf.isOptimizeMaterials = false;
        stage2gltf.isMoveToCenter = true;

        // stage2gltf.createMeshes();
        // stage2gltf.createWhiteGltf();
        for (String name : names) {
            stage2gltf.load(name);
            stage2gltf.start();
        }
    }

    private AssetManager assetManager;

    private Stage  stage;
    private String filename;

    private String outputFolder = "./";

    private String texFolder   = "texture/";
    private String binFileName = "scene.bin";

    private String gltfFileName = "scene.gltf";

    /**
     * 是否使用Base64
     */
    private boolean isBase64 = false;

    /**
     * 是否优化材质
     */
    private boolean isOptimizeMaterials = true;

    /**
     * 是否生成法线
     */
    private boolean isGenerateNormals = false;

    /**
     * 是否移动到中部
     */
    private boolean isMoveToCenter = true;

    /**
     * 平移
     */
    private Vector3f translation = new Vector3f(0f, 0f, 0f);

    /**
     * 缩放比例
     */
    private float scalar = 0.01f;

    private Vector3f[] positions;

    private Vector3f[] normals;

    private ColorRGBA[] colors;

    public Stage2Gltf() {
        init();
    }

    /**
     * 初始化AssetManager
     */
    public void init() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("com/jme3/asset/Desktop.cfg");
        this.assetManager = JmeSystem.newAssetManager(url);
        AssetFactory.setAssetManager(assetManager);
    }

    public void load(String file) {
        this.filename = file;
        this.stage = AssetFactory.loadSmdStage(file);
        
        /**
         * 计算文件名
         */
        String newName = file.replace("\\", "/");
        int startIdx = newName.lastIndexOf("/");
        int endIdx = newName.lastIndexOf(".");
        String simpleName = newName.substring(startIdx + 1, endIdx);
        
        binFileName = simpleName + ".bin";
        gltfFileName = simpleName + ".gltf";

        // 保存顶点数据
        int nVertex = stage.nVertex;
        this.positions = new Vector3f[nVertex];
        this.colors = new ColorRGBA[nVertex];
        for (int i = 0; i < nVertex; i++) {
            StageVertex sv = stage.Vertex[i];
            positions[i] = new Vector3f(sv.v);
            colors[i] = new ColorRGBA(sv.vectorColor);
        }

        // 法线
        if (isGenerateNormals) {
            this.normals = SceneBuilder.computeOrginNormals(stage);
        }

        // scale
        for (Vector3f v : positions) {
            v.multLocal(scalar);
        }

        // 模型居中
        if (isMoveToCenter) {
            center();
        }
    }

    public void center() {

        // 坐标
        Vector3f pMax = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        Vector3f pMin = new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        for (Vector3f v : positions) {
            if (v.x > pMax.x)
                pMax.x = v.x;
            if (v.y > pMax.y)
                pMax.y = v.y;
            if (v.z > pMax.z)
                pMax.z = v.z;

            if (v.x < pMin.x)
                pMin.x = v.x;
            if (v.y < pMin.y)
                pMin.y = v.y;
            if (v.z < pMin.z)
                pMin.z = v.z;
        }
        Vector3f center = pMax.add(pMin).multLocal(0.5f);
        center.y = 0f;

        translation.set(center);

        for (Vector3f v : positions) {
            v.subtractLocal(center);
        }
    }

    public void start() {

        GlTF gltf = new GlTF();

        /**
         * Asset
         */
        Asset asset = new Asset();
        asset.setVersion("2.0");
        asset.setMinVersion("2.0");
        asset.setCopyright("jmecn (C) 2018");
        asset.setGenerator("JPsTale-Stage2Gltf-CLI");

        gltf.setAsset(asset);

        /**
         * 统计实际使用的材质，以及这些材质被哪些三角形所引用。
         */
        TreeMap<Integer, TreeSet<Integer>> matFaceMap = getMaterialFaceMap();

        // 创建子网格
        List<Submesh> submeshes = createMeshes(matFaceMap);

        // 创建材质
        Map<Integer, Integer> materialMap = createMaterials(gltf, matFaceMap);
        for (Submesh submesh : submeshes) {
            submesh.matId = materialMap.get(submesh.matId);
        }

        // 创建buffer、bufferview、accessor
        createBuffers(gltf, submeshes);

        try {
            // 创建文件夹
            File folder = new File(outputFolder + texFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // 使用到的材质ID
            Set<Integer> matIds = matFaceMap.keySet();
            for (Integer matId : matIds) {
                SmMaterial mat = stage.materials[matId];
                // 纹理
                if (mat.TextureCounter >= 1) {
                    moveTexture(mat.smTexture[0].Name);
                }
            }

            // TODO 支持Base64
            writeBin(submeshes);

            writeGltf(gltf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建缓冲区
     * 
     * @param gltf
     * @param submeshes
     */
    private void createBuffers(GlTF gltf, List<Submesh> submeshes) {

        List<Buffer> buffers = new ArrayList<Buffer>();
        List<BufferView> bufferViews = new ArrayList<BufferView>();
        List<Accessor> accessors = new ArrayList<Accessor>();

        List<Scene> scenes = new ArrayList<Scene>();
        List<Node> nodes = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();
        List<Mesh> meshes = new ArrayList<Mesh>();

        /**
         * Buffer
         */
        int byteLength = 0;// 总长度
        for (Submesh submesh : submeshes) {
            int length = submesh.getLength();
            byteLength += length;
        }

        // 只需要1个buffer，uri等写文件的时候再搞
        Buffer buffer = new Buffer();
        buffer.setName("MeshBuffer");
        buffer.setByteLength(byteLength);
        if (!isBase64) {
            buffer.setUri(binFileName);
        } else {
            // 等生成base64的时候再设置
        }
        buffers.add(buffer);

        int baseOffset = 0;// 基准偏移量
        int idx = 0;
        for (int i = 0; i < submeshes.size(); i++) {

            Submesh submesh = submeshes.get(i);
            submesh.getLength();
            submesh.setBaseOffset(baseOffset);
            submesh.getMaxMin();

            bufferViews.addAll(submesh.getBufferViews());
            accessors.addAll(submesh.getAccessors(idx));

            Mesh mesh = submesh.getMesh(idx);
            meshes.add(mesh);

            Node node = new Node();
            node.setMesh(i);
            children.add(node);

            // baseOffset递增
            baseOffset += submesh.length;

            // idx 递增
            if (submesh.hasNormal()) {
                idx += 5;
            } else {
                idx += 4;
            }
        }

        /**
         * 只需要一个rootNode
         */
        Node rootNode = new Node();
        rootNode.setName("rootNode:" + filename);
        if (isMoveToCenter) {
            rootNode.setTranslation(translation.toArray(null));
        }
        nodes.add(rootNode);

        /**
         * 设置子节点
         */
        List<Integer> childrenIdx = new ArrayList<Integer>();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            nodes.add(node);
            childrenIdx.add(i + 1);
        }
        rootNode.setChildren(childrenIdx);

        /**
         * Scenes
         */
        Scene scene = new Scene();
        scene.setName(filename);
        scene.setNodes(Arrays.asList(0));
        scenes.add(scene);

        /**
         * GlTF
         */
        gltf.setAccessors(accessors);
        gltf.setBuffers(buffers);
        gltf.setBufferViews(bufferViews);
        gltf.setNodes(nodes);
        gltf.setMeshes(meshes);
        gltf.setScene(0);
        gltf.setScenes(scenes);
    }

    /**
     * 生成gltf文件
     * 
     * @param glTF
     * @throws IOException
     */
    private void writeGltf(GlTF glTF) throws IOException {

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFolder + gltfFileName));

        JSONObject json = new JSONObject(glTF);
        String content = json.toString(2);
        byte[] data = content.getBytes("UTF-8");

        out.write(data);
        out.close();

        System.out.printf("Write glft file: %s\n", outputFolder + gltfFileName);
    }

    /**
     * 把网格写入到bin文件中
     * 
     * @param submeshes
     */
    private void writeBin(List<Submesh> submeshes) throws IOException {
        // 统计文件的字节数
        int byteLength = 0;// 总长度
        int maxLength = 0;// 最长的数据块大小
        for (Submesh submesh : submeshes) {
            int length = submesh.getLength();
            byteLength += length;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFolder + binFileName));
        // 按最大数据块的长度定义缓冲区
        byte[] buffer = new byte[maxLength];

        // 写入文件
        for (Submesh submesh : submeshes) {
            int length = submesh.getLength();
            submesh.data(buffer);
            out.write(buffer, 0, length);
        }

        // 关闭文件
        out.close();

        System.out.printf("Write bin file: %s, byteLength:%d\n", outputFolder + binFileName, byteLength);
    }

    /**
     * 对模型建立索引
     */
    public Map<Integer, Integer> createMaterials(GlTF gltf, TreeMap<Integer, TreeSet<Integer>> matFaceMap) {

        /**
         * Stage材质ID 与 Gltf材质ID 的映射
         */
        Map<Integer, Integer> materialMap = new HashMap<>();

        // 使用到的材质ID
        Set<Integer> matIds = matFaceMap.keySet();

        List<Material> materials = new ArrayList<Material>();
        int materialId = -1;

        // 纹理
        List<Texture> textures = new ArrayList<Texture>();
        int textureId = -1;

        // 图片
        List<Image> images = new ArrayList<Image>();
        int imageId = -1;

        // 纹理采样器
        List<Sampler> samplers = new ArrayList<Sampler>();
        int samplerId = -1;

        // 默认采样器
        Sampler sampler = new Sampler();
        sampler.setName("Default Sampler");
        sampler.setMagFilter(MagFilter.LINEAR.getValue());
        sampler.setMinFilter(MinFilter.NEAREST_MIPMAP_NEAREST.getValue());

        samplers.add(sampler);
        samplerId++;

        for (Integer matId : matIds) {
            SmMaterial mat = stage.materials[matId];

            // 创建材质
            Material material = new Material();

            MaterialPbrMetallicRoughness pbrMetallicRoughness = new MaterialPbrMetallicRoughness();
            pbrMetallicRoughness.setMetallicFactor(0.0f);
            pbrMetallicRoughness.setRoughnessFactor(1.0f);
            pbrMetallicRoughness.setBaseColorFactor(new float[] { 1.0f, 1.0f, 1.0f, 1.0f });
            material.setPbrMetallicRoughness(pbrMetallicRoughness);

            // 透明度
            material.setAlphaMode("MASK");
            material.setAlphaCutoff(0.75f);

            // 只有在TwoSide有值的时候，才给材质设置DoubleSided参数
            if (mat.TwoSide != 0) {
                material.setDoubleSided(true);
            }

            // 纹理
            if (mat.TextureCounter >= 1) {

                // 把文件名替换成 texture/*.* 的形式
                String newName = mat.smTexture[0].Name.replace("\\", "/");
                
                int idx = newName.lastIndexOf("/");
                String simpleName = newName.substring(idx + 1).toLowerCase();

                String imageName = texFolder + simpleName;
                
                
                try {
                    TextureKey key = new TextureKey(newName);
                    assetManager.loadTexture(key);
                } catch (Exception e) {
                    imageName = "texture/MissingTexture.png";
                }

                // 图片
                Image image = new Image();
                image.setUri(imageName);
                images.add(image);
                imageId++;

                // 纹理
                Texture texture = new Texture();
                texture.setName(imageName);
                texture.setSampler(samplerId);
                texture.setSource(imageId);

                textures.add(texture);
                textureId++;

                // 设置为BaseColorMap
                TextureInfo baseColorTexture = new TextureInfo();
                baseColorTexture.setIndex(textureId);
                baseColorTexture.setTexCoord(0);
                pbrMetallicRoughness.setBaseColorTexture(baseColorTexture);
            }

            materials.add(material);
            materialId++;

            materialMap.put(matId, materialId);
        }

        gltf.setMaterials(materials);
        gltf.setTextures(textures);
        gltf.setImages(images);
        gltf.setSamplers(samplers);

        return materialMap;
    }

    /**
     * 根据不同的材质，将整个网格分解成多个不同的网格。
     */
    public List<Submesh> createMeshes() {
        return createMeshes(getMaterialFaceMap());
    }

    /**
     * 根据不同的材质，将整个网格分解成多个不同的网格。
     */
    public List<Submesh> createMeshes(TreeMap<Integer, TreeSet<Integer>> matFaceMap) {

        List<Submesh> submeshes = new ArrayList<>();

        System.out.printf("Total Triangles:%d, Vertexes:%d\n", stage.nFace, stage.nVertex);
        /**
         * 对每个材质对应的三角形，计算统计顶点。
         */
        Iterator<Map.Entry<Integer, TreeSet<Integer>>> iter = matFaceMap.entrySet().iterator();

        int nGeomSum = 0;
        int nFaceSum = 0;
        int nVertSum = 0;
        while (iter.hasNext()) {
            Map.Entry<Integer, TreeSet<Integer>> entry = iter.next();

            Integer matId = entry.getKey();// 材质ID
            TreeSet<Integer> faceIds = entry.getValue();// 三角形ID

            // 统计用到的顶点索引
            TreeSet<Integer> vertexIds = new TreeSet<>();
            for (Integer faceId : faceIds) {
                StageFace face = stage.Face[faceId];
                vertexIds.add(face.v[0]);
                vertexIds.add(face.v[1]);
                vertexIds.add(face.v[2]);
            }

            Submesh submesh = createSubmeshOld(faceIds, vertexIds);
            submesh.matId = matId;

            submeshes.add(submesh);

            nFaceSum += faceIds.size();
            nVertSum += vertexIds.size();
            nGeomSum++;
        }

        System.out.printf("Meshes:%d, Triangles:%d, Vertexes:%d\n", nGeomSum, nFaceSum, nVertSum);

        return submeshes;
    }

    private void moveTexture(String name) {
        String newName = name.replace("\\", "/");
        int idx = newName.lastIndexOf("/");
        String simpleName = newName.substring(idx + 1).toLowerCase();

        String target = String.format("%s%s%s", outputFolder, texFolder, simpleName);

        // 文件已存在，不需要移动
        if (new File(target).exists())
            return;

        try {
            TextureKey texKey = new TextureKey(newName);
            AssetInfo info = assetManager.locateAsset(texKey);

            if (info != null) {
                // copy it
                InputStream in = info.openStream();
                OutputStream out = new FileOutputStream(target);

                byte[] buf = new byte[4096];
                int len = 0;
                while ((len = in.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 提取子网格
     * 
     * @param matId
     * @param faceIds
     * @param vertexIds
     */
    protected Submesh createSubmesh(TreeSet<Integer> faceIds, TreeSet<Integer> vertexIds) {
        int triangles = faceIds.size();
        int vertexes = vertexIds.size();

        Map<Integer, Integer> vertexMap = new HashMap<>();

        int i = 0;
        Vector3f[] position = new Vector3f[vertexes];
        Vector2f[] texCoord = new Vector2f[vertexes];
        ColorRGBA[] color = new ColorRGBA[vertexes];
        Vector3f[] normal = null;

        if (isGenerateNormals) {
            normal = new Vector3f[vertexes];
        }

        for (Integer id : vertexIds) {
            position[i] = positions[id];
            color[i] = colors[id];
            texCoord[i] = new Vector2f();
            if (isGenerateNormals) {
                normal[i] = normals[id];
            }
            vertexMap.put(id, i);
            i++;
        }

        // TODO 蛋疼

        i = 0;
        int[] indices = new int[triangles * 3];
        for (Integer id : faceIds) {
            StageFace face = stage.Face[id];
            int v0 = vertexMap.get(face.v[0]);
            int v1 = vertexMap.get(face.v[1]);
            int v2 = vertexMap.get(face.v[2]);

            // 索引坐标
            indices[i] = v0;
            indices[i + 1] = v1;
            indices[i + 2] = v2;

            // 纹理坐标
            TEXLINK tl = face.TexLink;
            if (tl != null) {
                texCoord[v0].set(tl.u[0], tl.v[0]);
                texCoord[v1].set(tl.u[1], tl.v[1]);
                texCoord[v2].set(tl.u[2], tl.v[2]);
            }

            i += 3;
        }

        Submesh submesh = new Submesh();
        submesh.position = position;
        submesh.color = color;
        submesh.normal = normal;
        submesh.texCoord = texCoord;
        submesh.indices = indices;

        return submesh;
    }

    /**
     * 提取子网格
     * 
     * @param matId
     * @param faceIds
     * @param vertexIds
     */
    private Submesh createSubmeshOld(TreeSet<Integer> faceIds, TreeSet<Integer> vertexIds) {
        int triangles = faceIds.size();

        int[] indices = new int[triangles * 3];
        Vector3f[] position = new Vector3f[triangles * 3];
        Vector2f[] texCoord = new Vector2f[triangles * 3];
        ColorRGBA[] color = new ColorRGBA[triangles * 3];

        Vector3f[] normal = null;
        if (isGenerateNormals) {
            normal = new Vector3f[triangles * 3];
        }

        int i = 0;
        for (Integer id : faceIds) {
            StageFace face = stage.Face[id];

            // 顺序处理3个顶点
            for (int vIndex = 0; vIndex < 3; vIndex++) {
                int v = face.v[vIndex];
                // 顶点 VERTEX
                position[i + vIndex] = positions[v];

                if (isGenerateNormals) {
                    // 法向量 Normal
                    normal[i + vIndex] = normals[v];
                }

                color[i + vIndex] = colors[v];

                // 面 FACE
                indices[i + vIndex] = i + vIndex;

                // 纹理映射
                TEXLINK tl = face.TexLink;
                if (tl != null) {
                    // 第1组uv坐标
                    texCoord[i + vIndex] = new Vector2f(tl.u[vIndex], tl.v[vIndex]);
                } else {
                    texCoord[i + vIndex] = new Vector2f();
                }
            }
            i += 3;
        }

        Submesh submesh = new Submesh();
        submesh.position = position;
        submesh.color = color;
        submesh.normal = normal;
        submesh.texCoord = texCoord;
        submesh.indices = indices;

        return submesh;
    }

    /**
     * 优化材质数量
     * 
     * 合并无纹理的材质，共用一个默认材质
     * 
     * 合并使用相同纹理的材质。
     */
    public TreeMap<Integer, TreeSet<Integer>> getMaterialFaceMap() {

        // 材质总数
        int total = stage.materialGroup.materialCount;
        System.out.println("Material count:" + total);

        /**
         * 统计实际使用的材质，以及这些材质被哪些三角形所引用。
         */
        TreeMap<Integer, TreeSet<Integer>> matFaceMap = new TreeMap<>();
        for (int i = 0; i < stage.nFace; i++) {
            StageFace sf = stage.Face[i];
            int matId = sf.v[3];
            
            SmMaterial m = stage.materials[matId];
            // 忽略没有纹理的材质
            if (m.TextureCounter == 0) {
                continue;
            }
            
            // 不可见的材质，不需要显示。
            if ((m.UseState & 0x0400) != 0) {
                continue;
            }

            // 记录使用这个材质的表面ID
            TreeSet<Integer> faceSet = matFaceMap.get(matId);
            if (faceSet == null) {
                faceSet = new TreeSet<Integer>();
                matFaceMap.put(matId, faceSet);
            }
            faceSet.add(i);
        }

        // 若不开启优化，则直接返回统计结果
        if (!isOptimizeMaterials) {
            return matFaceMap;
        }

        Set<Integer> usedMats = matFaceMap.keySet();
        int materialsInUsed = usedMats.size();
        System.out.println("Material in used:" + materialsInUsed);

        /**
         * 统计使用不同纹理的材质
         */
        TreeSet<Integer> noneTextureMats = new TreeSet<>();
        Map<String, Set<Integer>> texMatMap = new TreeMap<>();

        for (Integer i : usedMats) {
            SmMaterial mat = stage.materials[i];
            // 记录无纹理的材质
            if (mat.TextureCounter <= 0) {
                noneTextureMats.add(i);
            } else {
                // 记录使用纹理的材质
                int j = 0;
                // 忽视LightMap
                // for (j = 0; j < mat.TextureCounter; j++) {
                TEXTURE tex = mat.smTexture[j];
                String key = tex.Name.toLowerCase();
                Set<Integer> mats = texMatMap.get(key);
                if (mats == null) {
                    mats = new TreeSet<>();
                    texMatMap.put(key, mats);
                }
                mats.add(i);
                // }
            }
        }

        /**
         * 合并无纹理的材质
         */
        int materialsWithNoTexture = noneTextureMats.size();
        System.out.println("Material with no textures:" + materialsWithNoTexture);

        combineMaterials(noneTextureMats, matFaceMap);

        /**
         * 可复用的纹理数量，以及可合并的材质数量
         */
        Set<String> textures = texMatMap.keySet();
        int textureInUsed = textures.size();
        System.out.println("Texture in use:" + textureInUsed);

        int materialsWithSameTexture = 0;

        Collection<Set<Integer>> matIdsSet = texMatMap.values();
        for (Set<Integer> matIds : matIdsSet) {
            if (matIds.size() > 1) {
                materialsWithSameTexture += matIds.size() - 1;
            }
            combineMaterials(matIds, matFaceMap);
        }

        System.out.println("Materials with same texture:" + materialsWithSameTexture);

        /**
         * 实际需要的材质数量
         */
        int materialsNeeded = matFaceMap.size();
        System.out.println("Materials needed:" + materialsNeeded);

        return matFaceMap;
    }

    /**
     * 显示材质与三角形的对应关系
     * 
     * @param matFaceMap
     */
    protected void printMatFaceMap(TreeMap<Integer, TreeSet<Integer>> matFaceMap) {
        Set<Integer> matIds = matFaceMap.keySet();

        for (Integer matId : matIds) {
            TreeSet<Integer> faceSet = matFaceMap.get(matId);
            System.out.println("MatId:" + matId + ", Face count:" + faceSet.size());
        }
    }

    /**
     * 把复用的材质合并！
     * 
     * 合并的方法，即把复用材质的三角形matId，改为第一个材质的matId。
     * 
     * @param matIds
     * @param matFaceMap
     */
    private void combineMaterials(Collection<Integer> matIds, Map<Integer, TreeSet<Integer>> matFaceMap) {
        if (matIds.size() > 1) {
            Integer[] matIdArr = matIds.toArray(new Integer[] {});

            int targetId = matIdArr[0];
            TreeSet<Integer> targetFaces = matFaceMap.get(targetId);

            for (int i = 1; i < matIdArr.length; i++) {
                int matId = matIdArr[i];

                // 合并相同材质的三角形
                TreeSet<Integer> faceIds = matFaceMap.remove(matId);
                targetFaces.addAll(faceIds);

                // 把对应三角形的matId改成targetId
                faceIds.forEach(id -> {
                    stage.Face[id].v[3] = matIdArr[0];
                });
            }
        }
    }

    public void printNoneTextureMaterials() throws IOException {
        SmMaterial[] materials = stage.materials;

        PrintStream out = new PrintStream(new FileOutputStream(outputFolder + "materials.csv"));

        out.print("ID, InUse, AnimTexCount, BlendType, MapOpacity, Transparency, "
            + "MeshState, Shade, TwoSide, SelfIllum, TextureSwap, TextureClip, Diffuse");
        int nMaterial = materials.length;

        for (int i = 0; i < nMaterial; i++) {
            SmMaterial mat = materials[i];
            String[] texs = { "", "" };
            for (int j = 0; j < mat.TextureCounter; j++) {
                TEXTURE tex = mat.smTexture[j];
                texs[j] = tex.Name;
            }

            if (mat.TextureCounter == 0) {
                out.println();
                out.printf("%d, %d, %d, %d, %d, %.02f, %d, %d, %d, %.02f, %d, %d, %s", i, mat.InUse, mat.AnimTexCounter,
                    mat.BlendType, mat.MapOpacity, mat.Transparency, mat.MeshState, mat.Shade, mat.TwoSide,
                    mat.SelfIllum, mat.TextureSwap, mat.TextureClip, mat.Diffuse.toString());
            }

        }

        System.out.println();

        out.close();
    }

    public void createWhiteGltf() throws IOException {
        // 三角形
        int nFace = stage.nFace;
        int[] indices = new int[nFace * 3];
        for (int i = 0; i < nFace; i++) {
            StageFace sf = stage.Face[i];
            int idx = i * 3;
            int idx0 = sf.v[0];
            int idx1 = sf.v[1];
            int idx2 = sf.v[2];
            indices[idx + 0] = idx0;
            indices[idx + 1] = idx1;
            indices[idx + 2] = idx2;
        }

        makeGltf(filename, positions, normals, colors, indices);
    }

    void makeGltf(String name, Vector3f[] positions, Vector3f[] normals, ColorRGBA[] colors, int[] indices)
        throws IOException {

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
        bufferViews.add(new BufferView());// indices
        bufferViews.add(new BufferView());// vertex position
        bufferViews.add(new BufferView());// vertex color

        bufferViews.get(0).setName("indicesBufferView");
        bufferViews.get(0).setTarget(Target.VERTEX_INDIX.getValue());
        bufferViews.get(0).setByteLength(indices.length * 4);

        bufferViews.get(1).setName("positionsBufferView");
        bufferViews.get(1).setByteLength(positions.length * 12);
        bufferViews.get(1).setTarget(Target.VERTEX_ATTRIBUTE.getValue());

        bufferViews.get(2).setName("colorsBufferView");
        bufferViews.get(2).setByteLength(colors.length * 16);

        if (isGenerateNormals) {
            bufferViews.add(new BufferView());// vertex normal
            bufferViews.get(3).setName("normalsBufferView");
            bufferViews.get(3).setByteLength(normals.length * 12);
        }

        // 计算偏移量
        for (int i = 1; i < bufferViews.size(); i++) {
            BufferView front = bufferViews.get(i - 1);
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
        for (int i = 0; i < bufferViews.size(); i++) {
            BufferView cur = bufferViews.get(i);
            byteLength += cur.getByteLength();
        }
        buffers.get(0).setByteLength(byteLength);

        System.out.println(byteLength);

        /**
         * 写入数据
         */
        ByteArrayOutputStream out = new ByteArrayOutputStream(byteLength);

        // 索引
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : indices) {
            writeInt(out, i);

            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }

        // 坐标
        Vector3f pMax = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        Vector3f pMin = new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        for (Vector3f v : positions) {
            writeFloat(out, v.x);
            writeFloat(out, v.y);
            writeFloat(out, v.z);

            if (v.x > pMax.x)
                pMax.x = v.x;
            if (v.y > pMax.y)
                pMax.y = v.y;
            if (v.z > pMax.z)
                pMax.z = v.z;

            if (v.x < pMin.x)
                pMin.x = v.x;
            if (v.y < pMin.y)
                pMin.y = v.y;
            if (v.z < pMin.z)
                pMin.z = v.z;
        }

        // 颜色
        Vector4f cMax = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        Vector4f cMin = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        for (ColorRGBA v : colors) {
            writeFloat(out, v.r);
            writeFloat(out, v.g);
            writeFloat(out, v.b);
            writeFloat(out, v.a);

            if (v.r > cMax.x)
                cMax.x = v.r;
            if (v.g > cMax.y)
                cMax.y = v.g;
            if (v.b > cMax.z)
                cMax.z = v.b;
            if (v.a > cMax.w)
                cMax.w = v.a;

            if (v.r < cMin.x)
                cMin.x = v.r;
            if (v.g < cMin.y)
                cMin.y = v.g;
            if (v.b < cMin.z)
                cMin.z = v.b;
            if (v.a < cMin.w)
                cMin.w = v.a;
        }

        // 法线
        if (isGenerateNormals) {
            Vector3f nMax = new Vector3f(-1f, -1f, -1f);
            Vector3f nMin = new Vector3f(1f, 1f, 1f);
            for (Vector3f v : normals) {
                writeFloat(out, v.x);
                writeFloat(out, v.y);
                writeFloat(out, v.z);

                if (v.x > nMax.x)
                    nMax.x = v.x;
                if (v.y > nMax.y)
                    nMax.y = v.y;
                if (v.z > nMax.z)
                    nMax.z = v.z;

                if (v.x < nMin.x)
                    nMin.x = v.x;
                if (v.y < nMin.y)
                    nMin.y = v.y;
                if (v.z < nMin.z)
                    nMin.z = v.z;
            }
        }

        /**
         * Accessors
         */
        List<Accessor> accessors = new ArrayList<Accessor>();
        accessors.add(new Accessor());// indices
        accessors.add(new Accessor());// positions
        accessors.add(new Accessor());// colors

        accessors.get(0).setName("Indices");
        accessors.get(0).setBufferView(0);
        accessors.get(0).setComponentType(ComponentType.UNSIGNED_INT.getValue());
        accessors.get(0).setType(GltfType.SCALAR.name());
        accessors.get(0).setCount(indices.length);
        accessors.get(0).setMax(new Integer[] { max });
        accessors.get(0).setMin(new Integer[] { min });

        accessors.get(1).setName("Positions");
        accessors.get(1).setBufferView(1);
        accessors.get(1).setComponentType(ComponentType.FLOAT.getValue());
        accessors.get(1).setType(GltfType.VEC3.name());
        accessors.get(1).setCount(positions.length);
        accessors.get(1).setMax(new Float[] { pMax.x, pMax.y, pMax.z });
        accessors.get(1).setMin(new Float[] { pMin.x, pMin.y, pMin.z });

        accessors.get(2).setName("VertexColors");
        accessors.get(2).setBufferView(2);
        accessors.get(2).setComponentType(ComponentType.FLOAT.getValue());
        accessors.get(2).setType(GltfType.VEC4.name());
        accessors.get(2).setCount(colors.length);
        accessors.get(2).setMax(new Float[] { cMax.x, cMax.y, cMax.z, cMax.w });
        accessors.get(2).setMin(new Float[] { cMin.x, cMin.y, cMin.z, cMin.w });

        if (isGenerateNormals) {
            accessors.add(new Accessor());// normals
            accessors.get(3).setName("Normals");
            accessors.get(3).setBufferView(3);
            accessors.get(3).setComponentType(ComponentType.FLOAT.getValue());
            accessors.get(3).setType(GltfType.VEC3.name());
            accessors.get(3).setCount(normals.length);
            // accessors.get(3).setMax(new Float[] { nMax.x, nMax.y, nMax.z });
            // accessors.get(3).setMin(new Float[] { nMin.x, nMin.y, nMin.z });
        }

        /**
         * Node
         */
        List<Mesh> meshes = new ArrayList<Mesh>();
        meshes.add(new Mesh());

        MeshPrimitive primitive = new MeshPrimitive();
        primitive.setIndices(0);
        primitive.addAttributes("POSITION", 1);
        primitive.addAttributes("COLOR_0", 2);
        if (isGenerateNormals) {
            primitive.addAttributes("NORMAL", 1);
        }

        meshes.get(0).setName(name);
        meshes.get(0).addPrimitives(primitive);

        /**
         * Nodes
         */
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node());

        nodes.get(0).setName("rootNode:" + name);
        nodes.get(0).setMesh(0);
        if (isMoveToCenter) {
            nodes.get(0).setTranslation(translation.toArray(null));
        }

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
        /**
         * 是否输出为Base64
         */
        if (isBase64) {
            Base64.Encoder encoder = Base64.getEncoder();
            final String encodedText = encoder.encodeToString(out.toByteArray());
            buffers.get(0).setUri("data:application/octet-stream;base64," + encodedText);
        } else {
            OutputStream bin = new FileOutputStream(outputFolder + binFileName);
            bin.write(out.toByteArray());
            bin.flush();
            bin.close();
            buffers.get(0).setUri(binFileName);
        }

        writeGltf(glTF);
    }

    void writeFloat(OutputStream out, float value) throws IOException {
        writeInt(out, Float.floatToRawIntBits(value));
    }

    void writeInt(OutputStream out, int value) throws IOException {
        out.write((value >>> 0) & 0xFF);
        out.write((value >>> 8) & 0xFF);
        out.write((value >>> 16) & 0xFF);
        out.write((value >>> 24) & 0xFF);
    }

    void writeShort(OutputStream out, int value) throws IOException {
        out.write((value >>> 0) & 0xFF);
        out.write((value >>> 8) & 0xFF);
    }
}