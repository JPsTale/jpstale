package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMixDescription : Packet。
 */

@Data
public class PacketMixDescription extends Packet {

    private String mixDescription;  // char szMixDescription[150]

    @Override
    protected void readBody(ByteBuffer in) {
        mixDescription = readCString(in, 150);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, mixDescription, 150);
    }
}
