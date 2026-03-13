package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/** C++ struct ItemFixData (when ITEMFIXES). Total size: 58 bytes */
@Data
public final class ItemFixData {
    public static final int SIZE_OF = 58;

    private short id;                   // short iID  size: 2 bytes
    private byte[] name = new byte[12];  // char sName[12]  size: 12 bytes
    private short atkPow;               // short iATKPow  size: 2 bytes
    private short atkRating;             // short iATKRating  size: 2 bytes
    private short range;                 // short iRange  size: 2 bytes
    private float block;                // float fBlock  size: 4 bytes
    private float absorb;                // float fAbsorb  size: 4 bytes
    private short defense;               // short iDefense  size: 2 bytes
    private float regenerationHP;       // float fRegenerationHP  size: 4 bytes
    private float regenerationMP;       // float fRegenerationMP  size: 4 bytes
    private short addHP;                // short iAddHP  size: 2 bytes
    private short addMP;                // short iAddMP  size: 2 bytes
    private float runSpeed;             // float fRunSpeed  size: 4 bytes
    private float critical;             // float fCritical  size: 4 bytes
    private short organic;              // short iOrganic  size: 2 bytes
    private short fire;                 // short iFire  size: 2 bytes
    private short frost;                 // short iFrost  size: 2 bytes
    private short lightning;            // short iLightning  size: 2 bytes
    private short poison;               // short iPoison  size: 2 bytes

    public void readFrom(ByteBuffer in) {
        id = in.getShort();
        in.get(name);
        atkPow = in.getShort();
        atkRating = in.getShort();
        range = in.getShort();
        block = in.getFloat();
        absorb = in.getFloat();
        defense = in.getShort();
        regenerationHP = in.getFloat();
        regenerationMP = in.getFloat();
        addHP = in.getShort();
        addMP = in.getShort();
        runSpeed = in.getFloat();
        critical = in.getFloat();
        organic = in.getShort();
        fire = in.getShort();
        frost = in.getShort();
        lightning = in.getShort();
        poison = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(id);
        out.put(name);
        out.putShort(atkPow);
        out.putShort(atkRating);
        out.putShort(range);
        out.putFloat(block);
        out.putFloat(absorb);
        out.putShort(defense);
        out.putFloat(regenerationHP);
        out.putFloat(regenerationMP);
        out.putShort(addHP);
        out.putShort(addMP);
        out.putFloat(runSpeed);
        out.putFloat(critical);
        out.putShort(organic);
        out.putShort(fire);
        out.putShort(frost);
        out.putShort(lightning);
        out.putShort(poison);
    }
}
