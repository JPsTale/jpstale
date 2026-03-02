package org.jpstale.assets.utils;

import com.jme3.animation.BoneTrack;
import com.jme3.animation.Skeleton;
import com.jme3.animation.Track;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.util.TempVars;

/**
 * 动画插值器
 * 用于在关键帧之间进行平滑插值，消除动画播放时的僵硬感
 */
public class AnimationInterpolator {

    /**
     * 对骨骼轨迹应用插值，生成更平滑的动画
     *
     * @param track 原始骨骼轨迹
     * @param boneIndex 骨骼索引
     * @param targetFPS 目标帧率（建议 30-60 FPS）
     * @return 插值后的骨骼轨迹
     */
    public static BoneTrack interpolate(BoneTrack track, int boneIndex, float targetFPS) {
        if (track == null || track.getTimes().length < 2) {
            return track; // 无需插值
        }

        float[] originalTimes = track.getTimes();
        Vector3f[] originalTranslations = track.getTranslations();
        Quaternion[] originalRotations = track.getRotations();
        Vector3f[] originalScales = track.getScales();

        float duration = originalTimes[originalTimes.length - 1];
        int targetFrameCount = (int) (duration * targetFPS) + 1;

        float[] newTimes = new float[targetFrameCount];
        Vector3f[] newTranslations = new Vector3f[targetFrameCount];
        Quaternion[] newRotations = new Quaternion[targetFrameCount];
        Vector3f[] newScales = new Vector3f[targetFrameCount];

        // 计算时间步长
        float timeStep = 1.0f / targetFPS;

        for (int i = 0; i < targetFrameCount; i++) {
            float time = i * timeStep;
            newTimes[i] = time;

            // 找到原始时间轴上对应的两个关键帧
            int index = findKeyframeIndex(originalTimes, time);

            if (index == originalTimes.length - 1) {
                // 最后一帧
                newTranslations[i] = originalTranslations[index].clone();
                newRotations[i] = originalRotations[index].clone();
                newScales[i] = originalScales[index].clone();
            } else {
                // 计算插值参数
                float t1 = originalTimes[index];
                float t2 = originalTimes[index + 1];
                float alpha = (time - t1) / (t2 - t1);

                // 位置插值（线性插值）
                newTranslations[i] = new Vector3f();
                newTranslations[i].interpolateLocal(originalTranslations[index],
                                                   originalTranslations[index + 1], alpha);

                // 旋转插值（球面线性插值）
                newRotations[i] = originalRotations[index].clone();
                newRotations[i].slerp(originalRotations[index + 1], alpha);

                // 缩放插值（线性插值）
                newScales[i] = new Vector3f();
                newScales[i].interpolateLocal(originalScales[index],
                                             originalScales[index + 1], alpha);
            }
        }

        // 创建新的骨骼轨迹
        BoneTrack newTrack = new BoneTrack(boneIndex, newTimes, newTranslations, newRotations, newScales);

        return newTrack;
    }

    /**
     * 对骨架中的所有骨骼轨迹应用插值
     *
     * @param tracks 原始骨骼轨迹数组
     * @param boneIndices 对应的骨骼索引数组
     * @param targetFPS 目标帧率
     * @return 插值后的骨骼轨迹数组
     */
    public static BoneTrack[] interpolateAll(BoneTrack[] tracks, int[] boneIndices, float targetFPS) {
        if (tracks == null || tracks.length == 0) {
            return tracks;
        }

        BoneTrack[] interpolatedTracks = new BoneTrack[tracks.length];
        for (int i = 0; i < tracks.length; i++) {
            interpolatedTracks[i] = interpolate(tracks[i], boneIndices[i], targetFPS);
        }

        return interpolatedTracks;
    }

