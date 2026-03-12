package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDamageQuickDelayed : PacketDamageQuick。
 */

@Data
public class PacketDamageQuickDelayed extends PacketDamageQuick {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int millisecondDelay;  // int iMillisecondDelay  size: 4 bytes
    private int clientTimeToExecute;  // int dwClientTimeToExecute  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        millisecondDelay = in.getInt();
        clientTimeToExecute = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(millisecondDelay);
        out.putInt(clientTimeToExecute);
    }
}
