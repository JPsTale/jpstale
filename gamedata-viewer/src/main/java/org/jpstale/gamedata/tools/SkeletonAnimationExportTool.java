package org.jpstale.gamedata.tools;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import com.jme3.asset.AssetManager;
import com.jme3.asset.DesktopAssetManager;
import org.json.JSONArray;
import org.json.JSONObject;

import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.smd.geom.AnimateModel;
import org.jpstale.assets.plugins.smd.geom.GeomObject;
import org.jpstale.assets.plugins.smd.geom.MotionInfo;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.plugins.smd.geom.TransPosition;
import org.jpstale.assets.plugins.smd.geom.TransRotation;
import org.jpstale.assets.plugins.smd.geom.TransScale;
import org.jpstale.assets.utils.AnimationBuilder;
import org.jpstale.assets.utils.AssetNameUtils;
import org.jpstale.utils.FileLocator;

/**
 * 将 INX + SMB 骨骼动画数据导出为 JSON，便于分析 bindPose、关键帧与动画分段。
 *
 * 用法示例（在已有 AssetManager 环境下，如 GameDataViewer 里）：
 *
 * <pre>
 *   AssetManager am = ...; // 已通过 EmbeddedPreviewApp / ModelPreviewApp 初始化
 *   SkeletonAnimationExportTool.exportToJson(
 *       am,
 *       clientRootPath,                          // 例如 \"/Users/yanmaoyuan/PTCN2020\"
 *       \"char/monster/hopy/hopy.inx\",
 *       new File(\"hopy_skeleton_animation.json\")
 *   );
 * </pre>
 */
public final class SkeletonAnimationExportTool {

    private SkeletonAnimationExportTool() {
    }

    /**
     * 方便在工具菜单中直接调用的简化入口：内部创建一个临时 DesktopAssetManager。
     *
     * @param gameRoot      游戏资源根目录（客户端根目录，含 char/、image/ 等）
     * @param characterPath 角色 INX 路径
     * @param outputFile    输出 JSON 文件
     * @return 导出的 JSON 根对象，若失败返回 null
     */
    public static JSONObject exportWithNewManager(String gameRoot,
                                                  String characterPath,
                                                  File outputFile) {
        DesktopAssetManager am = new DesktopAssetManager(true);
        return exportToJson(am, gameRoot, characterPath, outputFile);
    }

    /**
     * 导出指定角色路径的骨骼与动画数据到 JSON 文件。
     *
     * @param assetManager  已注册 InxLoader/SmbLoader 的 AssetManager
     * @param gameRoot      游戏资源根目录（用于 FileLocator，允许为 null/空）
     * @param characterPath 角色 INX 路径，例如 "char/monster/hopy/hopy.inx"
     * @param outputFile    输出 JSON 文件（可为 null，仅返回 JSONObject）
     * @return 导出的 JSON 根对象，若失败返回 null
     */
    public static JSONObject exportToJson(AssetManager assetManager,
                                          String gameRoot,
                                          String characterPath,
                                          File outputFile) {
        if (assetManager == null || characterPath == null || characterPath.isEmpty()) {
            return null;
        }

        // 复用 loader 模块的工厂与定位器
        AssetFactory.setAssetManager(assetManager);
        if (gameRoot != null && !gameRoot.isEmpty()) {
            AssetFactory.setFolder(gameRoot);
            assetManager.registerLocator(gameRoot, FileLocator.class);
        }

        try {
            AnimateModel inx = AssetFactory.loadInx(characterPath);
            if (inx == null) {
                return null;
            }

            String folder = AssetNameUtils.getFolder(characterPath);
            String motionFile = inx.motionFile;
            if (motionFile == null || motionFile.isEmpty()) {
                return null;
            }

            // INX 中记录的是 motionFile（通常为 *.smb 或对应名字），这里统一转成 smb
            String smbName = AssetNameUtils.getName(AssetNameUtils.changeExt(motionFile, "smb"));
            PAT3D skeleton = AssetFactory.loadSmb(folder + smbName);
            if (skeleton == null) {
                return null;
            }

            JSONObject root = new JSONObject();
            root.put("source", characterPath);
            root.put("gameRoot", gameRoot != null ? gameRoot : "");
            root.put("inx", buildInxJson(inx));
            root.put("skeleton", buildSkeletonJson(skeleton));

            if (outputFile != null) {
                File parent = outputFile.getParentFile();
                if (parent != null) {
                    parent.mkdirs();
                }
                try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(outputFile.toPath(), StandardCharsets.UTF_8))) {
                    w.print(root.toString(2));
                }
            }

