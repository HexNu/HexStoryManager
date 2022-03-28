package nu.hex.story.manager.core.domain.rpg.coc;

import java.time.LocalDate;

/**
 * Created 2016-okt-24
 *
 * @author hl
 */
public enum CoCEra {
    E1890("Cthulhu by Gaslight", 1881, 1905),
    E1920("Call of Cthulhu", 1906, 1989),
    E1990("Cthulhu Now", 1990, 2020);
    private final String label;
    public static final CoCEra DEFAULT_ERA = E1920;
    private final Integer start;
    private final Integer end;

    private CoCEra(String label, Integer start, Integer end) {
        this.label = label;
        this.start = start;
        this.end = end;
    }

    public String getLabel() {
        return label;
    }

    public LocalDate getStart() {
        return LocalDate.parse(start + "-01-01");
    }

    public LocalDate getEnd() {
        return LocalDate.parse(end + "-12-31");
    }

    public Integer getYear() {
        return Integer.valueOf(name().replaceAll("\\D", ""));
    }
}
