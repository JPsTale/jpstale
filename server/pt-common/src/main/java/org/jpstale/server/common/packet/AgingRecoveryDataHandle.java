package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/Coin.h 中的 struct AgingRecoveryDataHandle，SIZE = 56 bytes.
 */
@Data
public final class AgingRecoveryDataHandle {

    public static final int SIZE_OF = 56;

    /** int iID; size: 4 bytes */
    private int id;

    /** SYSTEMTIME sDate; size: 16 bytes */
    private SystemTime date;

    /** char szItemName[32]; size: 32 bytes */
    private String itemName;

    /** int iAgeNumber; size: 4 bytes */
    private int ageNumber;

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        id = in.getInt();
        if (date == null) {
            date = new SystemTime();
        }
        date.readFrom(in);
        itemName = Packet.readCString(in, 32);
        ageNumber = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(id);
        if (date != null) {
            date.writeTo(out);
        } else {
            // 若为 null，写入全 0 以保持长度
            new SystemTime().writeTo(out);
        }
        Packet.writeCString(out, itemName, 32);
        out.putInt(ageNumber);
    }
}

