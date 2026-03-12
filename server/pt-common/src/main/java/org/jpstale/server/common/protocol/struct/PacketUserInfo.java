package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserInfo : Packet。
 */

@Data
public class PacketUserInfo extends Packet {

    private String userId;  // char szUserID[32]
    private int charCount;  // int CharCount
    private int[] characterData = new int[6];  // _TRANS_CHAR_INFO sCharacterData[6]

    @Override
    protected void readBody(ByteBuffer in) {
        userId = readCString(in, 32);
        charCount = in.getInt();
        for (int i = 0; i < characterData.length; i++) { characterData[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, userId, 32);
        out.putInt(charCount);
        for (int i = 0; i < characterData.length; i++) { out.putInt(characterData[i]); }
    }
}
