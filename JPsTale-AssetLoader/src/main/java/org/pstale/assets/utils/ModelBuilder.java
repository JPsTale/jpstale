package org.pstale.assets.utils;

import java.util.List;

import org.pstale.assets.AssetFactory;
import org.pstale.constants.SceneConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jme3.animation.AnimControl;
import com.jme3.animation.Animation;
import com.jme3.animation.Skeleton;
import com.jme3.animation.SkeletonControl;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Matrix4f;
import com.jme3.math.Transform;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.scene.plugins.smd.geom.GeomObject;
import com.jme3.scene.plugins.smd.geom.PAT3D;
import com.jme3.scene.plugins.smd.material.TEXLINK;
import com.jme3.scene.plugins.smd.material.SmMaterial;
import com.jme3.scene.plugins.smd.math.Matrix4D;
import com.jme3.util.BufferUtils;

/**
 * 根据解析出来的数据，生成jME3的材质。
 * 
 * @author yanmaoyuan
 *
 */
public class ModelBuilder {

    static Logger logger = LoggerFactory.getLogger(ModelBuilder.class);

    /**
     * 生成模型
     * 
     * @param pat
     * @param name
     * @return
     */
    public static Node buildModel(PAT3D pat, String name) {
        Node rootNode = new Node("PAT3D:" + name);
        rootNode.rotate( -FastMath.HALF_PI, 0, 0);
        Skeleton ske = null;
        // 生成骨骼
        if (pat.skeleton != null) {
            ske = AnimationBuilder.buildSkeleton(pat.skeleton);
            // 绑定动画控制器
            Animation anim = AnimationBuilder.buildAnimation(pat.skeleton);
            AnimControl ac = new AnimControl(ske);
            ac.addAnim(anim);
            rootNode.addControl(ac);
            rootNode.addControl(new SkeletonControl(ske));
        }

        logger.debug("Material Count: {}", pat.materialGroup.materialCount);

        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            if (obj.nFace > 0) {

                // 对所有顶点进行线性变换，否则顶点的坐标都在原点附近。
                invertPoint(obj);

                // 相对位置
                Matrix4f localMatrix = obj.localMatrix.value.transpose();
                
                Transform localTransform = new Transform();
                localTransform.fromTransformMatrix(localMatrix);
                
                // 根据模型的材质不同，将创建多个网格，分别渲染。
                for (int mat_id = 0; mat_id < pat.materialGroup.materialCount; mat_id++) {
                    // 生成网格
                    Mesh mesh = buildMesh(obj, mat_id, ske);

                    // 创建材质
                    SmMaterial m = pat.materialGroup.materials[mat_id];
                    Material mat;
                    if (SceneConstants.USE_LIGHT) {
                        mat = AssetFactory.createLightMaterial(m);
                    } else {
                        mat = AssetFactory.createMiscMaterial(m);
                    }

                    AssetFactory.setRenderState(m, mat);

                    // 创建几何体并应用材质。
                    Geometry geom = new Geometry(pat.objArray[i].NodeName + "#" + mat_id, mesh);
                    geom.setMaterial(mat);
                    
                    geom.setLocalTranslation(localTransform.getTranslation());
                    geom.setLocalRotation(localTransform.getRotation());
                    geom.setLocalScale(localTransform.getScale());
                    
                    rootNode.attachChild(geom);
                }
            }
        }

