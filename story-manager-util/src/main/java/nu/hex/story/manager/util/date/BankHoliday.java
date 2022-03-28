package nu.hex.story.manager.util.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hl
 *
 * Baserad på SFS 1989:253
 */
public class BankHoliday {

    private static final List<String> FIXED_DATES = new ArrayList<>();
    private static final List<String> FIRST_SATURDAY_DATES = new ArrayList<>();
    private final int year;

    public BankHoliday() {
        this(LocalDate.now().getYear());
    }

    public BankHoliday(int year) {
        this.year = year;
        FIXED_DATES.add("01-01");
        FIXED_DATES.add("01-06");
        FIXED_DATES.add("05-01");
        FIXED_DATES.add("06-06");
        FIXED_DATES.add("12-24");
        FIXED_DATES.add("12-25");
        FIXED_DATES.add("12-26");
        FIRST_SATURDAY_DATES.add("06-20");
        FIRST_SATURDAY_DATES.add("10-31");
    }

    public List<LocalDate> get() {
        List<LocalDate> result = new ArrayList<>();
        FIXED_DATES.stream().forEach((date) -> {
            result.add(LocalDate.parse(year + "-" + date, DateTimeFormatter.ISO_DATE));
        });
        FIRST_SATURDAY_DATES.stream().map((monthDay) -> createDayFromMontDay(monthDay)).forEach((date) -> {
            LocalDate firstSaturday = getFirstSaturday(date);
            result.add(firstSaturday);
            if (firstSaturday.getMonth().equals(Month.JUNE)) {
                result.add(firstSaturday.minusDays(1l));
            }
        });
        result.addAll(getEasterDates());
        Collections.sort(result);
        return result;
    }

    private List<LocalDate> getEasterDates() {
        List<LocalDate> easterDates = new ArrayList<>();
        LocalDate sunday = new GaussEasterCalculator(year).getEasterSunday();
        easterDates.add(sunday.minusDays(2l));
        easterDates.add(sunday);
        easterDates.add(sunday.plusDays(1l));
        easterDates.add(sunday.plusDays(4l).plusWeeks(5));
        easterDates.add(sunday.plusWeeks(7l));
        return easterDates;
    }

    private LocalDate createDayFromMontDay(String monthDay) {
        String month = monthDay.split("-")[0];
        String day = monthDay.split("-")[1];
        return LocalDate.parse(year + "-" + month + "-" + day);
    }

    /**
     * Returns the LocalDate for the first Saturday as from the provided date.
     * 
     * @param date
     * @return 
     */
    private LocalDate getFirstSaturday(LocalDate date) {
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return date;
        } else {
            return getFirstSaturday(date.plusDays(1l));
        }
    }
}
