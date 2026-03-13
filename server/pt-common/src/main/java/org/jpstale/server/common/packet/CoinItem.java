package org.jpstale.server.common.packet;

import lombok.Data;
import org.jpstale.server.common.enums.packets.AllowedClassSpecFlag;

import java.nio.ByteBuffer;

/**
 * desc: 
 * 
 * @author yanmaoyuan
 */
@Data
public class CoinItem {

    public static final int SIZE_OF = 256;

    private int id;// int iID; size: 4 bytes
    private String name;// char szName[32]; size: 32 bytes
    private String description;// char szDescription[128]; size: 128 bytes
    private String code;// char szCode[8]; size: 8 bytes
    private String image;// char szImage[64]; size: 64 bytes
    private int value;// int iValue; size: 4 bytes
    private int discount;// int iDiscount; size: 4 bytes
    private int bulk;// int iBulk; size: 4 bytes
    private int maxBulk;// int iMaxBulk; size: 4 bytes
    private AllowedClassSpecFlag allowedSpec;// EAllowedClassSpecFlag eAllowedSpec; size: 4 bytes

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        id = in.getInt();
        name = Packet.readCString(in, 32);
        description = Packet.readCString(in, 128);
        code = Packet.readCString(in, 8);
        image = Packet.readCString(in, 64);
        value = in.getInt();
        discount = in.getInt();
        bulk = in.getInt();
        maxBulk = in.getInt();
        allowedSpec = AllowedClassSpecFlag.fromValue(in.get());
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(id);
        Packet.writeCString(out, name, 32);
        Packet.writeCString(out, description, 128);
        Packet.writeCString(out, code, 8);
        Packet.writeCString(out, image, 64);
        out.putInt(value);
        out.putInt(discount);
        out.putInt(bulk);
        out.putInt(maxBulk);
        out.putInt(allowedSpec.getValue());
    }
}
