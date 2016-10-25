package nu.hex.story.manager.rpg.coc;

/**
 * Created 2016-okt-24
 *
 * @author hl
 */
public enum CoCEra {

    ERA_1890("Cthulhu by Gaslight"),
    ERA_1920("Call of Cthulhu"),
    ERA_1990("Cthulhu Now");
    private final String label;

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
