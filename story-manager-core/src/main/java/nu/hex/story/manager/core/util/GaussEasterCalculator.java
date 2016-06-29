package nu.hex.story.manager.core.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hl
 */
class GaussEasterCalculator {

    private final int year;

    public GaussEasterCalculator(int year) {
        this.year = year;
    }

    public LocalDate getEasterSunday() {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = Math.floorDiv(year, 100);
        int p = Math.floorDiv((13 + 8 * k), 25);
        int q = Math.floorDiv(k, 4);
        int M = (15 - p + k - q) % 50;
        int N = (4 + k - q) % 7;
        int d = (19 * a + M) % 30;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int f = 22 + d + e;
        LocalDate result = LocalDate.parse(year + "-03-01").plusDays(Long.valueOf(f - 1));
        if (result.getMonth().equals(Month.APRIL)
                && (result.getDayOfMonth() == 26 && d == 29 && e == 6
                || result.getDayOfMonth() == 25 && d == 28 && e == 6 && a > 10)) {
            result = result.minusDays(7);
        }
        return result;
    }
}
