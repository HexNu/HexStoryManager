package nu.hex.story.manager.core.util.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hl
 */
public class BusinessDayChecker {

    private final int year;
    private final List<LocalDate> bankHolidays;

    public BusinessDayChecker(int year) {
        this.year = year;
        bankHolidays = new BankHoliday(year).get();
    }

    public boolean isBusinessDay(LocalDate date) {
        if (date.getYear() != year) {
            throw new IllegalArgumentException("Date is out of range for year " + year);
        }
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return false;
        } else if (bankHolidays.contains(date)) {
            return false;
        }
        return true;
    }

    public LocalDate getFirstBusinessDay(LocalDate date) {
        if (isBusinessDay(date)) {
            return date;
        } else {
            return getFirstBusinessDay(date.plusDays(1l));
        }
    }
}
