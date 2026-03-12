package org.jpstale.server.common.protocol.struct;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Login request from client (align with PristonTale-EU shared/packets.h struct PacketLoginUser).
 * 密码是 SHA256 的 64 字符十六进制串，客户端对 UPPER(account):password 做哈希。
 *
 * 为了上层调用方便，这里把明显是字符串的字段都映射为 Java String，而不是 byte[]。
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PacketLoginUser extends Packet {

    private final int[] unk = new int[3];  // DWORD dwUnk[3]

    private String userId;       // char[32]
    private String password;     // char[65] SHA256 hex
    private String macAddr;      // char[20]
    private String pcName;       // char[32]
    private int serialHd;        // DWORD dwSerialHD
    private String videoName;    // char[256]
    private String hardwareId;   // char[40]
    private int widthScreen;     // UINT uWidthScreen
    private int heightScreen;    // UINT uHeightScreen
    private int systemOs;        // int iSystemOS
    private int version;         // int iVersion

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < unk.length; i++) {
            unk[i] = in.getInt();
        }
        userId = readCString(in, 32);
        password = readCString(in, 65);
        macAddr = readCString(in, 20);
        pcName = readCString(in, 32);
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
        for (int v : unk) {
            out.putInt(v);
        }
        writeCString(out, userId, 32);
        writeCString(out, password, 65);
        writeCString(out, macAddr, 20);
        writeCString(out, pcName, 32);
        out.putInt(serialHd);
        writeCString(out, videoName, 256);
        writeCString(out, hardwareId, 40);
        out.putInt(widthScreen);
        out.putInt(heightScreen);
        out.putInt(systemOs);
        out.putInt(version);
    }

    /** 从原始小端字节数组构造 PacketLoginUser（包括包头）。*/
    public static PacketLoginUser fromBytes(byte[] packet) {
        ByteBuffer buf = ByteBuffer.wrap(packet).order(ByteOrder.LITTLE_ENDIAN);
        PacketLoginUser p = new PacketLoginUser();
        p.readFrom(buf);
        return p;
    }
}
