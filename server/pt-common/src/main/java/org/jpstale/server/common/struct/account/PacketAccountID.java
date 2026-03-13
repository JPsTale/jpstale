package org.jpstale.server.common.struct.account;

import lombok.Data;
import org.jpstale.server.common.struct.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 account.h 中 struct PacketAccountID : Packet。
 */
@Data
public class PacketAccountID extends Packet {
    private long accountId;  // ID lAccountID

    @Override
    protected void readBody(ByteBuffer in) {
        accountId = in.getInt() & 0xFFFFFFFFL;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt((int) accountId);
    }
}
