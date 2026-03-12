package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyMember，SIZE ≈ 63 bytes（脚本中配置）。
 *
 * 为了保证与 C 端网络布局一致，这里采用不透明定长字节数组承载，
 * 后续如需字段级别访问，可以参考 C 结构体定义拆分为具体字段。
 */
@Data
public final class PartyMember {

    public static final int SIZE_OF = 63;

    private final byte[] data = new byte[SIZE_OF];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        in.get(data);
    }

    public void writeTo(ByteBuffer out) {
        out.put(data);
    }
}

