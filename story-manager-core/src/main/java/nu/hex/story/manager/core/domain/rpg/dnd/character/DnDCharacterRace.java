package nu.hex.story.manager.core.domain.rpg.dnd.character;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public enum DnDCharacterRace {

    DWARF("Dwarf"),
    ELF("Elf"),
    GNOME("Gnome"),
    HALF_ELF("Half Elf"),
    HALF_ORC("Halfling"),
    HALFLINF("Half Orc"),
    HUMAN("Human");
    private final String label;

    private DnDCharacterRace(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
