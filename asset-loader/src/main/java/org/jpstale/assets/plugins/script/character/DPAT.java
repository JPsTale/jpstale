package org.jpstale.assets.plugins.script.character;

import java.io.IOException;

import com.jme3.util.LittleEndien;

import org.jpstale.assets.Flyweight;
import org.jpstale.assets.plugins.smd.geom.AnimateModel;
import org.jpstale.assets.plugins.smd.geom.PAT3D;

public class DPAT extends Flyweight {

    DPAT lpTalkLink;

    DPAT smDinaLink;
    PAT3D Pat;

    String patName;// [64]
    int UseCount;
    int dwSpeedFindSum;

    AnimateModel lpModelInfo;

    int LastUsedTime;

    @Override
    public void loadData(LittleEndien in) throws IOException {
        in.readInt();// lpTalkLink
        in.readInt();// smDinaLink
        in.readInt();// Pat

        patName = getString(in, 64);
        UseCount = in.readInt();
        dwSpeedFindSum = in.readInt();

        in.readInt();// lpModelInfo

        LastUsedTime = in.readInt();
    }
}
