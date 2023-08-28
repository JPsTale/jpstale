package org.jpstale.assets.plugins.script.character;

import java.io.IOException;
import java.util.Arrays;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;

/**
 * size = 4+64 = 68
 * 
 * @author yanmaoyuan
 *
 */
public class ModelGroup extends Flyweight {
    public int modelNameCnt;
    public String[] modelNames = new String[4];// 每个String长度为16

    @Override
    public void loadData(LittleEndien in) throws IOException {
        modelNameCnt = in.readInt();

        for (int i = 0; i < 4; i++) {
            modelNames[i] = getString(in, 16);
        }
    }

	@Override
	public String toString() {
		return "ModelGroup [modelNameCnt=" + modelNameCnt + ", modelNames=" + Arrays.toString(modelNames) + "]";
	}
}
