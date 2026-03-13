package org.jpstale.server.common.codec;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 每连接的加解密状态，对应 C++ SocketData 中的：
 * - baKeySet / bKeySet
 * - EncryptPacket / DecryptPacket
 *
 * 所有操作基于字节数组，不依赖具体 Packet 子类。
 */
final class PtCryptoState {

    /** Packet 头大小：iLength(2) + iEncKeyIndex(1) + iEncrypted(1) + iHeader(4). */
    private static final int HEADER_SIZE = 8;

    /** 与 C++ NUM_ENCKEYS 一致。 */
    private static final int NUM_ENC_KEYS = 256;

    private final byte[] keySet = new byte[NUM_ENC_KEYS];
    private boolean keySetReady = false;

    /** C++ 中的 bNextKey（BYTE），用于选择使用哪一组密钥。*/
    private byte nextKey = 0;

    boolean isKeySetReady() {
        return keySetReady;
    }

    /**
     * 生成本端 keySet，并返回“原始 keySet 内容”（尚未做 obfuscate/XOR）的副本。
     * 用于 SendKeySet（对应 C++ 中对 baKeySet 的随机填充）。
     */
    byte[] generateKeySet() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < NUM_ENC_KEYS; i++) {
            keySet[i] = (byte) rnd.nextInt(0, 256);
        }
        keySetReady = true;
        nextKey = 0;
        return keySet.clone();
    }

    /**
     * 对 PacketKeySet 包体（256 字节 keySet）按 C++ SendKeySet 规则做 obfuscate。
     *
     * @param packetBytes 完整的 PacketKeySet（未 XOR、未加密），长度至少 8+256
     * @param obfuscatorByte C++ 里是 SERVER_PORT（SocketServer::GetPacketObfuscatorByte）
     */
    void encodeKeySetForWire(byte[] packetBytes, byte obfuscatorByte) {
        if (packetBytes.length < HEADER_SIZE + NUM_ENC_KEYS) {
            return;
        }

        byte encKeyIndex = packetBytes[2];
        byte encrypted   = packetBytes[3];

        // C++: bObfuscator += (s.iEncKeyIndex + s.iEncrypted);
        byte bObf = (byte) (obfuscatorByte + encKeyIndex + encrypted);

        int bodyOffset = HEADER_SIZE;
        for (int i = 0; i < NUM_ENC_KEYS; i++) {
            packetBytes[bodyOffset + i] = (byte) (keySet[i] ^ bObf);
        }
    }

    /**
     * 收到对端的 PacketKeySet 时还原 keySet，对应 C++ ReceiveKeySet。
     *
     * 注意：C++ 服务端是向客户端发 KeySet，客户端调用 ReceiveKeySet；
     * 如果在某些场景下让 Java 端扮演“客户端”，可以使用此方法。
     *
     * @param packetBytes XOR 已解码的完整 PacketKeySet
     * @param obfuscatorByte C++ 客户端为 (BYTE)iPort（remote 端口）
     */
    void receiveKeySet(byte[] packetBytes, byte obfuscatorByte) {
        if (packetBytes.length < HEADER_SIZE + NUM_ENC_KEYS) {
            return;
        }

        ByteBuffer buf = ByteBuffer.wrap(packetBytes).order(ByteOrder.LITTLE_ENDIAN);
        short length = buf.getShort(0);
        if (length < HEADER_SIZE + NUM_ENC_KEYS) {
            return;
        }

        byte encKeyIndex = packetBytes[2];
        byte encrypted   = packetBytes[3];

        byte bObf = (byte) (obfuscatorByte + encKeyIndex + encrypted);

        int bodyOffset = HEADER_SIZE;
        for (int i = 0; i < NUM_ENC_KEYS; i++) {
            keySet[i] = (byte) (packetBytes[bodyOffset + i] ^ bObf);
        }
        keySetReady = true;
        nextKey = 0;
    }

    /**
     * C++ EncryptPacket 的 Java 版：对 packetBytes[8..length) 原地加密，并设置 iEncKeyIndex / iEncrypted。
     *
     * @param packetBytes 未 XOR 的完整 Packet（含 8 字节头）
     */
    void encryptPacket(byte[] packetBytes) {
        if (!keySetReady || packetBytes.length < HEADER_SIZE) {
            return;
        }

        ByteBuffer buf = ByteBuffer.wrap(packetBytes).order(ByteOrder.LITTLE_ENDIAN);
        short length = buf.getShort(0);
        if (length < HEADER_SIZE || length > packetBytes.length) {
            return;
        }

        // C++: BYTE bObf = baKeySet[bNextKey];
        byte encIndex = nextKey;
        byte bObf = keySet[encIndex & 0xFF];

        packetBytes[2] = encIndex; // iEncKeyIndex
        packetBytes[3] = 1;        // iEncrypted

        bObf += encIndex;
        bObf += 1; // iEncrypted

        for (int i = HEADER_SIZE; i < length; i++) {
            int idx = i;
            byte ib0 = (byte) (idx & 0xFF);
            byte ib1 = (byte) ((idx >>> 8) & 0xFF);
            bObf += ib0;
            bObf += ib1;

            byte v = packetBytes[i];
            v ^= bObf;
            v ^= (byte) (encIndex + 0x2);
            packetBytes[i] = v;
        }

        // C++: bNextKey += p->iLength;
        int next = (encIndex & 0xFF) + (length & 0xFFFF);
        nextKey = (byte) next; // 按 BYTE 环绕
    }

    /**
     * C++ DecryptPacket 的 Java 版：若 iEncrypted != 0，则解密正文并清零标记位。
     * （用于 inbound 解密；outbound 加密时不需要调用）
     */
    void decryptIfNeeded(byte[] packetBytes) {
        if (!keySetReady || packetBytes.length < HEADER_SIZE) {
            return;
        }

        ByteBuffer buf = ByteBuffer.wrap(packetBytes).order(ByteOrder.LITTLE_ENDIAN);
        short length = buf.getShort(0);
        if (length < HEADER_SIZE || length > packetBytes.length) {
            return;
        }

        byte encKeyIndex = packetBytes[2];
        byte encrypted   = packetBytes[3];
        if (encrypted == 0) {
            return;
        }

        byte bObf = keySet[encKeyIndex & 0xFF];
        bObf += encKeyIndex;
        bObf += encrypted;

        for (int i = HEADER_SIZE; i < length; i++) {
            int idx = i;
            byte ib0 = (byte) (idx & 0xFF);
            byte ib1 = (byte) ((idx >>> 8) & 0xFF);
            bObf += ib0;
            bObf += ib1;

            byte v = packetBytes[i];
            v ^= (byte) (encKeyIndex + 0x2);
            v ^= bObf;
            packetBytes[i] = v;
        }

        packetBytes[2] = 0; // iEncKeyIndex
        packetBytes[3] = 0; // iEncrypted
    }
}

