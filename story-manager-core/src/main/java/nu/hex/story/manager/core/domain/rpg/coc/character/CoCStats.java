package nu.hex.story.manager.core.domain.rpg.coc.character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.AbilityScore;
import nu.hex.story.manager.core.domain.rpg.character.Stats;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkillScore.Skill;

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
    private AbilityScore strength = new CoCAbilityScore(CoCAbilityScore.Ability.STR, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore dexterity = new CoCAbilityScore(CoCAbilityScore.Ability.DEX, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore constitution = new CoCAbilityScore(CoCAbilityScore.Ability.CON, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore intelligence = new CoCAbilityScore(CoCAbilityScore.Ability.INT, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore power = new CoCAbilityScore(CoCAbilityScore.Ability.POW, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore appearance = new CoCAbilityScore(CoCAbilityScore.Ability.APP, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore size = new CoCAbilityScore(CoCAbilityScore.Ability.SIZ, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore sanity = new CoCAbilityScore(CoCAbilityScore.Ability.SAN, 0);
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCAbilityScore.class)
    private AbilityScore education = new CoCAbilityScore(CoCAbilityScore.Ability.EDU, 0);
    @Column
    private Integer hitPoints;
    @Column
    private Integer currentHitPoints;
    @Column
    private Integer temporaryHitPoints;
    @Column
    private Integer startingSanityPoints;
    @Column
    private Integer currentSanityPoints;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CoCSkillScore.class)
    private Set<CoCSkillScore> skills = null;

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

    public Integer getStrength() {
        return strength.getValue();
    }

    public void setStrength(AbilityScore strength) {
        this.strength = strength;
    }

    public Integer getSTR() {
        return strength.getValue();
    }

    public void setSTR(Integer value) {
        strength.setValue(value);
    }

    public AbilityScore getDexterity() {
        return dexterity;
    }

    public void setDexterity(AbilityScore dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getDEX() {
        return dexterity.getValue();
    }

    public void setDEX(Integer value) {
        dexterity.setValue(value);
    }

    public AbilityScore getConstitution() {
        return constitution;
    }

    public void setConstitution(AbilityScore constitution) {
        this.constitution = constitution;
    }

    public Integer getCON() {
        return constitution.getValue();
    }

    public void setCON(Integer value) {
        constitution.setValue(value);
    }

    public AbilityScore getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(AbilityScore intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getINT() {
        return intelligence.getValue();
    }

    public void setINT(Integer value) {
        intelligence.setValue(value);
    }

    public AbilityScore getPower() {
        return power;
    }

    public void setPower(AbilityScore power) {
        this.power = power;
    }

    public Integer getPOW() {
        return power.getValue();
    }

    public void setPOW(Integer value) {
        power.setValue(value);
    }

    public AbilityScore getAppearance() {
        return appearance;
    }

    public void setAppearance(AbilityScore appearance) {
        this.appearance = appearance;
    }

    public Integer getAPP() {
        return appearance.getValue();
    }

    public void setAPP(Integer value) {
        appearance.setValue(value);
    }

    public AbilityScore getSize() {
        return size;
    }

    public void setSize(AbilityScore size) {
        this.size = size;
    }

    public Integer getSIZ() {
        return size.getValue();
    }

    public void setSIZ(Integer value) {
        size.setValue(value);
    }

    public AbilityScore getSanity() {
        return sanity;
    }

    public void setSanity(AbilityScore sanity) {
        this.sanity = sanity;
    }

    public Integer getSAN() {
        return sanity.getValue();
    }

    public void setSAN(Integer value) {
        sanity.setValue(value);
    }

    public AbilityScore getEducation() {
        return education;
    }

    public void setEducation(AbilityScore education) {
        this.education = education;
    }

    public Integer getEDU() {
        return education.getValue();
    }

    public void setEDU(Integer value) {
        education.setValue(value);
    }

    public AbilityScore getIdea() {
        Integer value = getINT() * 5;
        return new CoCAbilityScore(CoCAbilityScore.Ability.IDEA, value);
    }

    public Integer getIDEA() {
        return getINT() * 5;
    }

    public AbilityScore getLuck() {
        Integer value = getPOW() * 5;
        return new CoCAbilityScore(CoCAbilityScore.Ability.LUCK, value);
    }

    public Integer getLUCK() {
        return getPOW() * 5;
    }

    public AbilityScore getKnowledge() {
        Integer value = getEDU() * 5;
        return new CoCAbilityScore(CoCAbilityScore.Ability.KNOW, value);
    }

    public Integer getKNOW() {
        return getEDU() * 5;
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

    public Integer getStartingSanityPoints() {
        return startingSanityPoints;
    }

    public void setStartingSanityPoints(Integer startingSanityPoints) {
        this.startingSanityPoints = startingSanityPoints;
    }

    public Integer getCurrentSanityPoints() {
        return currentSanityPoints;
    }

    public void setCurrentSanityPoints(Integer currentSanityPoints) {
        this.currentSanityPoints = currentSanityPoints;
    }

    public Integer getMaximumSanityPoints() {
        return 99 - getSkillValue(CoCSkillScore.Skill.CTHULHU_MYTHOS);
    }

    public List<CoCSkillScore> getSkills() {
        if (skills == null) {
            initSkills();
        }
        return new ArrayList<>(skills);
    }

    public void addSkill(CoCSkillScore skill) {
        skills.add(skill);
    }

    private void initSkills() {
        skills = new HashSet<>();
        for (Skill skill : CoCSkillScore.Skill.values()) {
            skills.add(new CoCSkillScore(skill, skill.getInitialValue()));
        }
    }

    public Integer getSkillValue(CoCSkillScore.Skill skill) {
        for (CoCSkillScore skillScore : getSkills()) {
            if (skillScore.getSkill().equals(skill)) {
                return skillScore.getValue();
            }
        }
        return 0;
    }

    public void increaseSkillValue(CoCSkillScore.Skill skill, Integer increment) {
        setSkillValue(skill, getSkillValue(skill) + increment);
    }

    public void setSkillValue(CoCSkillScore.Skill skill, Integer value) {
        getSkills().stream().filter((skillScore) -> (skillScore.getSkill().equals(skill))).forEach((skillScore) -> {
            skillScore.setValue(value);
        });
    }
}
