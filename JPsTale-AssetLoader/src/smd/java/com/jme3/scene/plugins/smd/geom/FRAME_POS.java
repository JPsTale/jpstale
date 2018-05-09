package com.jme3.scene.plugins.smd.geom;

import java.io.IOException;

import org.pstale.assets.Flyweight;

import com.jme3.util.LittleEndien;

/**
 * size = 16
 */
public class FRAME_POS extends Flyweight {
    int startFrame;
    int endFrame;
    int posNum;
    int posCnt;

    public void loadData(LittleEndien in) throws IOException {
        startFrame = in.readInt();
        endFrame = in.readInt();
        posNum = in.readInt();
        posCnt = in.readInt();
    }

	@Override
	public String toString() {
		return "FRAME_POS [startFrame=" + startFrame + ", endFrame=" + endFrame + ", posNum=" + posNum + ", posCnt="
				+ posCnt + "]";
	}
    
}