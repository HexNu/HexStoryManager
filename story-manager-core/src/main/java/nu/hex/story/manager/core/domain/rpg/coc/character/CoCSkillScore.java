package nu.hex.story.manager.core.domain.rpg.coc.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.rpg.character.Skill;
import nu.hex.story.manager.core.domain.rpg.character.SkillScore;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@Table(name = "CoCSkillScore")
public class CoCSkillScore implements SkillScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = CoCSkill.class)
    private CoCSkill skill;
    @Column
    private Integer skillValue;

    public CoCSkillScore() {
    }

    public CoCSkillScore(CoCSkill skill, Integer skillValue) {
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
        return getSkill() != null ? getSkill().getName() : null;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(CoCSkill skill) {
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
//
//    public enum Skill {
//        ACCOUNTING(10, true, true, true),
//        ANTHROPOLOGY(0, true, true, true),
//        ARCHAEOLOGY(0, true, true, true),
//        ART(5, true, true, true),
//        ASTRONOMY(0, true, true, true),
//        BARGAIN(5, true, true, true),
//        BIOLOGY(0, true, true, true),
//        CHEMISTRY(0, true, true, true),
//        CLIMB(40, true, true, true),
//        COMPUTER_USE(0, false, false, true),
//        CONCEAL(15, true, true, true),
//        CRAFT(5, true, true, true),
//        CREDIT_RATING(15, true, true, true),
//        CTHULHU_MYTHOS(0, true, true, true),
//        DISGUISE(0, true, true, true),
//        DODGE(-1, true, true, true),
//        DRIVE_AUTO(20, false, true, true),
//        DRIVE_CARRRIAGE(20, false, true, true),
//        ELECTRICAL_REPAIR(10, true, true, true),
//        FAST_TALK(5, true, true, true),
//        FIRST_AID(30, true, true, true),
//        GEOLOGY(0, true, true, true),
//        HIDE(10, true, true, true),
//        HISTORY(20, true, true, true),
//        JUMP(25, true, true, true),
//        LAW(5, true, true, true),
//        LIBRARY_USE(25, true, true, true),
//        LISTEN(25, true, true, true),
//        LOCKSMITH(0, true, true, true),
//        MARTIAL_ARTS(0, true, true, true),
//        MECHANICAL_REPAIR(20, true, true, true),
//        MEDICIN(5, true, true, true),
//        NATURAL_HISTORY(10, true, true, true),
//        NAVIGATE(10, true, true, true),
//        OCCULT(5, true, true, true),
//        OPERATE_HEAVY_MACHINERY(0, true, true, true),
//        OTHER_LANGUAGE(0, true, true, true),
//        OWN_LANGUAGE(-1, true, true, true),
//        PERSUADE(15, true, true, true),
//        PHARMACY(0, true, true, true),
//        PHOTOGRAPHY(10, true, true, true),
//        PHYSICS(0, true, true, true),
//        PILOT(0, true, true, true),
//        PSYCHOANALYSIS(0, true, true, true),
//        PSYCHOLOGY(5, true, true, true),
//        RIDE(5, true, true, true),
//        SNEAK(10, true, true, true),
//        SPOT_HIDDEN(25, true, true, true),
//        SWIM(25, true, true, true),
//        THROW(25, true, true, true),
//        TRACK(10, true, true, true);
//        private final Integer initialValue;
//
//        private Skill(Integer initialValue, boolean e1890, boolean e1920, boolean e1990) {
//            this.initialValue = initialValue;
//
//        }
//
//        public Integer getInitialValue() {
//            return initialValue;
//        }
//
//        public String getLabel() {
//            return new TextUtil(name().replaceAll("_", " ")).capitalize();
//        }
//
//        @Override
//        public String toString() {
//            if (getInitialValue() > -1) {
//                return getLabel() + " (" + getInitialValue() + "%)";
//            }
//            if (name().equals(DODGE.name())) {
//                return getLabel() + " (DEX * 2%)";
//            }
//            if (name().equals(OWN_LANGUAGE.name())) {
//                return getLabel() + " (EDU * 5%)";
//            }
//            return null;
//        }
//    }

}
