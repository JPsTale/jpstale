package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMixGuild : Packet。
 */

@Data
public class PacketMixGuild extends Packet {

    private int count;  // int iCount
    private ItemListMix[] mixList = new ItemListMix[70];  // ItemListMix sMixList[70]
    private ItemMixDesc[] mixDesc = new ItemMixDesc[70];  // ItemMixDesc sMixDesc[70]

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < mixList.length; i++) { if (mixList[i] == null) mixList[i] = new ItemListMix(); mixList[i].readFrom(in); }
        for (int i = 0; i < mixDesc.length; i++) { if (mixDesc[i] == null) mixDesc[i] = new ItemMixDesc(); mixDesc[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < mixList.length; i++) { if (mixList[i] != null) mixList[i].writeTo(out); }
        for (int i = 0; i < mixDesc.length; i++) { if (mixDesc[i] != null) mixDesc[i].writeTo(out); }
    }
}