    /**
     * 使用过滤方法平滑动画轨迹
     * 通过平均相邻帧来消除高频抖动
     *
     * @param track 原始骨骼轨迹
     * @param boneIndex 骨骼索引
     * @param windowSize 平滑窗口大小（建议 2-5）
     * @return 平滑后的骨骼轨迹
     */
    public static BoneTrack smooth(BoneTrack track, int boneIndex, int windowSize) {
        if (track == null || track.getTimes().length < windowSize) {
            return track;
        }

        float[] times = track.getTimes();
        Vector3f[] translations = track.getTranslations();
        Quaternion[] rotations = track.getRotations();
        Vector3f[] scales = track.getScales();
        int frameCount = times.length;

        // 创建临时数组存储平滑后的值
        Vector3f[] smoothedTranslations = new Vector3f[frameCount];
        Quaternion[] smoothedRotations = new Quaternion[frameCount];
        Vector3f[] smoothedScales = new Vector3f[frameCount];

        // 使用移动平均窗口进行平滑
        for (int i = 0; i < frameCount; i++) {
            int start = Math.max(0, i - windowSize / 2);
            int end = Math.min(frameCount - 1, i + windowSize / 2);
            int count = end - start + 1;

            // 位置平滑
            smoothedTranslations[i] = new Vector3f();
            for (int j = start; j <= end; j++) {
                smoothedTranslations[i].addLocal(translations[j]);
            }
            smoothedTranslations[i].divideLocal(count);

            // 旋转平滑（使用四元数平均）
            smoothedRotations[i] = averageQuaternions(rotations, start, end);

            // 缩放平滑
            smoothedScales[i] = new Vector3f();
            for (int j = start; j <= end; j++) {
                smoothedScales[i].addLocal(scales[j]);
            }
            smoothedScales[i].divideLocal(count);
        }

        // 创建新的骨骼轨迹
        BoneTrack smoothedTrack = new BoneTrack(boneIndex, times, smoothedTranslations, smoothedRotations, smoothedScales);

        return smoothedTrack;
    }

    /**
     * 计算多个四元数的平均值
     */
    private static Quaternion averageQuaternions(Quaternion[] quaternions, int start, int end) {
        TempVars vars = TempVars.get();
        Vector3f sumAxis = vars.vect1;
        float[] tempAngles = new float[3];
        float sumAngle = 0;

        // 将所有四元数转换为轴角表示并累加
        for (int i = start; i <= end; i++) {
            float[] angles = quaternions[i].toAngles(tempAngles);

            // 转换为轴角
            float angle = angles[0];
            Vector3f axis = new Vector3f(angles[1], angles[2], angles[3]);

            if (axis.length() > 0.000001f) { // 使用小数值代替 FastMath.FLT_EPSILON
                sumAxis.addLocal(axis.mult(angle));
            }
            sumAngle += angle;
        }

        // 计算平均轴角
        int count = end - start + 1;
        sumAxis.divideLocal(count);
        sumAngle /= count;

        // 转换回四元数
        Quaternion avg = new Quaternion();
        avg.fromAngleAxis(sumAngle, sumAxis);

        vars.release();
        return avg;
    }

    /**
     * 找到给定时间对应的关键帧索引
     */
    private static int findKeyframeIndex(float[] times, float time) {
        for (int i = 0; i < times.length - 1; i++) {
            if (time >= times[i] && time < times[i + 1]) {
                return i;
            }
        }
        return times.length - 1;
    }

    /**
     * 预处理动画数据，修复明显错误的帧
     *
     * @param track 原始骨骼轨迹
     * @param boneIndex 骨骼索引
     * @return 修复后的骨骼轨迹
     */
    public static BoneTrack preprocess(BoneTrack track, int boneIndex) {
        if (track == null || track.getTimes().length < 3) {
            return track;
        }

        float[] times = track.getTimes();
        Vector3f[] translations = track.getTranslations();
        Quaternion[] rotations = track.getRotations();
        Vector3f[] scales = track.getScales();

        // 检测并修复异常值
        for (int i = 1; i < translations.length - 1; i++) {
            // 检查位置突变
            Vector3f deltaPrev = translations[i].subtract(translations[i - 1]);
            Vector3f deltaNext = translations[i + 1].subtract(translations[i]);

            // 如果位置变化过大，插值修正
            if (deltaPrev.lengthSquared() > 100.0f || deltaNext.lengthSquared() > 100.0f) {
                translations[i].interpolateLocal(translations[i - 1], translations[i + 1], 0.5f);
            }

            // 检查旋转突变
            Quaternion rotPrev = rotations[i - 1];
            Quaternion rotCurr = rotations[i];
            Quaternion rotNext = rotations[i + 1];

            float dotPrev = rotPrev.dot(rotCurr);
            float dotNext = rotCurr.dot(rotNext);

            // 如果旋转角度变化超过 90 度，插值修正
            if (dotPrev < 0 || dotNext < 0) {
                rotations[i].slerp(rotations[i - 1], rotations[i + 1], 0.5f);
            }
        }

        // 创建新的骨骼轨迹
        BoneTrack processedTrack = new BoneTrack(boneIndex, times, translations, rotations, scales);

        return processedTrack;
    }
}