package org.jpstale.assets.plugins.smd.geom;

import java.io.IOException;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

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