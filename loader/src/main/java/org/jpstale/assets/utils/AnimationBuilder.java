package org.jpstale.assets.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.plugins.smd.geom.GeomObject;
import org.jpstale.assets.plugins.smd.geom.MotionInfo;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.plugins.smd.geom.TransPosition;
import org.jpstale.assets.plugins.smd.geom.TransRotation;
import org.jpstale.assets.plugins.smd.geom.TransScale;

import com.jme3.animation.Animation;
import com.jme3.math.FastMath;
import com.jme3.animation.Bone;
import com.jme3.animation.BoneTrack;
import com.jme3.animation.Skeleton;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

/**
 * 将 SMD/SMB 动画数据转换为 jME3 格式
 *
 * @author yanmaoyuan
 *
 * <pre>
 * 坐标系转换说明 (DirectX → OpenGL):
 *
 * DirectX (jMe2/Direct3D):
 *   - 右手系
 *   - X = 右, Y = 上, Z = 前 (指向屏幕外)
 *
 * OpenGL (jMe3/OpenGL):
 *   - 右手系
 *   - X = 右, Y = 上, Z = 后 (指向屏幕内)
 *
 * 转换公式:
 *   OpenGL = DirectX 的 (x, z, -y) 或类似组合
 *
 * 四元数转换:
 *   DirectX 四元数 (qx, qy, qz, qw)
 *   OpenGL 四元数 (-qx, qz, qy, qw)
 * </pre>
 */
@Slf4j
public class AnimationBuilder {

    /**
     * 精灵的动画使用3DS MAX的默认速率，每秒30Tick，每Tick共160帧。
     * 也就是每秒4800帧。
     *
     * 但是smd文件中也另外存储了2个参数：
     * (1) 每秒Tick数 (默认30)
     * (2) 每Tick帧数 (默认160)
     * 这两个变量的值控制了动画播放的速率。
     */
    public final static int FramePerSecond = 4800;

    public final static int TickPerSecond = 30;
    public final static int FramePerTick = 160;

    /**
     * 生成骨骼
     *
     * @param skeleton PAT3D 骨骼结构
     * @return jME3 Skeleton
     */
    public static Skeleton buildSkeleton(PAT3D skeleton) {
        HashMap<String, Bone> boneMap = new HashMap<String, Bone>();
        Bone[] bones = new Bone[skeleton.objCount];

        for (int i = 0; i < skeleton.objCount; i++) {
            GeomObject obj = skeleton.objArray[i];

            // 创建一个骨头
            Bone bone = new Bone(obj.NodeName);
            bones[i] = bone;

            // 骨骼绑定变换：使用 SMB 原始数据，与顶点 transformInvert 空间一致；整体坐标系由 ModelBuilder 的 rootNode.rotate(-HALF_PI,0,0) 统一处理
            Vector3f translation = new Vector3f(obj.px, obj.py, obj.pz);
            Quaternion rotation = new Quaternion(obj.qx, obj.qy, obj.qz, -obj.qw);
            rotation.normalizeLocal();
            Vector3f scale = new Vector3f(obj.sx, obj.sy, obj.sz);
            bone.setBindTransforms(translation, rotation, scale);

            // 建立父子关系
            boneMap.put(obj.NodeName, bone);
            if (obj.NodeParent != null) {
                Bone parent = boneMap.get(obj.NodeParent);
                if (parent != null) {
                    parent.addChild(bone);
                }
            }
        }

        // 生成骨架
        Skeleton ske = new Skeleton(bones);
        return ske;
    }

    /**
     * 根据 MotionInfo 生成指定动画片段
     *
     * @param pat        PAT3D 结构
     * @param motionInfo 动画信息
     * @return jME3 Animation
     */
    public static Animation buildAnimation(PAT3D pat, MotionInfo motionInfo) {
        int startFrame;
        int endFrame;
        if (motionInfo.motionStartFrame > 0) {
            startFrame = motionInfo.motionStartFrame;
        } else if (motionInfo.talkStartFrame > 0) {
            startFrame = motionInfo.talkStartFrame;
        } else {
            log.warn("No animation included for {}", getAnimationNameById(motionInfo.State));
            return null;
        }
        endFrame = motionInfo.endFrame;

        // 动画时长与“跨 0 点”分段（如 Die: start=48640, end=768，表示从 48640 播到片尾再 0 到 768）
        int maxFrame = 0;
        for (int i = 0; i < pat.objCount; i++) {
            GeomObject o = pat.objArray[i];
            if (o != null && o.maxFrame > maxFrame) maxFrame = o.maxFrame;
        }
        float length;
        boolean wrap = endFrame < startFrame;
        if (wrap) {
            length = (float) ((maxFrame - startFrame + 1) + (endFrame + 1)) / FramePerSecond;
        } else {
            length = (float) (endFrame - startFrame) / FramePerSecond;
        }

        String name = getAnimationNameById(motionInfo.State);
        if (log.isDebugEnabled()) {
            log.debug("{} startFrame:{} endFrame:{} wrap:{} length:{}", name, startFrame, endFrame, wrap, length);
        }

        Animation anim = new Animation(name, length);

        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            BoneTrack track = buildBoneTrack(pat, obj, startFrame, endFrame, wrap, maxFrame);
            if (track != null) {
                int boneIndex = pat.getObjIndex(obj.NodeName);
                track = AnimationInterpolator.preprocess(track, boneIndex);
                track = AnimationInterpolator.interpolate(track, boneIndex, 30.0f);
                anim.addTrack(track);
            }
        }

