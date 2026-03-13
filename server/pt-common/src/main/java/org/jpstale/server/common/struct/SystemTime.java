package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 Windows SYSTEMTIME：8 个 WORD（年/月/星期/日/时/分/秒/毫秒）。
 */
@Data
public final class SystemTime {
    public static final int SIZE_OF = 16;

    private short year;         // WORD wYear
    private short month;        // WORD wMonth
    private short dayOfWeek;    // WORD wDayOfWeek
    private short day;          // WORD wDay
    private short hour;         // WORD wHour
    private short minute;       // WORD wMinute
    private short second;       // WORD wSecond
    private short milliseconds; // WORD wMilliseconds

    public void readFrom(ByteBuffer in) {
        year = in.getShort();
        month = in.getShort();
        dayOfWeek = in.getShort();
        day = in.getShort();
        hour = in.getShort();
        minute = in.getShort();
        second = in.getShort();
        milliseconds = in.getShort();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(year);
        out.putShort(month);
        out.putShort(dayOfWeek);
        out.putShort(day);
        out.putShort(hour);
        out.putShort(minute);
        out.putShort(second);
        out.putShort(milliseconds);
    }
}
