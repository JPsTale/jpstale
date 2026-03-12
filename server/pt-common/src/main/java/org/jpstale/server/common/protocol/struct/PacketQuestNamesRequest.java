package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestNamesRequest : Packet。
 * C 端无包体成员，仅包头；readBody/writeBody 无需读写。
 */
@Data
public class PacketQuestNamesRequest extends Packet {

    @Override
    protected void readBody(ByteBuffer in) {
        // C 端无包体成员，仅包头
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        // C 端无包体成员，仅包头
    }
}
