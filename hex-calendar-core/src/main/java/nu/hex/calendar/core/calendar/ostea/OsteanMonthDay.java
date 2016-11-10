package nu.hex.calendar.core.calendar.ostea;

import java.time.MonthDay;
import java.util.Objects;
import nu.hex.calendar.core.calendar.format.CalendarDateTimeFormatter;
import nu.hex.calendar.core.calendar.CalendarMonth;
import nu.hex.calendar.core.calendar.CalendarMonthDay;

/**
 * Created 2016-nov-01
 *
 * @author hl
 */
public class OsteanMonthDay implements CalendarMonthDay {

    private final int month;
    private final int day;

    private OsteanMonthDay(int month, int dayOfMonth) {
        this.month = month;
        this.day = dayOfMonth;
    }

    public static OsteanMonthDay of(int month, int dayOfMonth) {
        return new OsteanMonthDay(month, dayOfMonth);
    }

    public static OsteanMonthDay of(OsteanMonth month, int dayOfMonth) {
        return of(month.getValue(), dayOfMonth);
    }

    public String format() {
        return format(CalendarDateTimeFormatter.OSTEAN_MONTH_DAY);
    }

    public String format(CalendarDateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        return formatter.format(this);
    }

    public static OsteanMonthDay parse(CharSequence text) {
        return parse(text, CalendarDateTimeFormatter.OSTEAN_MONTH_DAY);
    }

    public static OsteanMonthDay parse(CharSequence text, CalendarDateTimeFormatter formatter) {
        return (OsteanMonthDay) formatter.parse(text);
    }

    @Override
    public int getMonthValue() {
        return month;
    }

    @Override
    public CalendarMonth getMonth() {
        return OsteanMonth.of(month);
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public boolean isValidYear(int year) {
        return (getDay() == 29 && getMonthValue() == 2 && !OsteanYear.isLeap(year)) == false;
    }

    @Override
    public OsteanMonthDay withMonth(int month) {
        return withMonth(OsteanMonth.of(month));
    }

    @Override
    public OsteanMonthDay withMonth(CalendarMonth month) {
        Objects.requireNonNull(month, "month");
        if (month.getValue() == this.month) {
            return this;
        }
        int day = Math.min(this.day, month.maxLength());
        return of(month.getValue(), day);

    }

    @Override
    public OsteanMonthDay withDayOfMonth(int dayOfMonth) {
        if (dayOfMonth == this.day) {
            return this;
        }
        return of(month, dayOfMonth);
    }

    @Override
    public OsteanDate atYear(int year) {
        return OsteanDate.of(year, month, isValidYear(year) ? day : 28);
    }

    @Override
    public boolean isAfter(CalendarMonthDay other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBefore(CalendarMonthDay other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(CalendarMonthDay other) {
        int cmp = (month - other.getMonthValue());
        if (cmp == 0) {
            cmp = (day - other.getDay());
        }
        return cmp;
    }

    @Override
    public String toString() {
        return getDay() + " of " + getMonth().getDisplayName();
    }

    public static void main(String[] args) {
        OsteanMonthDay md = OsteanMonthDay.of(4, 14);
        System.out.println(MonthDay.of(4, 14));
        System.out.println(md.format());
    }
}
