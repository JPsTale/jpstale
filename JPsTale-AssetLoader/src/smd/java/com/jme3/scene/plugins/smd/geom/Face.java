package com.jme3.scene.plugins.smd.geom;

import java.io.IOException;
import java.util.Arrays;

import org.pstale.assets.Flyweight;

import com.jme3.math.Vector2f;
import com.jme3.scene.plugins.smd.material.TEXLINK;
import com.jme3.util.LittleEndien;

/**
 * size = 36
 */
public class Face extends Flyweight {
    public int[] v = new int[4];// a,b,c,Matrial
    public Vector2f[] t = new Vector2f[3];
    public int lpTexLink;
    public TEXLINK TexLink;

    @Override
    public void loadData(LittleEndien in) throws IOException {
        for (int i = 0; i < 4; i++) {
            v[i] = in.readUnsignedShort();
        }

        for (int i = 0; i < 3; i++) {
            float u = in.readFloat();
            float v = in.readFloat();
            t[i] = new Vector2f(u, v);
        }

        lpTexLink = in.readInt();
    }

	@Override
	public String toString() {
		return "Face [v=" + Arrays.toString(v) + ", t=" + Arrays.toString(t) + ", lpTexLink=" + lpTexLink + ", TexLink="
				+ TexLink + "]";
	}
    
}