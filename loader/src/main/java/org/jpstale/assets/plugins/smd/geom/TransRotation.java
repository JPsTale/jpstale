package org.jpstale.assets.plugins.smd.geom;

import java.io.IOException;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * 旋转动画关键帧数据 - axis-angle 格式
 *
 * C++ 原始数据结构 (smTM_ROT):
 * <pre>
 * struct smTM_ROT {
 *     int     Frame;      // 帧号
 *     float   x, y, z;    // 旋转轴 (axis vector，不是归一化的)
 *     float   w;          // cos(θ/2) = cos(angle/2)，不是四元数的 w
 * };
 * // sizeof = 20 bytes (0x14)
 * </pre>
 *
 * 注意：C++ 代码中的 4x4 矩阵转换和四元数转换使用复杂的变换公式。
 * 实际读取时需要：
 * 1. 读取 axis(x,y,z) 和 cos(θ/2) = w
 * 2. 计算 sin(θ/2) = sqrt(1 - w*w)
 * 3. 构建四元数: (axis * sin(θ/2), cos(θ/2))
 *
 * @see smdreader.cpp:334-358
 */
public class TransRotation extends Flyweight {
    /** 帧号 */
    public int frame;

    /** 旋转轴 X 分量 (需要归一化) */
    public float axisX;

    /** 旋转轴 Y 分量 (需要归一化) */
    public float axisY;

    /** 旋转轴 Z 分量 (需要归一化) */
    public float axisZ;

    /** cos(θ/2)，需要用 acos 获取实际角度 */
    public float cosHalfAngle;

    /**
     * 读取轴角数据
     *
     * @param in LittleEndian 输入流
     * @throws IOException 读取异常
     */
    public void loadData(LittleEndien in) throws IOException {
        frame = in.readInt();
        axisX = in.readFloat();
        axisY = in.readFloat();
        axisZ = in.readFloat();
        cosHalfAngle = in.readFloat();
    }

    /**
     * 将 axis-angle 转换为四元数
     *
     * DirectX → OpenGL 坐标系转换:
     * - C++ 原始数据是 DirectX 格式 (Y up, Z forward)
     * - jME3 使用 OpenGL 格式 (Y up, Z backward)
     * - 需要交换 Y 和 Z 轴，并调整分量符号
     *
     * @return 归一化的四元数
     */
    public Quaternion toQuaternion() {
        // 计算 sin(θ/2)
        float sinHalfAngle = FastMath.sqrt(Math.max(0f, 1.0f - cosHalfAngle * cosHalfAngle));

        // 归一化旋转轴
        float length = FastMath.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        if (length < 0.0001f) {
            // 轴无效，返回单位四元数
            return new Quaternion(0, 0, 0, 1);
        }

        float invLength = 1.0f / length;
        float ax = axisX * invLength;
        float ay = axisY * invLength;
        float az = axisZ * invLength;

        // 构建基础四元数 (DirectX 坐标系)
        // q = (axis * sin(θ/2), cos(θ/2))
        float qx = ax * sinHalfAngle;
        float qy = ay * sinHalfAngle;
        float qz = az * sinHalfAngle;
        float qw = cosHalfAngle;

        // DirectX → OpenGL 坐标系转换
        // 交换 qy 和 qz：(-qx, qz, qy, -qw)
        // DirectX: (x, y, z, w) - Y up, Z forward
        // OpenGL: (-x, z, y, -w) - Z up, Y forward
        //
        // 注意：ModelBuilder 中有 rootNode.rotate(-HALF_PI, 0, 0) 处理坐标系转换
        // 这里返回原始格式，与 buildSkeleton 一致

        // 原始四元数 (qx, qy, qz, -qw)
        Quaternion q = new Quaternion(qx, qy, qz, -qw);
        q.normalizeLocal();

        return q;
    }

    /**
     * 将 axis-angle 转换为四元数（不进行坐标系转换）
     * 用于需要原始数据的场景
     *
     * @return 归一化的四元数
     */
    public Quaternion toQuaternionRaw() {
        float sinHalfAngle = FastMath.sqrt(Math.max(0f, 1.0f - cosHalfAngle * cosHalfAngle));

        float length = FastMath.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        if (length < 0.0001f) {
            return new Quaternion(0, 0, 0, 1);
        }

        float invLength = 1.0f / length;
        return new Quaternion(
            axisX * invLength * sinHalfAngle,
            axisY * invLength * sinHalfAngle,
            axisZ * invLength * sinHalfAngle,
            cosHalfAngle
        );
    }

    /**
     * 获取旋转角度（弧度）
     *
     * @return θ = 2 * acos(cos(θ/2))
     */
    public float getAngle() {
        // 限制 cosHalfAngle 范围 [-1, 1] 避免 NaN
        float c = Math.max(-1f, Math.min(1f, cosHalfAngle));
        return 2.0f * FastMath.acos(c);
    }

    /**
     * 获取旋转角度（度）
     *
     * @return θ (度)
     */
    public float getAngleDegrees() {
        return getAngle() * FastMath.RAD_TO_DEG;
    }

    @Override
    public String toString() {
        return String.format("TransRotation[frame=%d, axis=(%.4f, %.4f, %.4f), cos(θ/2)=%.4f, angle=%.2f°]",
            frame, axisX, axisY, axisZ, cosHalfAngle, getAngleDegrees());
    }

}