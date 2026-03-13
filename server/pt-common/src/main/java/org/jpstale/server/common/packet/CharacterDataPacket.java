package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct CharacterDataPacket（角色属性：力量、精神等）。
 */
@Data
public final class CharacterDataPacket {
    public static final int SIZE_OF = 40;

    private int strength;       // int iStrength
    private int spirit;        // int iSpirit
    private int talent;        // int iTalent
    private int agility;       // int iAgility
    private int health;       // int iHealth
    private int accuracy;     // int iAccuracy
    private int attackRating; // int iAttackRating
    private int minDamage;    // int iMinDamage
    private int maxDamage;    // int iMaxDamage
    private int attackSpeed;  // int iAttackSpeed

    public void readFrom(ByteBuffer in) {
        strength = in.getInt();
        spirit = in.getInt();
        talent = in.getInt();
        agility = in.getInt();
        health = in.getInt();
        accuracy = in.getInt();
        attackRating = in.getInt();
        minDamage = in.getInt();
        maxDamage = in.getInt();
        attackSpeed = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(strength);
        out.putInt(spirit);
        out.putInt(talent);
        out.putInt(agility);
        out.putInt(health);
        out.putInt(accuracy);
        out.putInt(attackRating);
        out.putInt(minDamage);
        out.putInt(maxDamage);
        out.putInt(attackSpeed);
    }
}
