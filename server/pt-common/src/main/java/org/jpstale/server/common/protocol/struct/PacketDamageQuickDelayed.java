package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDamageQuickDelayed : PacketDamageQuick。
 */

@Data
public class PacketDamageQuickDelayed extends PacketDamageQuick {

    private int millisecondDelay;  // int iMillisecondDelay
    private int clientTimeToExecute;  // int dwClientTimeToExecute

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
