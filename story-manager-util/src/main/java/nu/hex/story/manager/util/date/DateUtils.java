package nu.hex.story.manager.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hl
 */
public class DateUtils {

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
        LocalDate dateOfBirth = LocalDate.parse("2000-06-11", DateTimeFormatter.ISO_DATE);
        LocalDate currentDate;
        currentDate = LocalDate.parse("2015-03-17", DateTimeFormatter.ISO_DATE);
        System.out.println(currentDate.plusDays(45));
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-05-01", DateTimeFormatter.ISO_DATE);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-06-11", DateTimeFormatter.ISO_DATE);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
        currentDate = LocalDate.parse("2015-07-11", DateTimeFormatter.ISO_DATE);
        System.out.println(new DateUtils(dateOfBirth).getAgeAtDate(currentDate));
    }

}
