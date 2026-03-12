package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserEffect : Packet。
 */

@Data
public class PacketUserEffect extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 35;

    private int uniqueUserId;  // int iUniqueUserID  size: 4 bytes
    private String title;  // char szTitle[25]  size: 25 bytes
    private short titleRarity;  // short sTitleRarity  size: 2 bytes
    private short playerAuraId;  // short sPlayerAuraId  size: 2 bytes
    private short dialogSkinId;  // short sDialogSkinId  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        uniqueUserId = in.getInt();
        title = readCString(in, 25);
        titleRarity = in.getShort();
        playerAuraId = in.getShort();
        dialogSkinId = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(uniqueUserId);
        writeCString(out, title, 25);
        out.putShort(titleRarity);
        out.putShort(playerAuraId);
        out.putShort(dialogSkinId);
    }
}
