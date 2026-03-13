package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyPlayInfo : Packet。
 */

@Data
public class PacketPartyPlayInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 236;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private int temp;  // DWORD dwTemp  size: 4 bytes
    private int usersCount;  // int iUsersCount  size: 4 bytes
    private PartyUserInfo[] data = new PartyUserInfo[8];  // PartyUserInfo sData[8]  size: 224 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
