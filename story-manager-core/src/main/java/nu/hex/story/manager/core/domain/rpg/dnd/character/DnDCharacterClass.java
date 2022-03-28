package nu.hex.story.manager.core.domain.rpg.dnd.character;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public enum DnDCharacterClass {

    BARBARIAN("Barbarian"),
    BARD("Bard"),
    CLERIC("Cleric"),
    DRUID("Druid"),
    FIGHTER("Fighter"),
    MAGIC_USER("Magic-User"),
    MONK("Monk"),
    PALADIN("Paladin"),
    RANGER("Ranger"),
    ROGUE("Rogue"),
    SORCER("Sorcerer"),
    WARLOCK("Warlock");
    private final String label;

    private DnDCharacterClass(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
