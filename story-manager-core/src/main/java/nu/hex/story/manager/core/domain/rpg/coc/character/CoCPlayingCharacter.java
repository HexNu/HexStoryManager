package nu.hex.story.manager.core.domain.rpg.coc.character;

import nu.hex.story.manager.core.domain.rpg.coc.CoCLocale;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import nu.hex.story.manager.core.domain.rpg.character.Stats;

/**
 * Created 2016-okt-22
 *
 * @author hl
 */
@Entity
@DiscriminatorValue(value = "COC")
public class CoCPlayingCharacter extends AbstractPlayingCharacter {

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCStats.class)
    @JoinTable(name = "CoCPlayingCharacter_CoCStats")
    private Stats stats;
    @Column
    private String occcupation;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = CoCIncomeAndSavings.class)
    @JoinTable(name = "CoCPlayingCharacter_CoCIncomeAndSavings")
    private CoCIncomeAndSavings incomeAndSavings;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CoCMentalDisorder.class)
    private final Set<CoCMentalDisorder> mentalDisorders = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CoCEducation.class)
    private final Set<CoCEducation> collegesAndDegrees = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private CoCLocale cocLocale;

    public CoCPlayingCharacter() {
        this(CoCLocale.DEFAULT_LOCALE);
    }

    public CoCPlayingCharacter(CoCLocale locale) {
        this.cocLocale = locale;
//        this.incomeAndSavings = new CoCIncomeAndSavings(this);
    }

    @Override
    public Stats getStats() {
        return stats != null ? stats : new CoCStats();
    }

    @Override
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getOcccupation() {
        return occcupation;
    }

    public void setOcccupation(String occcupation) {
        this.occcupation = occcupation;
    }

    public List<CoCMentalDisorder> getMentalDisorders() {
        return new ArrayList<>(mentalDisorders);
    }

    public void setMentalDisorders(List<CoCMentalDisorder> mentalDisorders) {
        this.mentalDisorders.addAll(mentalDisorders);
    }

    public void addMentalDisorder(CoCMentalDisorder mentalDisorder) {
        mentalDisorders.add(mentalDisorder);
    }

    public List<CoCEducation> getCollegesAndDegrees() {
        return new ArrayList<>(collegesAndDegrees);
    }

    public void setCollegesAndDegrees(List<CoCEducation> collegesAndDegrees) {
        this.collegesAndDegrees.addAll(collegesAndDegrees);
    }

    public CoCIncomeAndSavings getIncomeAndSavings() {
        return incomeAndSavings;
    }

    public void setIncomeAndSavings(CoCIncomeAndSavings incomeAndSavings) {
        this.incomeAndSavings = incomeAndSavings;
        this.incomeAndSavings.setPlayingCharacter(this);
    }

    public CoCLocale getLocale() {
        return cocLocale;
    }

    public void setLocale(CoCLocale cocLocale) {
        this.cocLocale = cocLocale;
    }
//
//    public static void main(String[] args) {
//        CoCPlayingCharacter character = new CoCPlayingCharacter(CoCEra.E1920, CoCLocale.GB);
//        CoCIncomeAndSavings ias = character.getIncomeAndSavings();
//        ias.setCurrency(character.getLocale());
//        ias.setIncome(10000);
//        ias.setSavings(4300);
//        ias.setCashOnHand(500);
//        ias.setPersonalProperty(800);
//        ias.setRealEstate(120000);
//        System.out.println(ias.getFormatedIncome());
//        System.out.println(ias.getFormatedSavings());
//        System.out.println(ias.getFormatedCashOnHand());
//        System.out.println(ias.getFormatedPersonalProperty());
//        System.out.println(ias.getFormatedRealEstate());
//        CoCStats stats = (CoCStats) character.getStats();
//        stats.getAppearance().setValue(Die.D6.getBestOf(3, 5));
//        System.out.println(stats.getSkillValue(CoCSkillScore.Skill.SWIM));
//        stats.setSkillValue(CoCSkillScore.Skill.SWIM, 30);
//        System.out.println(stats.getSkillValue(CoCSkillScore.Skill.SWIM));
//        for (int i = 0; i < 70; i = i + 5) {
//            stats.increaseSkillValue(CoCSkillScore.Skill.GEOLOGY, 3);
//            System.out.println(stats.getSkillValue(CoCSkillScore.Skill.GEOLOGY));
//        }
//    }
}
