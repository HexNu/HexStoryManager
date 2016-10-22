package nu.hex.story.manager.core.domain.rpg.character.dnd.impl;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
public enum DnDCharacterAlignment {

    CHAOTHIC_GOOD("Chaothic Good"),
    NEUTRAL_GOOD("Neutral Good"),
    LAWFUL_GOOD("Lawful Good"),
    CHAOTHIC_NEUTRAL("Chaothic Neutral"),
    NEUTRAL("Neutral"),
    LAWFUL_NEUTRAL("Lawful Neutral"),
    CHAOTHIC_EVIL("Chaothic Evil"),
    NEUTRAL_EVIL("Neutral Evil"),
    LAWFUL_EVIL("Lawful Evil");
    private final String label;

    private DnDCharacterAlignment(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
