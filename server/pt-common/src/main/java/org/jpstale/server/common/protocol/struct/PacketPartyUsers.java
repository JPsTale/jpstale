package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyUsers : Packet。
 */

@Data
public class PacketPartyUsers extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int[] temp = new int[8];  // DWORD dwTemp[8]
    private int usersCount;  // int iUsersCount
    private PartyUserData[] data = new PartyUserData[8];  // PartyUserData sData[8]

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        for (int i = 0; i < temp.length; i++) { temp[i] = in.getInt(); }
        usersCount = in.getInt();
        for (int i = 0; i < data.length; i++) { if (data[i] == null) data[i] = new PartyUserData(); data[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        for (int i = 0; i < temp.length; i++) { out.putInt(temp[i]); }
        out.putInt(usersCount);
        for (int i = 0; i < data.length; i++) { if (data[i] != null) data[i].writeTo(out); }
    }
}
