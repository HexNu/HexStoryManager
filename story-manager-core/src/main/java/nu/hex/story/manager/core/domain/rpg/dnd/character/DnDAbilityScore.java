package nu.hex.story.manager.core.domain.rpg.dnd.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.AbilityScore;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "DnDAbilityScore")
public class DnDAbilityScore implements AbilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Ability ability;
    @Column
    private Integer abilityValue;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return getAbility() == null ? null : getAbility().getLabel();
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public Integer getValue() {
        return abilityValue;
    }

    @Override
    public void setValue(Integer value) {
        this.abilityValue = value;
    }

    public Integer getModifier() {
        return new Double(Math.floor((abilityValue - 10) / 2)).intValue();
    }

    public String getModifierString() {
        if (getModifier() > 0) {
            return "+" + getModifier();
        }
        return getModifier().toString();
    }

    @Override
    public String toString() {
        String result = abilityValue == null ? null : getAbility().name() + ": " + getValue();
        if (getModifier() == 0) {
            return result;
        }
        return result + " (" + getModifierString() + ")";
    }

    public enum Ability {

        CHA("Charisma"),
        CON("Constitution"),
        DEX("Dexterity"),
        INT("Intelligence"),
        STR("Strength"),
        WIS("Wisdom");
        private final String label;

        private Ability(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
