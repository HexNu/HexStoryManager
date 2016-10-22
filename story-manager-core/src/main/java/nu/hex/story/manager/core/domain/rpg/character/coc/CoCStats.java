package nu.hex.story.manager.core.domain.rpg.character.coc;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.AbilityScore;
import nu.hex.story.manager.core.domain.rpg.character.Stats;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "CoCStats")
public class CoCStats implements Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore strength;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore dexterity;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore constitution;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore intelligence;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore wisdom;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore charisma;
    @Column
    private Integer hitPoints;
    @Column
    private Integer currentHitPoints;
    @Column
    private Integer temporaryHitPoints;

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
        return "DnD Stats";
    }

    public AbilityScore getStrength() {
        return strength;
    }

    public void setStrength(AbilityScore strength) {
        this.strength = strength;
    }

    public AbilityScore getDexterity() {
        return dexterity;
    }

    public void setDexterity(AbilityScore dexterity) {
        this.dexterity = dexterity;
    }

    public AbilityScore getConstitution() {
        return constitution;
    }

    public void setConstitution(AbilityScore constitution) {
        this.constitution = constitution;
    }

    public AbilityScore getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(AbilityScore intelligence) {
        this.intelligence = intelligence;
    }

    public AbilityScore getWisdom() {
        return wisdom;
    }

    public void setWisdom(AbilityScore wisdom) {
        this.wisdom = wisdom;
    }

    public AbilityScore getCharisma() {
        return charisma;
    }

    public void setCharisma(AbilityScore charisma) {
        this.charisma = charisma;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(Integer currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public Integer getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(Integer temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

}