        return rootNode;
    }

    private static void invertPoint(GeomObject obj) {

        for (int i = 0; i < obj.nVertex; i++) {
        	Matrix4D mat = null;
        	if (obj.boneArray != null) {
        		mat = obj.boneArray[i].transformInvert;
        	} else {
        		mat = obj.transformInvert;
        	}
        	
            Matrix4f mat4 = mat.valueIT;
        	mat4.mult(obj.Vertex[i].v, obj.Vertex[i].v);
        }
    }

    /**
     * 生成网格数据。
     * 
     * @param ske
     * @return
     */
    public static Mesh buildMesh(GeomObject obj, int mat_id, Skeleton ske) {
        Mesh mesh = new Mesh();

        // 统计使用这个材质的面数
        int count = 0;
        for (int i = 0; i < obj.nFace; i++) {
            if (obj.Face[i].v[3] == mat_id) {
                count++;
            }
        }

        // 计算网格
        Vector3f[] position = new Vector3f[count * 3];
        int[] f = new int[count * 3];
        Vector2f[] uv = new Vector2f[count * 3];
        int index = 0;

        // Prepare MeshData
        for (int i = 0; i < obj.nFace; i++) {
            // 忽略掉这个面
            if (obj.Face[i].v[3] != mat_id) {
                continue;
            }

            // 顶点 VERTEX
            position[index * 3 + 0] = obj.Vertex[obj.Face[i].v[0]].v;
            position[index * 3 + 1] = obj.Vertex[obj.Face[i].v[1]].v;
            position[index * 3 + 2] = obj.Vertex[obj.Face[i].v[2]].v;

            // 面 FACE
            if (i < obj.nFace) {
                f[index * 3 + 0] = index * 3 + 0;
                f[index * 3 + 1] = index * 3 + 1;
                f[index * 3 + 2] = index * 3 + 2;
            }

            // 纹理映射
            TEXLINK tl = obj.Face[i].TexLink;
            if (tl != null) {
                // 第1组uv坐标
                uv[index * 3 + 0] = new Vector2f(tl.u[0], 1f - tl.v[0]);
                uv[index * 3 + 1] = new Vector2f(tl.u[1], 1f - tl.v[1]);
                uv[index * 3 + 2] = new Vector2f(tl.u[2], 1f - tl.v[2]);
            } else {
                uv[index * 3 + 0] = new Vector2f();
                uv[index * 3 + 1] = new Vector2f();
                uv[index * 3 + 2] = new Vector2f();
            }

            index++;
        }

        mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(position));
        mesh.setBuffer(Type.Index, 3, f);
        mesh.setBuffer(Type.TexCoord, 2, BufferUtils.createFloatBuffer(uv));

        // 骨骼蒙皮
        if (obj.boneArray != null && ske != null) {
            float[] boneIndex = new float[count * 12];
            float[] boneWeight = new float[count * 12];

            index = 0;
            for (int i = 0; i < obj.nFace; i++) {
                // 忽略这个面
                if (obj.Face[i].v[3] != mat_id) {
                    continue;
                }

                for (int j = 0; j < 3; j++) {
                    int v = obj.Face[i].v[j];// 顶点序号
                    int bi = index * 3 + j;// 对应骨骼的序号

                    GeomObject bone = obj.boneArray[v];
                    byte targetBoneIndex = (byte) ske.getBoneIndex(bone.NodeName);

                    boneIndex[bi * 4] = targetBoneIndex;
                    boneIndex[bi * 4 + 1] = 0;
                    boneIndex[bi * 4 + 2] = 0;
                    boneIndex[bi * 4 + 3] = 0;

                    boneWeight[bi * 4] = 1;
                    boneWeight[bi * 4 + 1] = 0;
                    boneWeight[bi * 4 + 2] = 0;
                    boneWeight[bi * 4 + 3] = 0;
                }

                index++;
            }

            mesh.setMaxNumWeights(1);
            // apply software skinning
            mesh.setBuffer(Type.BoneIndex, 4, boneIndex);
            mesh.setBuffer(Type.BoneWeight, 4, boneWeight);
            // apply hardware skinning
            mesh.setBuffer(Type.HWBoneIndex, 4, boneIndex);
            mesh.setBuffer(Type.HWBoneWeight, 4, boneWeight);

            mesh.generateBindPose(true);
        }

        mesh.setStatic();
        mesh.updateBound();
        mesh.updateCounts();

        return mesh;
    }

    /**
     * 计算顶点法线
     * @param verts
     * @return
     */
    public static Vector3f[] generateNormals(List<Vector3f> verts) {
        Vector3f[] normals = new Vector3f[verts.size()];
        for (int i = 0; i < normals.length;) {
            Vector3f normal = new Vector3f();
            Vector3f v1 = new Vector3f();
            Vector3f v2 = new Vector3f();

            v1 = verts.get(i + 1).subtract(verts.get(i));
            v2 = verts.get(i + 2).subtract(verts.get(i));
            v1.cross(v2, normal);
            normal.normalize();

            normals[i++] = normal;
            normals[i++] = normal;
            normals[i++] = normal;
        }

        return normals;
    }
}
