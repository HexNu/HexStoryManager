package nu.hex.story.manager.core.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hl
 */
public class DateUtils {

    public static final DateTimeFormatter STANDARD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDate date;

    public DateUtils(LocalDate date) {
        this.date = date;
    }

    public Integer getAgeAtDate(LocalDate dateToCheck) {
        if (date == null || dateToCheck == null) {
            return null;
        }
        int year = dateToCheck.minusYears(date.getYear()).getYear();
        if (dateToCheck.minusYears(year).isBefore(date)) {
            return year - 1;
        } else {
            return year;
        }
    }

    public static void main(String[] args) {
        LocalDate dateOfBirth = LocalDate.parse("2000-06-11", STANDARD_FORMATTER);
        LocalDate currentDate;
        currentDate = LocalDate.parse("2015-03-17", STANDARD_FORMATTER);
        System.out.println(currentDate.plusDays(45));
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-05-01", STANDARD_FORMATTER);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-06-11", STANDARD_FORMATTER);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-07-11", STANDARD_FORMATTER);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
    }

}
