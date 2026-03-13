package org.jpstale.server.common.codec;

/**
 * 与 packets.h 中包头部、长度、编码相关的常量。
 * 对应 C++ 中 MAX_PKTSIZ、PKTHDR_ENCMAX、PKTLENBFRHDR 等 #define。
 */
public final class PacketConstants {

    private PacketConstants() {}

    /** 单包最大字节数 (0x2000 = 8192) */
    public static final int MAX_PKTSIZ = 0x2000;

    /** 包头编码字段最大值 */
    public static final int PKTHDR_ENCMAX = 0x10;

    /** 包头中“长度”字段之前的字节数（即长度字段占 4 字节前的固定头长度） */
    public static final int PKTLENBFRHDR = 4;

    // C++ 中 PKTLEN=WORD(2), PKTENC=BYTE(1), PKTCRC=BYTE(1), PKTHDR=DWORD(4)，Java 用 int 表示
    /** 包长度字段占用的字节数 (WORD = 2) */
    public static final int PKTLEN_SIZE = 2;
    /** 包编码字段占用的字节数 (BYTE = 1) */
    public static final int PKTENC_SIZE = 1;
    /** 包 CRC 字段占用的字节数 (BYTE = 1) */
    public static final int PKTCRC_SIZE = 1;
    /** 包头类型占用的字节数 (DWORD = 4) */
    public static final int PKTHDR_SIZE = 4;
}
