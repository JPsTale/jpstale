package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.FuryArenaState;


/**
 * 对应 packets.h 中 struct PacketFuryArenaRequest : Packet。
 */

@Data
public class PacketFuryArenaRequest extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private FuryArenaState state;  // EFuryArenaState eState  size: 4 bytes
    private int eventId;  // int iEventID  size: 4 bytes
    private int timeLeft;  // DWORD dwTimeLeft  size: 4 bytes
    private int p1;  // int p1  size: 4 bytes
    private int p2;  // int p2  size: 4 bytes
    private int p3;  // int p3  size: 4 bytes
    private int p4;  // int p4  size: 4 bytes
    private int p5;  // int p5  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
