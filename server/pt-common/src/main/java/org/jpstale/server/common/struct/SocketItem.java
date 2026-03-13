package org.jpstale.server.common.struct;

import lombok.Data;
import org.jpstale.server.common.enums.item.GemItem;
import org.jpstale.server.common.enums.item.GemType;
import org.jpstale.server.common.enums.item.SocketType;

import java.nio.ByteBuffer;

/** C++ struct SocketItem. Total size: 3 bytes */
@Data
public final class SocketItem {
    public static final int SIZE_OF = 3;

    private SocketType socketType;  // ESocketType eSocketType  size: 1 byte
    private GemType gemType;     // EGemType eGemType  size: 1 byte
    private GemItem gemItem;     // EGemItem eGemItem  size: 1 byte

    public void readFrom(ByteBuffer in) {
        socketType = SocketType.fromValue(in.get());
        gemType = GemType.fromValue(in.get());
        gemItem = GemItem.fromValue(in.get());
    }

    public void writeTo(ByteBuffer out) {
        out.put((byte) (socketType.getValue() & 0xFF));
        out.put((byte) (gemType.getValue() & 0xFF));
        out.put((byte) (gemItem.getValue() & 0xFF));
    }
}
