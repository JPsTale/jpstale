package org.jpstale.server.common.codec;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 低层协议工具：长度读写、XOR 编解码。
 * 具体 Packet 的序列化/反序列化由各 Packet 子类的 readFrom/writeTo 或 toWireBytes 等实现。
 */
public final class PtCodec {

    public static final int MAX_PACKET_SIZE = 0x2000;

    private PtCodec() {}

    public static void xor(byte[] buf, int length, byte xorKey) {
        if (length < 2) return;
        for (int i = 0; i < length; i++) {
            buf[i] ^= xorKey;
        }
    }

    /** Read packet length from first 2 bytes (after XOR decode), little-endian. */
    public static short readLength(byte[] buf) {
        return ByteBuffer.wrap(buf, 0, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }
}
