package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLoginUser : Packet。
 */

@Data
public class PacketLoginUser extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 477;

    private int[] unk = new int[3];  // DWORD dwUnk[3]  size: 12 bytes
    private String userId;  // char szUserID[32]  size: 32 bytes
    private String password;  // char szPassword[65]  size: 65 bytes
    private String macAddr;  // char szMacAddr[20]  size: 20 bytes
    private String pcname;  // char szPCName[32]  size: 32 bytes
    private int serialHd;  // DWORD dwSerialHD  size: 4 bytes
    private String videoName;  // char szVideoName[256]  size: 256 bytes
    private String hardwareId;  // char szHardwareID[40]  size: 40 bytes
    private int widthScreen;  // UINT uWidthScreen  size: 4 bytes
    private int heightScreen;  // UINT uHeightScreen  size: 4 bytes
    private int systemOs;  // int iSystemOS  size: 4 bytes
    private int version;  // int iVersion  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < unk.length; i++) { unk[i] = in.getInt(); }
        userId = readCString(in, 32);
        password = readCString(in, 65);
        macAddr = readCString(in, 20);
        pcname = readCString(in, 32);
        serialHd = in.getInt();
        videoName = readCString(in, 256);
        hardwareId = readCString(in, 40);
        widthScreen = in.getInt();
        heightScreen = in.getInt();
        systemOs = in.getInt();
        version = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < unk.length; i++) { out.putInt(unk[i]); }
        writeCString(out, userId, 32);
        writeCString(out, password, 65);
        writeCString(out, macAddr, 20);
        writeCString(out, pcname, 32);
        out.putInt(serialHd);
        writeCString(out, videoName, 256);
        writeCString(out, hardwareId, 40);
        out.putInt(widthScreen);
        out.putInt(heightScreen);
        out.putInt(systemOs);
        out.putInt(version);
    }
}
