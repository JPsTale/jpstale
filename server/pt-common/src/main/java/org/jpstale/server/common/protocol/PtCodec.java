package org.jpstale.server.common.protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 低层协议工具：长度读写、XOR 编解码。
 * 具体 Packet 的序列化/反序列化由各 Packet 子类的 readFrom/writeTo 或 toWireBytes 等实现。
 */
public final class PtCodec {

    public static final int MAX_PACKET_SIZE = 0x2000;

    private PtCodec() {}

    /** Decode XOR on buffer in place: first 2 bytes then from index 2 to length. */
    public static void xorDecode(byte[] buf, int length, byte xorKey) {
        if (length < 2) return;
        buf[0] ^= xorKey;
        buf[1] ^= xorKey;
        for (int i = 2; i < length; i++) {
            buf[i] ^= xorKey;
        }
    }

    /** Encode XOR for sending (same as decode, XOR is symmetric). */
    public static void xorEncode(byte[] buf, int length, byte xorKey) {
        xorDecode(buf, length, xorKey);
    }

    /** Read packet length from first 2 bytes (after XOR decode), little-endian. */
    public static short readLength(byte[] buf) {
        return ByteBuffer.wrap(buf, 0, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    /** Write packet length into first 2 bytes, little-endian. */
    public static void writeLength(byte[] buf, short length) {
        ByteBuffer.wrap(buf, 0, 2).order(ByteOrder.LITTLE_ENDIAN).putShort(length);
    }

    public static ByteBuffer buffer(int capacity) {
        return ByteBuffer.allocate(capacity).order(ByteOrder.LITTLE_ENDIAN);
    }
}
