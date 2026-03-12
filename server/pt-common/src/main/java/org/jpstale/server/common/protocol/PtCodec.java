package org.jpstale.server.common.protocol;

import org.jpstale.server.common.protocol.struct.Packet;
import org.jpstale.server.common.protocol.struct.PacketAccountLoginCode;
import org.jpstale.server.common.protocol.struct.PacketLoginUser;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 低层协议工具：长度读写、XOR 编解码、少量写包辅助。
 * 具体 Packet 的序列化/反序列化逻辑由各个 Packet 子类实现。
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

    /** 通过 PacketLoginUser 自身的 readFrom 实现解析。 */
    public static PacketLoginUser readPacketLoginUser(byte[] packet) {
        return PacketLoginUser.fromBytes(packet);
    }

    /** Write PacketAccountLoginCode to buffer and return byte array for wire (header + body). */
    public static byte[] writePacketAccountLoginCode(PacketAccountLoginCode p) {
        int len = Packet.HEADER_SIZE + 4 + 4 + 4 + 256;
        p.setLength((short) len);
        ByteBuffer buf = buffer(len);
        p.writeTo(buf);
        return buf.array();
    }
}
