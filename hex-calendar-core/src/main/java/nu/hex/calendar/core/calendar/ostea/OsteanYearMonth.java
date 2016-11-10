package nu.hex.calendar.core.calendar.ostea;

import java.util.Objects;
import nu.hex.calendar.core.calendar.CalendarDate;
import nu.hex.calendar.core.calendar.format.CalendarDateTimeFormatter;
import nu.hex.calendar.core.calendar.CalendarYearMonth;

/**
 * Created 2016-nov-01
 *
 * @author hl
 */
public class OsteanYearMonth implements CalendarYearMonth {

    private final int year;
    private final int month;

    private OsteanYearMonth(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public static OsteanYearMonth of(int year, int month) {
        OsteanYear of = OsteanYear.of(year);
        OsteanMonth of1 = OsteanMonth.of(month);
        return new OsteanYearMonth(year, month);
    }

    public static OsteanYearMonth of(int year, OsteanMonth month) {
        Objects.requireNonNull(month, "month");
        return of(year, month.getValue());
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonthValue() {
        return month;
    }

    @Override
    public OsteanMonth getMonth() {
        return OsteanMonth.of(month);
    }

    @Override
    public boolean isLeapYear() {
        return OsteanYear.of(year).isLeap();
    }

    @Override
    public boolean isValidDay(int dayOfMonth) {
        return dayOfMonth >= 1 && dayOfMonth <= lengthOfMonth();
    }

    @Override
    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    @Override
    public int lengthOfYear() {
        return (isLeapYear() ? 366 : 365);
    }

    @Override
    public OsteanYearMonth plusYears(int yearsToAdd) {
        if (yearsToAdd == 0) {
            return this;
        }
        OsteanYear of = OsteanYear.of(year + yearsToAdd);
        return new OsteanYearMonth(of.getValue(), month);
    }

    @Override
    public OsteanYearMonth plusMonths(int monthsToAdd) {
        if (monthsToAdd == 0) {
            return this;
        }
        long monthCount = year * 12L + (month - 1);
        long calcMonths = monthCount + monthsToAdd;  // safe overflow
        int newYear = OsteanYear.of(new Long(Math.floorDiv(calcMonths, 12)).intValue()).getValue();
        int newMonth = (int) Math.floorMod(calcMonths, 12) + 1;
        return new OsteanYearMonth(newYear, newMonth);
    }

    @Override
    public OsteanYearMonth minusYears(int yearsToSubtract) {
        return plusYears(-yearsToSubtract);
    }

    @Override
    public OsteanYearMonth minusMonths(int monthsToSubtract) {
        return plusMonths(-monthsToSubtract);
    }

    @Override
    public String format(CalendarDateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        return formatter.format(this);
    }

    @Override
    public CalendarDate atDay(int dayOfMonth) {
        return OsteanDate.of(year, month, dayOfMonth);
    }

    @Override
    public CalendarDate atEndOfMonth() {
        return OsteanDate.of(year, month, lengthOfMonth());
    }

    @Override
    public int compareTo(CalendarYearMonth other) {
        int cmp = (year - other.getYear());
        if (cmp == 0) {
            cmp = (month - other.getMonthValue());
        }
        return cmp;

    }

}
