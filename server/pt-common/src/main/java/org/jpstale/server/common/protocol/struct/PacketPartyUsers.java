package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyUsers : Packet。
 */

@Data
public class PacketPartyUsers extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1608;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private int[] temp = new int[8];  // DWORD dwTemp[8]  size: 32 bytes
    private int usersCount;  // int iUsersCount  size: 4 bytes
    private PartyUserData[] data = new PartyUserData[8];  // PartyUserData sData[8]  size: 1568 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
