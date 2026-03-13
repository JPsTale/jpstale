package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketChatMessage : Packet。
 */

@Data
public class PacketChatMessage extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 264;

    private int ip;  // DWORD dwIP  size: 4 bytes
    private int objectSerial;  // DWORD dwObjectSerial  size: 4 bytes
    private String message;  // char szMessage[256]  size: 256 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        ip = in.getInt();
        objectSerial = in.getInt();
        message = readCString(in, 256);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(ip);
        out.putInt(objectSerial);
        writeCString(out, message, 256);
    }
}
