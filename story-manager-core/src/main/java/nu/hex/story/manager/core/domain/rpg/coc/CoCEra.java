package nu.hex.story.manager.core.domain.rpg.coc;

/**
 * Created 2016-okt-24
 *
 * @author hl
 */
public enum CoCEra {
    E1890("Cthulhu by Gaslight"),
    E1920("Call of Cthulhu"),
    E1990("Cthulhu Now");
    private final String label;
    public static final CoCEra DEFAULT_ERA = E1920;

    private CoCEra(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Integer getYear() {
        return Integer.valueOf(name().replaceAll("\\D", ""));
    }
}
