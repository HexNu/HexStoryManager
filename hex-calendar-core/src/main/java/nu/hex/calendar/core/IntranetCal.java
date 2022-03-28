package nu.hex.calendar.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import nu.hex.calendar.core.date.util.BusinessDay;
import nu.hex.calendar.core.date.util.DateUtilConstants;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class IntranetCal {

    public static void main(String[] args) throws IOException {
        List<String> queries = new ArrayList<>();
        LocalDate d = LocalDate.parse("2019-12-31", DateTimeFormatter.ISO_DATE);
        while ((d = d.plusDays(1)).isBefore(LocalDate.parse("2026-01-01", DateTimeFormatter.ISO_DATE))) {
            String weekDay = d.getDayOfWeek().getDisplayName(TextStyle.FULL, DateUtilConstants.LOCALE);
            weekDay = weekDay.substring(0, 1).toUpperCase() + weekDay.substring(1);
            int redLetterDay = new BusinessDay().isBusinessDay(d) ? 0 : 1;
            String result = "INSERT INTO adm_kalender SET datum = '" + d.format(DateTimeFormatter.ISO_DATE)
                    + "', veckodag = '" + weekDay
                    + "', helg = " + redLetterDay + ";";
            queries.add(result);
        }
        File resultFile = new File("/home/hl/Skrivbord/adm_kalender.sql");
        Files.write(resultFile.toPath(), queries);
    }
}
