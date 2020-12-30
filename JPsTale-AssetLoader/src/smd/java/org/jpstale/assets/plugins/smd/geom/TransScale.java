package org.jpstale.assets.plugins.smd.geom;

import java.io.IOException;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * size = 16
 */
public class TransScale extends Flyweight {
    public int frame;
    public float x, y, z;

    public void loadData(LittleEndien in) throws IOException {
        frame = in.readInt();
        x = in.readInt() / 256f;
        y = in.readInt() / 256f;
        z = in.readInt() / 256f;
    }

	@Override
	public String toString() {
		return "TransScale [frame=" + frame + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}