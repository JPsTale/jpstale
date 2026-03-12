package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketServerList : Packet。
 */

@Data
public class PacketServerList extends Packet {

    private Header header;  // Header sHeader
    private Server[] servers = new Server[4];  // Server sServers[4]

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
