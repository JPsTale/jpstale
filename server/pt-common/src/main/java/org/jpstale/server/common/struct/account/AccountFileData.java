package org.jpstale.server.common.struct.account;

import lombok.Data;
import org.jpstale.server.common.struct.packets.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 account.h 中 struct AccountFileData（账号文件头 + 账号名 + 角色名列表，MAX_CHARACTERSPERACCOUNT=5，共 6 个角色名槽）。
 */
@Data
public final class AccountFileData {
    private String header;           // char szHeader[16]
    private String accountName;     // char szAccountName[32]
    private final String[] characterName = new String[6]; // char szCharacterName[6][32]

    public void readFrom(ByteBuffer in) {
        header = Packet.readCString(in, 16);
        accountName = Packet.readCString(in, 32);
        for (int i = 0; i < characterName.length; i++) {
            characterName[i] = Packet.readCString(in, 32);
        }
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, header, 16);
        Packet.writeCString(out, accountName, 32);
        for (String name : characterName) {
            Packet.writeCString(out, name, 32);
        }
    }
}
