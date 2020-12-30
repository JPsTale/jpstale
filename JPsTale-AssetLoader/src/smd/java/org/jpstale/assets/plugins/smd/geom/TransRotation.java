package org.jpstale.assets.plugins.smd.geom;

import java.io.IOException;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * size = 20
 * 
 */
public class TransRotation extends Flyweight {
    public int frame;
    public float x, y, z, w;

    public void loadData(LittleEndien in) throws IOException {
        frame = in.readInt();
        x = in.readFloat();
        y = in.readFloat();
        z = in.readFloat();
        w = in.readFloat();
    }

	@Override
	public String toString() {
		return "TransRotation [frame=" + frame + ", x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + "]";
	}
    
}