        return anim;
    }

    /**
     * 生成完整的动画（所有帧）
     *
     * @param pat PAT3D 结构
     * @return jME3 Animation
     */
    public static Animation buildAnimation(PAT3D pat) {
        // 统计帧数
        int maxFrame = 0;
        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            if (obj.maxFrame > maxFrame) {
                maxFrame = obj.maxFrame;
            }
        }

        // 计算动画时常
        // 考虑原版 4800 FPS 与实际播放速度的差异
        float timeScale = 160.0f / 4800.0f; // 帧间隔调整
        float length = (float) maxFrame / FramePerSecond * timeScale;

        if (log.isDebugEnabled()) {
            log.debug("MaxFrame:{}, Tick:{}, Time:{}", maxFrame, maxFrame / FramePerTick, length);
        }

        Animation anim = new Animation("Anim", length);

        // 构建每个骨骼的动画轨迹
        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            BoneTrack track = buildBoneTrack(pat, obj, 0, maxFrame, false, maxFrame);
            if (track != null) {
                // 应用动画平滑处理
                int boneIndex = pat.getObjIndex(obj.NodeName);
                track = AnimationInterpolator.preprocess(track, boneIndex);
                track = AnimationInterpolator.interpolate(track, boneIndex, 30.0f); // 目标 30 FPS
                anim.addTrack(track);
            }
        }

        return anim;
    }

    /**
     * 判断帧是否落在当前动画区间内。wrap 为 true 表示跨 0 点（如 Die：startFrame..maxFrame 再 0..endFrame）。
     */
    private static boolean inRange(int frame, int startFrame, int endFrame, boolean wrap, int maxFrame) {
        if (wrap) {
            return frame >= startFrame || frame <= endFrame;
        }
        return frame >= startFrame && frame <= endFrame;
    }

    /**
     * 计算该帧在动画时间轴上的时间（秒）。wrap 时前半段 [startFrame,maxFrame]，后半段 [0,endFrame]。
     */
    private static float frameToTime(int frame, int startFrame, int endFrame, boolean wrap, int maxFrame) {
        if (!wrap) {
            return (float) (frame - startFrame) / FramePerSecond;
        }
        if (frame >= startFrame) {
            return (float) (frame - startFrame) / FramePerSecond;
        }
        return (float) (maxFrame - startFrame + 1 + frame) / FramePerSecond;
    }

    /**
     * 为单个骨骼构建动画轨迹（BoneTrack）。坐标系与 bind 一致，由 rootNode 统一做 DX→GL。
     */
    private static BoneTrack buildBoneTrack(PAT3D pat, GeomObject obj, int startFrame, int endFrame, boolean wrap, int maxFrame) {
        Vector3f bindPosition = new Vector3f(obj.px, obj.py, obj.pz);
        Quaternion bindRotation = new Quaternion(obj.qx, obj.qy, obj.qz, -obj.qw);
        bindRotation.normalizeLocal();
        Quaternion bindRotationInverse = bindRotation.inverse();
        Vector3f bindScale = new Vector3f(obj.sx, obj.sy, obj.sz);

        TreeMap<Integer, Keyframe> keyframes = new TreeMap<Integer, Keyframe>();

        for (int j = 0; j < obj.TmPosCnt; j++) {
            TransPosition pos = obj.posArray[j];
            if (!inRange(pos.frame, startFrame, endFrame, wrap, maxFrame)) continue;
            Keyframe k = getOrMakeKeyframe(keyframes, pos.frame);
            k.translation.set(pos.x - bindPosition.x, pos.y - bindPosition.y, pos.z - bindPosition.z);
        }

        for (int j = 0; j < obj.TmRotCnt; j++) {
            TransRotation rot = obj.rotArray[j];
            if (!inRange(rot.frame, startFrame, endFrame, wrap, maxFrame)) continue;
            Keyframe k = getOrMakeKeyframe(keyframes, rot.frame);
            Quaternion rotQ = new Quaternion(rot.axisX, rot.axisY, rot.axisZ, -rot.cosHalfAngle);
            rotQ.normalizeLocal();
            bindRotationInverse.mult(rotQ, k.rotation);
        }

        for (int j = 0; j < obj.TmScaleCnt; j++) {
            TransScale scale = obj.scaleArray[j];
            if (!inRange(scale.frame, startFrame, endFrame, wrap, maxFrame)) continue;
            Keyframe k = getOrMakeKeyframe(keyframes, scale.frame);
            k.scale.set(scale.x / bindScale.x, scale.y / bindScale.y, scale.z / bindScale.z);
        }

        if (keyframes.isEmpty()) return null;

        // 按播放时间排序（wrap 时 0..endFrame 在 maxFrame 之后）
        Integer[] frameArr = keyframes.keySet().toArray(new Integer[0]);
        Arrays.sort(frameArr, (a, b) -> Float.compare(
            frameToTime(a.intValue(), startFrame, endFrame, wrap, maxFrame),
            frameToTime(b.intValue(), startFrame, endFrame, wrap, maxFrame)));

        int n = frameArr.length;
        float[] times = new float[n];
        Vector3f[] translations = new Vector3f[n];
        Quaternion[] rotations = new Quaternion[n];
        Vector3f[] scales = new Vector3f[n];

        Keyframe last = null;
        for (int i = 0; i < n; i++) {
            int frame = frameArr[i].intValue();
            Keyframe current = keyframes.get(frame);
            if (current.translation == null) current.translation = last != null ? new Vector3f(last.translation) : new Vector3f(0, 0, 0);
            if (current.rotation == null) current.rotation = last != null ? new Quaternion(last.rotation) : new Quaternion(0, 0, 0, 1);
            if (current.scale == null) current.scale = last != null ? new Vector3f(last.scale) : new Vector3f(1, 1, 1);
            times[i] = frameToTime(frame, startFrame, endFrame, wrap, maxFrame);
            translations[i] = current.translation;
            rotations[i] = current.rotation.normalizeLocal();
            scales[i] = current.scale;
            last = current;
        }

        BoneTrack track = new BoneTrack(pat.getObjIndex(obj.NodeName));
        track.setKeyframes(times, translations, rotations, scales);
        return track;
    }

    /**
     * 根据帧的编号来查询 Keyframe 数据
     *
     * @param keyframes 关键帧集合
     * @param frame     帧号
     * @return 关键帧（新建或已有）
     */
    private static Keyframe getOrMakeKeyframe(SortedMap<Integer, Keyframe> keyframes, Integer frame) {
        Keyframe k = keyframes.get(frame);
        if (k == null) {
            k = new Keyframe();
            keyframes.put(frame, k);
        }
        return k;
    }

    /**
     * 关键帧数据结构
     */
    private static class Keyframe {
        public Vector3f translation = new Vector3f(0, 0, 0);
        public Quaternion rotation = new Quaternion(0, 0, 0, 1);
        public Vector3f scale = new Vector3f(1, 1, 1);
    }

    /**
     * 根据动画 ID 获取动画名称
     *
     * @param id 动画状态 ID
     * @return 动画名称
     */
    public static String getAnimationNameById(int id) {
        String ret = "unknown";

        switch (id) {
        case 64:// 0x40
            ret = "Idle";
            break;
        case 80:// 0x50
            ret = "Walk";
            break;
        case 96:// 0x60
            ret = "Run";
            break;
        case 128:// 0x80
            ret = "Fall";
            break;
        case 256:// 0x100
            ret = "Attack";
            break;
        case 272:// 0x110
            ret = "Damage";
            break;
        case 288:// 0x120
            ret = "Die";
            break;
        case 304:// 0x130
            ret = "Sometimes";
            break;
        case 320:// 0x140
            ret = "Potion";
            break;
        case 336:// 0x150
            ret = "Technique";
            break;
        case 368:// 0x170
            ret = "Landing (small)";
            break;
        case 384:// 0x180
            ret = "Landing (large)";
            break;
        case 512:// 0x200
            ret = "Standup";
            break;
        case 528:// 0x210
            ret = "Cry";
            break;
        case 544:// 0x220
            ret = "Hurray";
            break;
        case 576:// 0x240
            ret = "Jump";
            break;
        case 1024: // 0x400
            ret = "Talk (I)";
            break;
        case 1040: // 0x410
            ret = "Talk (I)";
            break;
        case 1056:// 0x420
            ret = "Talk (II)";
            break;
        case 1072:// 0x430
            ret = "Talk (III)";
            break;
        case 1088:// 0x440
            ret = "Talk (IV)";
            break;
        case 1104:// 0x450
            ret = "Talk (V)";
            break;
        default:
            log.debug("Unknow animation id: {}", id);
        }

        return ret;
    }
}