package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyPlayInfo : Packet。
 */

@Data
public class PacketPartyPlayInfo extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int temp;  // DWORD dwTemp
    private int usersCount;  // int iUsersCount
    private PartyUserInfo[] data = new PartyUserInfo[8];  // PartyUserInfo sData[8]

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        temp = in.getInt();
        usersCount = in.getInt();
        for (int i = 0; i < data.length; i++) { if (data[i] == null) data[i] = new PartyUserInfo(); data[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(temp);
        out.putInt(usersCount);
        for (int i = 0; i < data.length; i++) { if (data[i] != null) data[i].writeTo(out); }
    }
}
