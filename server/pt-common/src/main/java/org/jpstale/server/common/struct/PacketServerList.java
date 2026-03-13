package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketServerList : Packet。
 */

@Data
public class PacketServerList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 468;

    private Header header;  // Header sHeader  size: 36 bytes
    private Server[] servers = new Server[4];  // Server sServers[4]  size: 432 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (header == null) header = new Header(); header.readFrom(in);
        for (int i = 0; i < servers.length; i++) { if (servers[i] == null) servers[i] = new Server(); servers[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (header != null) header.writeTo(out);
        for (int i = 0; i < servers.length; i++) { if (servers[i] != null) servers[i].writeTo(out); }
    }
}
