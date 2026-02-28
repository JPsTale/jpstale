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

            // 骨骼绑定变换 - 原始 DirectX 数据
            Vector3f translation = new Vector3f(obj.px, obj.py, obj.pz);
            Quaternion rotation = new Quaternion(obj.qx, obj.qy, obj.qz, -obj.qw);
            Vector3f scale = new Vector3f(obj.sx, obj.sy, obj.sz);

            // 确保旋转是规范的
            rotation.normalizeLocal();

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
        // 起始帧
        int startTick = 0;
        // 结束帧数
        int endTick = 0;

        if (motionInfo.motionStartFrame > 0) {
            startTick = motionInfo.motionStartFrame / 256;
        } else if (motionInfo.talkStartFrame > 0) {
            startTick = motionInfo.talkStartFrame / 256;
        } else {
            log.warn("No animation included for {}", getAnimationNameById(motionInfo.State));
            return null;
        }
        endTick = motionInfo.endFrame / 256;

        // 这种是需要倒放的动画
        boolean backForward = false;
        if (endTick < startTick) {
            int tmp = endTick;
            endTick = startTick;
            startTick = tmp;
            backForward = true;
            log.debug("需要倒放的动画!");
        }

        // 计算开始和结束的帧，用于截取动画数据
        int startFrame = startTick * FramePerTick;
        int endFrame = endTick * FramePerTick;

        // 计算动画时常
        float length = (float) (endTick - startTick) / TickPerSecond;

        String name = getAnimationNameById(motionInfo.State);
        if (log.isDebugEnabled()) {
            log.debug("{} startKey:{} endKey:{} length:{}", name, startTick, endTick, length);
        }

        Animation anim = new Animation(name, length);

        // 构建每个骨骼的动画轨迹
        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            BoneTrack track = buildBoneTrack(pat, obj, startFrame, endFrame);
            if (track != null) {
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
        float length = (float) maxFrame / FramePerSecond;

        if (log.isDebugEnabled()) {
            log.debug("MaxFrame:{}, Tick:{}, Time:{}", maxFrame, maxFrame / FramePerTick, length);
        }

        Animation anim = new Animation("Anim", length);

        // 构建每个骨骼的动画轨迹
        for (int i = 0; i < pat.objCount; i++) {
            GeomObject obj = pat.objArray[i];
            BoneTrack track = buildBoneTrack(pat, obj, 0, maxFrame);
            if (track != null) {
                anim.addTrack(track);
            }
        }

        return anim;
    }

    /**
     * 为单个骨骼构建动画轨迹（BoneTrack）
     *
     * 注意：ModelBuilder 中有 rootNode.rotate(-HALF_PI, 0, 0) 将整个模型旋转
     * 为了让骨骼动画与模型对齐，骨骼的旋转也需要应用相同的变换
     *
     * @param pat        PAT3D 结构
     * @param obj        GeomObject（骨骼节点）
     * @param startFrame 起始帧
     * @param endFrame   结束帧
     * @return BoneTrack 或 null（如果没有动画数据）
     */
    private static BoneTrack buildBoneTrack(PAT3D pat, GeomObject obj, int startFrame, int endFrame) {
        // 骨骼的初始姿态（Bind Pose）- 原始 DirectX 数据
        Vector3f bindPosition = new Vector3f(obj.px, obj.py, obj.pz);
        Quaternion bindRotation = new Quaternion(obj.qx, obj.qy, obj.qz, -obj.qw);
        bindRotation.normalizeLocal();
        Quaternion bindRotationInverse = bindRotation.inverse();
        Vector3f bindScale = new Vector3f(obj.sx, obj.sy, obj.sz);

        // ModelBuilder 中的变换：绕 X 轴旋转 -90 度 (T)
        // 需要计算坐标系基变更：T^-1 * DX * T
        Quaternion dxToGl = new Quaternion();
        dxToGl.fromAngles(-FastMath.HALF_PI, 0, 0);
        Quaternion glToDx = dxToGl.inverse();

        // 变换后的绑定旋转（用于计算相对变换）
        Quaternion bindRotationGL = glToDx.mult(bindRotation).mult(dxToGl);
        Quaternion bindRotationGLInverse = bindRotationGL.inverse();

        // 统计关键帧
        TreeMap<Integer, Keyframe> keyframes = new TreeMap<Integer, Keyframe>();

        // ============== 处理位置关键帧 ==============
        for (int j = 0; j < obj.TmPosCnt; j++) {
            TransPosition pos = obj.posArray[j];
            if (pos.frame < startFrame || pos.frame > endFrame) {
                continue;
            }

            Keyframe k = getOrMakeKeyframe(keyframes, pos.frame);
            // 原始位置 - bind位置
            k.translation.set(pos.x - bindPosition.x, pos.y - bindPosition.y, pos.z - bindPosition.z);
        }

        // ============== 处理旋转关键帧 ==============
        for (int j = 0; j < obj.TmRotCnt; j++) {
            TransRotation rot = obj.rotArray[j];
            if (rot.frame < startFrame || rot.frame > endFrame) {
                continue;
            }

            Keyframe k = getOrMakeKeyframe(keyframes, rot.frame);
            // 原始四元数 (qx, qy, qz, -qw)
            Quaternion rotQ = new Quaternion(rot.axisX, rot.axisY, rot.axisZ, -rot.cosHalfAngle);
            rotQ.normalizeLocal();

            // 将动画旋转变换到 OpenGL 坐标系：T^-1 * DX * T
            Quaternion rotGL = glToDx.mult(rotQ).mult(dxToGl);

            if (j == obj.lowestRotFrame) {
                // 第一帧：计算相对于变换后绑定姿态的相对旋转
                bindRotationGLInverse.mult(rotGL, k.rotation);
            } else {
                k.rotation.set(rotGL);
            }
        }

        // ============== 处理缩放关键帧 ==============
        for (int j = 0; j < obj.TmScaleCnt; j++) {
            TransScale scale = obj.scaleArray[j];
            if (scale.frame < startFrame || scale.frame > endFrame) {
                continue;
            }

            Keyframe k = getOrMakeKeyframe(keyframes, scale.frame);
            // 相对缩放
            k.scale.set(scale.x / bindScale.x, scale.y / bindScale.y, scale.z / bindScale.z);
        }

        int size = keyframes.size();
        if (size == 0) {
            return null; // 没有动画数据
        }

        // 准备 BoneTrack 数据
        float[] times = new float[size];
        Vector3f[] translations = new Vector3f[size];
        Quaternion[] rotations = new Quaternion[size];
        Vector3f[] scales = new Vector3f[size];

        Keyframe last = null;
        int n = 0;

        for (Integer frame : keyframes.keySet()) {
            Keyframe current = keyframes.get(frame);

            // 补全缺失的数据（使用上一帧的数据）
            if (current.translation == null) {
                if (n == 0) {
                    current.translation = new Vector3f(0, 0, 0);
                } else {
                    current.translation = new Vector3f(last.translation);
                }
            }

            if (current.rotation == null) {
                if (n == 0) {
                    current.rotation = new Quaternion(0, 0, 0, 1);
                } else {
                    current.rotation = new Quaternion(last.rotation);
                }
            }

            if (current.scale == null) {
                if (n == 0) {
                    current.scale = new Vector3f(1, 1, 1);
                } else {
                    current.scale = new Vector3f(last.scale);
                }
            }

            times[n] = (float) frame / FramePerSecond;
            translations[n] = current.translation;
            rotations[n] = current.rotation.normalizeLocal();
            scales[n] = current.scale;

            // 记录当前帧
            last = current;

            n++;
        }

        // 截取有效数据
        times = Arrays.copyOfRange(times, 0, n);
        translations = Arrays.copyOfRange(translations, 0, n);
        rotations = Arrays.copyOfRange(rotations, 0, n);
        scales = Arrays.copyOfRange(scales, 0, n);

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