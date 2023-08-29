package org.jpstale.assets;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jme3.util.LittleEndien;

public abstract class Flyweight {

    public final static int OBJ_FRAME_SEARCH_MAX = 32;

    /****
     * MATERIAL中MeshStage、UseState的取值
     */
    public final static int sMATS_SCRIPT_WIND = 1;
    public final static int sMATS_SCRIPT_WINDZ1 = 0x0020;
    public final static int sMATS_SCRIPT_WINDZ2 = 0x0040;
    public final static int sMATS_SCRIPT_WINDX1 = 0x0080;
    public final static int sMATS_SCRIPT_WINDX2 = 0x0100;
    public final static int sMATS_SCRIPT_WATER = 0x0200;
    public final static int sMATS_SCRIPT_NOTVIEW = 0x0400;
    public final static int sMATS_SCRIPT_PASS = 0x0800;
    public final static int sMATS_SCRIPT_NOTPASS = 0x1000;
    public final static int sMATS_SCRIPT_RENDLATTER = 0x2000;
    public final static int sMATS_SCRIPT_BLINK_COLOR = 0x4000;
    public final static int sMATS_SCRIPT_CHECK_ICE = 0x8000;
    public final static int sMATS_SCRIPT_ORG_WATER = 0x10000;

    /********
     * ModelInfo结构体、MotionInfo结构体的常量
     */
    public final static int MOTION_INFO_MAX = 512;
    public final static int MOTION_LIST_MAX = 32;
    public final static int MOTION_TOOL_MAX = 52;
    public final static int MOTION_SKIL_MAX = 8;

    public final static int NPC_MOTION_INFO_MAX = 30;
    public final static int TALK_MOTION_INFO_MAX = 30;

    public final static int TALK_MOTION_FILE_MAX = 2;
    public final static int TALK_MOTION_FILE = 0;
    public final static int FACIAL_MOTION_FILE = 1;

    /**
     * <pre>
     * #define	smLIGHT_TYPE_NIGHT		0x00001
     * #define	smLIGHT_TYPE_LENS		0x00002
     * #define	smLIGHT_TYPE_PULSE2	0x00004
     * #define	SMLIGHT_TYPE_OBJ		0x00008
     * #define	smLIGHT_TYPE_DYNAMIC	0x80000
     * </pre>
     */

    protected static Logger logger = LoggerFactory.getLogger(Flyweight.class);

    public abstract void loadData(LittleEndien in) throws IOException;

    /**
     * This reads bytes until it gets 0x00 and returns the corresponding string.
     */
    public String getString(LittleEndien in) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        char charIn = (char) in.read();
        while (charIn != 0x00) {
            stringBuffer.append(charIn);
            charIn = (char) in.read();
        }
        return stringBuffer.toString().trim();
    }

    /**
     * This reads bytes until it gets 0x00 and returns the corresponding string.
     */
    public String getString(LittleEndien in, int size) throws IOException {
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer();
        char charIn = (char) in.read();
        count++;
        while (charIn != 0x00 && count < size) {
            stringBuffer.append(charIn);
            charIn = (char) in.read();
            count++;
        }

        // skip useless byte
        if (count < size) {
            for (int i = count; i < size; i++) {
                in.read();
            }
        }
        return stringBuffer.toString().trim();
    }
}
