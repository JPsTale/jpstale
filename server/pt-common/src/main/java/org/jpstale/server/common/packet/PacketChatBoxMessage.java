package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.chat.ChatColor;


/**
 * 对应 packets.h 中 struct PacketChatBoxMessage : Packet。
 */

@Data
public class PacketChatBoxMessage extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 264;

    private ChatColor chatColor;  // EChatColor iChatColor  size: 4 bytes
    private int id;  // ID lID  size: 4 bytes
    private String chatBoxMessage;  // char szChatBoxMessage[256]  size: 256 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        chatColor = ChatColor.fromValue(in.getInt());
        id = in.getInt();
        chatBoxMessage = readCString(in, 256);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(chatColor.getValue());
        out.putInt(id);
        writeCString(out, chatBoxMessage, 256);
    }
}
