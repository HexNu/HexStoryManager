package nu.hex.story.manager.core.domain.rpg.coc.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.Skill;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
@Entity
@Table(name = "CoCSkill")
public class CoCSkill implements Skill, Comparable<CoCSkill> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer startYear;
    @Column
    private Integer endYear;
    @Column(length = 16 * 1024)
    private String description;
    @Column
    private Integer baseChance;
    @Enumerated(EnumType.STRING)
    private CoCAbilityScore.Ability abilityBase;
    @Column
    private Integer abilityMultiplier;
    @Column
    private Boolean multipliable;
    @Column
    private String source;

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
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getBaseChance() {
        return baseChance;
    }

    @Override
    public void setBaseChance(Integer baseChance) {
        this.baseChance = baseChance;
    }

    @Override
    public CoCAbilityScore.Ability getAbilityBase() {
        return abilityBase;
    }

    @Override
    public void setAbilityBase(CoCAbilityScore.Ability abilityBase) {
        this.abilityBase = abilityBase;
    }

    @Override
    public Integer getAbilityMultiplier() {
        return abilityMultiplier;
    }

    @Override
    public void setAbilityMultiplier(Integer abilityMultiplier) {
        this.abilityMultiplier = abilityMultiplier;
    }

    public Boolean getMultipliable() {
        return multipliable;
    }

    public void setMultipliable(Boolean multipliable) {
        this.multipliable = multipliable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        String result = getName() + " ";
        if (getBaseChance() != null) {
            result += "(";
            if (getBaseChance() < 10) {
                result += "0";
            }
            result += getBaseChance() + "%)";
        } else if (getAbilityBase() != null) {
            result += "(" + getAbilityBase().name() + "x" + getAbilityMultiplier() + ")";
        }
        return result;
    }

    @Override
    public int compareTo(CoCSkill o) {
        return this.getName().compareTo(o.getName());
    }

}
