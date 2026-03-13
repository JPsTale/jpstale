package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSettingsData : Packet。
 */

@Data
public class PacketSettingsData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 21;

    private boolean inital;  // BOOL bInital  size: 4 bytes
    private boolean noTradeChat;  // BOOL bNoTradeChat  size: 4 bytes
    private boolean noPartyRequest;  // BOOL bNoPartyRequest  size: 4 bytes
    private boolean noTradeRequest;  // BOOL bNoTradeRequest  size: 4 bytes
    private boolean noWhisper;  // BOOL bNoWhisper  size: 4 bytes
    private byte weaponEnchantPerference;  // BYTE bWeaponEnchantPerference  size: 1 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
