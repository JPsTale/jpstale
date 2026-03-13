package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * Base packet header (align with PristonTale-EU shared/packets.h struct Packet).
 * Layout: iLength(2) + iEncKeyIndex(1) + iEncrypted(1) + iHeader(4) = 8 bytes, little-endian.
 *
 * 子类负责实现包体的序列化 / 反序列化逻辑。
 */
@Data
public abstract class Packet {
    /** Packet length in bytes (including this header). */
    private short length;        // WORD iLength
    private byte encKeyIndex;     // BYTE iEncKeyIndex
    private byte encrypted;      // BYTE iEncrypted
    private int pktHeader;       // int iHeader（包类型标识，与子类包体中的 Header 结构体区分）

    /** 包头字节数。 */
    public static final int SIZE_OF = 8;

    /** 读取包头（调用方需保证 ByteBuffer 为 little-endian）. */
    protected void readHeader(ByteBuffer in) {
        this.length = in.getShort();
        this.encKeyIndex = in.get();
        this.encrypted = in.get();
        this.pktHeader = in.getInt();
    }

    /** 写入包头（调用方需保证 ByteBuffer 为 little-endian）. */
    protected void writeHeader(ByteBuffer out) {
        out.putShort(this.length);
        out.put(this.encKeyIndex);
        out.put(this.encrypted);
        out.putInt(this.pktHeader);
    }

    /** 由子类实现：读取包体字段。 */
    protected abstract void readBody(ByteBuffer in);

    /** 由子类实现：写入包体字段。 */
    protected abstract void writeBody(ByteBuffer out);

    /** 整个包字节数（头+体）。子类覆盖为 return super.sizeOf() + SIZE_OF。 */
    public int sizeOf() {
        return SIZE_OF;
    }

    /** 将当前包序列化为完整二进制（头+体），小端序。会先 setLength 再写入。 */
    public final byte[] toWireBytes() {
        int len = sizeOf();
        setLength((short) len);
        ByteBuffer buf = ByteBuffer.allocate(len).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(buf);
        return buf.array();
    }

    /** 从 ByteBuffer 读取整个包（头 + 体）。*/
    public final void readFrom(ByteBuffer in) {
        readHeader(in);
        readBody(in);
    }

    /** 写入整个包（头 + 体）到 ByteBuffer。*/
    public final void writeTo(ByteBuffer out) {
        writeHeader(out);
        writeBody(out);
    }

    /** 工具方法：创建一个小端 ByteBuffer。*/
    protected static ByteBuffer leBuffer(int capacity) {
        return ByteBuffer.allocate(capacity).order(ByteOrder.LITTLE_ENDIAN);
    }

    /** 从 ByteBuffer 读取定长 C-string（遇 NUL 截断），UTF-8，子类序列化时使用。*/
    public static String readCString(ByteBuffer in, int maxLen) {
        byte[] buf = new byte[maxLen];
        in.get(buf);
        int end = 0;
        while (end < maxLen && buf[end] != 0) end++;
        return new String(buf, 0, end, StandardCharsets.UTF_8).trim();
    }

    /** 向 ByteBuffer 写入定长 C-string（不足补 0），UTF-8，子类序列化时使用。*/
    public static void writeCString(ByteBuffer out, String s, int maxLen) {
        byte[] dest = new byte[maxLen];
        if (s != null) {
            byte[] src = s.getBytes(StandardCharsets.UTF_8);
            int copy = Math.min(src.length, maxLen - 1);
            System.arraycopy(src, 0, dest, 0, copy);
            if (copy < maxLen) {
                dest[copy] = 0;
            }
        }
        out.put(dest);
    }
}
