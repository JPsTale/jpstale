package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemLinkChat : Packet。
 */

@Data
public class PacketItemLinkChat extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 296;

    private String characterName;  // char szCharacterName[32]  size: 32 bytes
    private String message;  // char szMessage[256]  size: 256 bytes
    private int chatColor;  // int eChatColor  size: 4 bytes
    private int cItemData;  // ItemData cItemData  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        characterName = readCString(in, 32);
        message = readCString(in, 256);
        chatColor = in.getInt();
        cItemData = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, characterName, 32);
        writeCString(out, message, 256);
        out.putInt(chatColor);
        out.putInt(cItemData);
    }
}
