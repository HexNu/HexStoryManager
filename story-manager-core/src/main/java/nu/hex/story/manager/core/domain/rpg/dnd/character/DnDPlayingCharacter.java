package nu.hex.story.manager.core.domain.rpg.dnd.character;

import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import nu.hex.story.manager.core.domain.rpg.character.Stats;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@DiscriminatorValue(value = "DND")
public class DnDPlayingCharacter extends AbstractPlayingCharacter {

    @OneToOne(cascade = CascadeType.ALL, targetEntity = DnDStats.class)
    @JoinTable(name = "DnDPlayingCharacter_DnDStats")
    private Stats stats;
    @Enumerated(EnumType.STRING)
    private DnDCharacterRace characterRace;
    @Enumerated(EnumType.STRING)
    private DnDCharacterClass characterClass;
    @Enumerated(EnumType.STRING)
    private DnDCharacterAlignment characterAlignment;
    @Column
    private Integer experiencePoints;
    @Column
    private Integer height;
    @Column
    private Integer weight;
    @Column
    private String eyes;
    @Column
    private String skin;
    @Column
    private String hair;

    @Override
    public Stats getStats() {
        return stats;
    }

    @Override
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public DnDCharacterRace getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(DnDCharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    public DnDCharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(DnDCharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public DnDCharacterAlignment getCharacterAlignment() {
        return characterAlignment;
    }

    public void setCharacterAlignment(DnDCharacterAlignment characterAlignment) {
        this.characterAlignment = characterAlignment;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }
}
