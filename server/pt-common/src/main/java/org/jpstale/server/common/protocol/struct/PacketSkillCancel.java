package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillCancel : Packet。
 */

@Data
public class PacketSkillCancel extends Packet {

    private int unk;  // int iUnk
    private int playId;  // int iPlayID
    private int unk2;  // int iUnk2
    private int unk3;  // int iUnk3

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        playId = in.getInt();
        unk2 = in.getInt();
        unk3 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(playId);
        out.putInt(unk2);
        out.putInt(unk3);
    }
}
