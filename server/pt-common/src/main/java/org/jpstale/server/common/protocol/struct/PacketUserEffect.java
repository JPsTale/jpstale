package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserEffect : Packet。
 */

@Data
public class PacketUserEffect extends Packet {

    private int uniqueUserId;  // int iUniqueUserID
    private String title;  // char szTitle[25]
    private short titleRarity;  // short sTitleRarity
    private short playerAuraId;  // short sPlayerAuraId
    private short dialogSkinId;  // short sDialogSkinId

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
