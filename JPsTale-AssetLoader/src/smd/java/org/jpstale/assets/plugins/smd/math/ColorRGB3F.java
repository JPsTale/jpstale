package org.jpstale.assets.plugins.smd.math;

import java.io.IOException;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * MaterialGroup中使用这个类来记录Diffuse size = 12。
 */
public class ColorRGB3F extends Flyweight {
    public float r, g, b;

    public void loadData(LittleEndien in) throws IOException {
        r = in.readFloat();
        g = in.readFloat();
        b = in.readFloat();
    }

    @Override
    public String toString() {
        return "ColorRGB3F [r=" + r + ", g=" + g + ", b=" + b + "]";
    }
    
}