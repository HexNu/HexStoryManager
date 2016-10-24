package nu.hex.story.manager.core.domain.rpg.coc.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.SkillScore;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "CoCSkill")
public class CoCSkillScore implements SkillScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Skill skill;
    @Column
    private Integer skillValue;

    public CoCSkillScore() {
    }

    public CoCSkillScore(Skill skill, Integer skillValue) {
        this.skill = skill;
        this.skillValue = skillValue;
    }

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
        return getSkill() != null ? getSkill().getLabel() : null;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public Integer getValue() {
        return skillValue;
    }

    @Override
    public void setValue(Integer skillValue) {
        this.skillValue = skillValue;
    }

    public enum Skill {
        ACCOUNTING(10),
        ANTHROPOLOGY(1),
        ARCHAEOLOGY(1),
        ART(5),
        ASTRONOMY(1),
        BARGAIN(5),
        BIOLOGY(1),
        CHEMISTRY(1),
        CLIMB(40),
        CONCEAL(15),
        CRAFT(5),
        CREDIT_RATING(15),
        CTHULHU_MYTHOS(0),
        DISGUISE(1),
        DODGE(-1),
        DRIVE_AUTO(20),
        ELECTRICAL_REPAIR(10),
        FAST_TALK(5),
        FIRST_AID(30),
        GEOLOGY(1),
        HIDE(10),
        HISTORY(20),
        JUMP(25),
        LAW(5),
        LIBRARY_USE(25),
        LISTEN(25),
        LOCKSMITH(1),
        MARTIAL_ARTS(1),
        MECHANICAL_REPAIR(20),
        MEDICIN(5),
        NATURAL_HISTORY(10),
        NAVIGATE(10),
        OCCULT(5),
        OPERATE_HEAVY_MACHINERY(1),
        OTHER_LANGUAGE(1),
        OWN_LANGUAGE(-1),
        PERSUADE(15),
        PHARMACY(1),
        PHOTOGRAPHY(10),
        PHYSICS(1),
        PILOT(1),
        PSYCHOANALYSIS(1),
        PSYCHOLOGY(5),
        RIDE(5),
        SNEAK(10),
        SPOT_HIDDEN(25),
        SWIM(25),
        THROW(25),
        TRACK(10);
        private final Integer initialValue;

        private Skill(Integer initialValue) {
            this.initialValue = initialValue;

        }

        public Integer getInitialValue() {
            return initialValue;
        }

        public String getLabel() {
            String label = "";
            for (String s : name().split("_")) {
                label += s.substring(0, 1) + s.substring(1).toLowerCase() + " ";
            }
            return label.trim();
        }

        @Override
        public String toString() {
            if (getInitialValue() > -1) {
                return getLabel() + " (" + getInitialValue() + "%)";
            }
            if (name().equals(DODGE.name())) {
                return getLabel() + " (DEX * 2%)";
            }
            if (name().equals(OWN_LANGUAGE.name())) {
                return getLabel() + " (EDU * 5%)";
            }
            return null;
        }
    }

}
