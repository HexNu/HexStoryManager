package nu.hex.calendar.core.calendar.ostea.format;

import nu.hex.calendar.core.calendar.CalendarYear;
import nu.hex.calendar.core.calendar.ostea.OsteanYear;

/**
 * Created 2016-nov-01
 *
 * @author hl
 */
public class OsteanYearFormatter extends AbstractDateTimeFormatter<CalendarYear> {

    @Override
    public String format(CalendarYear year) {
        return zeroFill(year.getValue(), 1);
    }

    @Override
    public CalendarYear parse(CharSequence text) {
        if (text.toString().matches("\\d*")) {
            return OsteanYear.of(Integer.valueOf(text.toString()));
        }
        String t = text.toString();
        String[] split = t.split(DATE_DELIMITER);
        return OsteanYear.of(Integer.valueOf(split[0]));
    }
}
