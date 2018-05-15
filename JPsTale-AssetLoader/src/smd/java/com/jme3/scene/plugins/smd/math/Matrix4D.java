package com.jme3.scene.plugins.smd.math;

import java.io.IOException;

import org.pstale.assets.Flyweight;

import com.jme3.math.Matrix4f;
import com.jme3.util.LittleEndien;

/**
 * size = 64
 */
public class Matrix4D extends Flyweight {
    public int _11, _12, _13, _14;
    public int _21, _22, _23, _24;
    public int _31, _32, _33, _34;
    public int _41, _42, _43, _44;

    public Matrix4f value;
    public Matrix4f valueIT;
    
    public Matrix4D() {
        _11 = 1; _12 = 0; _13 = 0; _14 = 0;
        _21 = 0; _22 = 1; _23 = 0; _24 = 0;
        _31 = 0; _32 = 0; _33 = 1; _34 = 0;
        _41 = 0; _42 = 0; _43 = 0; _44 = 1;
        
        value = new Matrix4f();
    }

    /**
     * 这个矩阵的特征值是256，所有元素除以256后的行列式是1。
     * 
     * @param init
     */
    public void loadData(LittleEndien in) throws IOException {
        _11 = in.readInt();
        _12 = in.readInt();
        _13 = in.readInt();
        _14 = in.readInt();
        _21 = in.readInt();
        _22 = in.readInt();
        _23 = in.readInt();
        _24 = in.readInt();
        _31 = in.readInt();
        _32 = in.readInt();
        _33 = in.readInt();
        _34 = in.readInt();
        _41 = in.readInt();
        _42 = in.readInt();
        _43 = in.readInt();
        _44 = in.readInt();
        
        // 换算成jME3的矩阵
        value.set(_11, _12, _13, _14,
        		_21, _22, _23, _24,
        		_31, _32, _33, _34,
        		_41, _42, _43, _44);
        value.multLocal(1f / 256);
        
        valueIT = value.transpose().invertLocal();
    }
}