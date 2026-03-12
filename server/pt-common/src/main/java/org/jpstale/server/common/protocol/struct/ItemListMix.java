package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct ItemListMix（合成类型 + 各元素数量）。
 */
@Data
public final class ItemListMix {
    public static final int SIZE_OF = 56;

    private int typeMix;   // int iTypeMix
    private int lucidy;   // int iLucidy
    private int sereneo;  // int iSereneo
    private int fadeo;    // int iFadeo
    private int sparky;   // int iSparky
    private int raident;  // int iRaident
    private int transparo; // int iTransparo
    private int murky;    // int iMurky
    private int devine;   // int iDevine
    private int celesto;  // int iCelesto
    private int mirage;   // int iMirage
    private int inferna;  // int iInferna
    private int enigma;   // int iEnigma
    private int bellum;   // int iBellum

    public void readFrom(ByteBuffer in) {
        typeMix = in.getInt();
        lucidy = in.getInt();
        sereneo = in.getInt();
        fadeo = in.getInt();
        sparky = in.getInt();
        raident = in.getInt();
        transparo = in.getInt();
        murky = in.getInt();
        devine = in.getInt();
        celesto = in.getInt();
        mirage = in.getInt();
        inferna = in.getInt();
        enigma = in.getInt();
        bellum = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(typeMix);
        out.putInt(lucidy);
        out.putInt(sereneo);
        out.putInt(fadeo);
        out.putInt(sparky);
        out.putInt(raident);
        out.putInt(transparo);
        out.putInt(murky);
        out.putInt(devine);
        out.putInt(celesto);
        out.putInt(mirage);
        out.putInt(inferna);
        out.putInt(enigma);
        out.putInt(bellum);
    }
}
