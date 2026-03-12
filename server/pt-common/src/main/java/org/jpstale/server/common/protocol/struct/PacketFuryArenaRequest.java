package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.FuryArenaState;


/**
 * 对应 packets.h 中 struct PacketFuryArenaRequest : Packet。
 */

@Data
public class PacketFuryArenaRequest extends Packet {

    private FuryArenaState state;  // EFuryArenaState eState
    private int eventId;  // int iEventID
    private int timeLeft;  // DWORD dwTimeLeft
    private int p1;  // int p1
    private int p2;  // int p2
    private int p3;  // int p3
    private int p4;  // int p4
    private int p5;  // int p5

    @Override
    protected void readBody(ByteBuffer in) {
        state = FuryArenaState.fromValue(in.getInt());
        eventId = in.getInt();
        timeLeft = in.getInt();
        p1 = in.getInt();
        p2 = in.getInt();
        p3 = in.getInt();
        p4 = in.getInt();
        p5 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(state.getValue());
        out.putInt(eventId);
        out.putInt(timeLeft);
        out.putInt(p1);
        out.putInt(p2);
        out.putInt(p3);
        out.putInt(p4);
        out.putInt(p5);
    }
}
