package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCEasterEgg : Packet。
 */

@Data
public class PacketNPCEasterEgg extends Packet {

    private int action;  // int iAction
    private int[] itemId = new int[3];  // int iaItemID[3]
    private int[] head = new int[3];  // DWORD dwaHead[3]
    private int[] checkSum = new int[3];  // DWORD dwaCheckSum[3]

    @Override
    protected void readBody(ByteBuffer in) {
        action = in.getInt();
        for (int i = 0; i < itemId.length; i++) { itemId[i] = in.getInt(); }
        for (int i = 0; i < head.length; i++) { head[i] = in.getInt(); }
        for (int i = 0; i < checkSum.length; i++) { checkSum[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(action);
        for (int i = 0; i < itemId.length; i++) { out.putInt(itemId[i]); }
        for (int i = 0; i < head.length; i++) { out.putInt(head[i]); }
        for (int i = 0; i < checkSum.length; i++) { out.putInt(checkSum[i]); }
    }
}