            return root;
        } catch (IOException e) {
            // 主要是文件写入失败时才会到这里，AssetManager 的加载异常已在内部处理/抛出
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject buildInxJson(AnimateModel inx) {
        JSONObject o = new JSONObject();
        o.put("modelFile", inx.modelFile != null ? inx.modelFile : "");
        o.put("motionFile", inx.motionFile != null ? inx.motionFile : "");
        o.put("motionLinkFile", inx.motionLinkFile != null ? inx.motionLinkFile : "");
        o.put("subMotionCount", inx.subMotionCount);

        JSONArray arr = new JSONArray();
        if (inx.subMotions != null) {
            for (int i = 0; i < inx.subMotionCount && i < inx.subMotions.length; i++) {
                MotionInfo mi = inx.subMotions[i];
                if (mi == null) {
                    continue;
                }
                JSONObject m = new JSONObject();
                m.put("state", mi.State);
                m.put("name", AnimationBuilder.getAnimationNameById(mi.State));
                m.put("motionStartFrame", mi.motionStartFrame);
                m.put("talkStartFrame", mi.talkStartFrame);
                m.put("endFrame", mi.endFrame);
                m.put("MotionKeyWord_2", mi.MotionKeyWord_2);
                arr.put(m);
            }
        }
        o.put("subMotions", arr);
        return o;
    }

    private static JSONObject buildSkeletonJson(PAT3D skeleton) {
        JSONObject o = new JSONObject();
        o.put("objCount", skeleton.objCount);

        // MaxFrame 字段在 PAT3D 内部是包可见，这里通过每个 GeomObject.maxFrame 重新统计
        int maxFrame = 0;
        for (int i = 0; i < skeleton.objCount; i++) {
            GeomObject obj = skeleton.objArray[i];
            if (obj != null && obj.maxFrame > maxFrame) {
                maxFrame = obj.maxFrame;
            }
        }
        o.put("maxFrame", maxFrame);

        JSONArray arr = new JSONArray();
        for (int i = 0; i < skeleton.objCount; i++) {
            GeomObject obj = skeleton.objArray[i];
            if (obj == null) {
                continue;
            }
            arr.put(buildGeomObjectJson(i, obj));
        }
        o.put("objects", arr);
        return o;
    }

    private static JSONObject buildGeomObjectJson(int index, GeomObject obj) {
        JSONObject o = new JSONObject();
        o.put("index", index);
        o.put("nodeName", obj.NodeName != null ? obj.NodeName : "");
        o.put("nodeParent", obj.NodeParent != null ? obj.NodeParent : "");

        JSONObject bind = new JSONObject();
        bind.put("px", obj.px);
        bind.put("py", obj.py);
        bind.put("pz", obj.pz);
        bind.put("qx", obj.qx);
        bind.put("qy", obj.qy);
        bind.put("qz", obj.qz);
        bind.put("qw", obj.qw);
        bind.put("sx", obj.sx);
        bind.put("sy", obj.sy);
        bind.put("sz", obj.sz);
        o.put("bindPose", bind);

        o.put("tmRotCnt", obj.TmRotCnt);
        o.put("tmPosCnt", obj.TmPosCnt);
        o.put("tmScaleCnt", obj.TmScaleCnt);
        o.put("maxFrame", obj.maxFrame);
        o.put("lowestRotFrame", obj.lowestRotFrame);

        JSONArray rots = new JSONArray();
        if (obj.rotArray != null) {
            for (TransRotation r : obj.rotArray) {
                if (r == null) {
                    continue;
                }
                JSONObject rj = new JSONObject();
                rj.put("frame", r.frame);
                rj.put("axisX", r.axisX);
                rj.put("axisY", r.axisY);
                rj.put("axisZ", r.axisZ);
                rj.put("cosHalfAngle", r.cosHalfAngle);
                rots.put(rj);
            }
        }
        o.put("rotations", rots);

        JSONArray pos = new JSONArray();
        if (obj.posArray != null) {
            for (TransPosition p : obj.posArray) {
                if (p == null) {
                    continue;
                }
                JSONObject pj = new JSONObject();
                pj.put("frame", p.frame);
                pj.put("x", p.x);
                pj.put("y", p.y);
                pj.put("z", p.z);
                pos.put(pj);
            }
        }
        o.put("positions", pos);

        JSONArray scl = new JSONArray();
        if (obj.scaleArray != null) {
            for (TransScale s : obj.scaleArray) {
                if (s == null) {
                    continue;
                }
                JSONObject sj = new JSONObject();
                sj.put("frame", s.frame);
                sj.put("x", s.x);
                sj.put("y", s.y);
                sj.put("z", s.z);
                scl.put(sj);
            }
        }
        o.put("scales", scl);

        return o;
    }
}

