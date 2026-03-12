package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct ItemMixDesc（描述字符串）。
 */
@Data
public final class ItemMixDesc {
    private String description; // char Description[32]

    public void readFrom(ByteBuffer in) {
        description = Packet.readCString(in, 32);
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, description, 32);
    }
}
