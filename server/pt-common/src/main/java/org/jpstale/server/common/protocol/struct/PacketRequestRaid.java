package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.RaidState;


/**
 * 对应 packets.h 中 struct PacketRequestRaid : Packet。
 */

@Data
public class PacketRequestRaid extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 44;

    private int id;  // int iID  size: 4 bytes
    private int targetId;  // int iTargetID  size: 4 bytes
    private RaidState state;  // ERaidState eState  size: 4 bytes
    private String characterName;  // char szCharacterName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        targetId = in.getInt();
        state = RaidState.fromValue(in.getInt());
        characterName = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(targetId);
        out.putInt(state.getValue());
        writeCString(out, characterName, 32);
    }
}
