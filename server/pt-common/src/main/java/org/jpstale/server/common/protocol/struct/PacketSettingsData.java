package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSettingsData : Packet。
 */

@Data
public class PacketSettingsData extends Packet {

    private boolean inital;  // BOOL bInital
    private boolean noTradeChat;  // BOOL bNoTradeChat
    private boolean noPartyRequest;  // BOOL bNoPartyRequest
    private boolean noTradeRequest;  // BOOL bNoTradeRequest
    private boolean noWhisper;  // BOOL bNoWhisper
    private byte weaponEnchantPerference;  // BYTE bWeaponEnchantPerference

    @Override
    protected void readBody(ByteBuffer in) {
        inital = in.getInt() != 0;
        noTradeChat = in.getInt() != 0;
        noPartyRequest = in.getInt() != 0;
        noTradeRequest = in.getInt() != 0;
        noWhisper = in.getInt() != 0;
        weaponEnchantPerference = in.get();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(inital ? 1 : 0);
        out.putInt(noTradeChat ? 1 : 0);
        out.putInt(noPartyRequest ? 1 : 0);
        out.putInt(noTradeRequest ? 1 : 0);
        out.putInt(noWhisper ? 1 : 0);
        out.put(weaponEnchantPerference);
    }
}
