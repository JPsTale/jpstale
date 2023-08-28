package org.pstale.entity.chars;

import org.jpstale.assets.plugins.smd.geom.GeomObject;
import org.jpstale.assets.plugins.smd.geom.PAT3D;

public class CHARTOOL {
    GeomObject ObjBip;
    PAT3D PatTool;
    int dwItemCode;

    int SizeMax, SizeMin;

    int ColorBlink;
    short[] sColors = new short[4];
    int DispEffect;
    int BlinkScale;
    int EffectKind;

    int TexMixCode, TexScroll;
}
