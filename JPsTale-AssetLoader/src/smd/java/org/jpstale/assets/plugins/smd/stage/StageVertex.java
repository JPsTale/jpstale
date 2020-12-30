package org.jpstale.assets.plugins.smd.stage;

import java.io.IOException;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * size = 28
 */
public class StageVertex extends Flyweight {
    int sum;
    // smRENDVERTEX *lpRendVertex;
    public Vector3f v;
    public ColorRGBA vectorColor;

    public void loadData(LittleEndien in) throws IOException {
        sum = in.readInt();
        in.readInt();// *lpRendVertex

        // Vectex // 除以256才是实际的值
        float z = -in.readInt() / 256f;
        float y = in.readInt() / 256f;
        float x = -in.readInt() / 256f;

        v = new Vector3f(x, y, z);

        // VectorColor
        // 除以256才能用作ColorRGBA
        float r = in.readShort() / 256f;
        float g = in.readShort() / 256f;
        float b = in.readShort() / 256f;
        float a = in.readShort() / 256f;
        vectorColor = new ColorRGBA(r, g, b, a);
    }
}