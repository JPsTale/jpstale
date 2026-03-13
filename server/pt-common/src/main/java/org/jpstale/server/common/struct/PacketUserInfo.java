package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserInfo : Packet。
 */

@Data
public class PacketUserInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1476;

    private String userId;  // char szUserID[32]  size: 32 bytes
    private int charCount;  // int CharCount  size: 4 bytes
    private TransCharInfo[] characterData = new TransCharInfo[6];  // _TRANS_CHAR_INFO sCharacterData[6]  size: 1440 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userId = readCString(in, 32);
        charCount = in.getInt();
        for (int i = 0; i < characterData.length; i++) { if (characterData[i] == null) characterData[i] = new TransCharInfo(); characterData[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, userId, 32);
        out.putInt(charCount);
        for (int i = 0; i < characterData.length; i++) { if (characterData[i] != null) characterData[i].writeTo(out); }
    }
}
