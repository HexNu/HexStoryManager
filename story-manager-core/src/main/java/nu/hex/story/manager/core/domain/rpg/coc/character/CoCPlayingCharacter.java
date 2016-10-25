package nu.hex.story.manager.core.domain.rpg.coc.character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nu.hex.story.manager.core.domain.rpg.character.AbstractPlayingCharacter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import nu.hex.story.manager.core.domain.rpg.character.Stats;
import nu.hex.story.manager.util.rpg.Currency;
import nu.hex.story.manager.util.rpg.Die;
import nu.hex.story.manager.util.rpg.PoundToDollarConverter;

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
    }

    public static void main(String[] args) {
        CoCPlayingCharacter character = new CoCPlayingCharacter();
        CoCIncomeAndSavings ias = new CoCIncomeAndSavings();
        ias.setCurrency(Currency.GBP);
        ias.setIncome(new PoundToDollarConverter(1920).getDollarToPound(10000d).intValue());
        character.setIncomeAndSavings(ias);
        System.out.println(ias.getCurrency().getSymbol() + ias.getIncome());
        System.out.println(ias.getFormatedIncome());
        CoCStats stats = (CoCStats) character.getStats();
        stats.getAppearance().setValue(Die.D6.getBestOf(3, 5));
        System.out.println(stats.getSkillValue(CoCSkillScore.Skill.SWIM));
        stats.setSkillValue(CoCSkillScore.Skill.SWIM, 30);
        System.out.println(stats.getSkillValue(CoCSkillScore.Skill.SWIM));
        for (int i = 0; i < 70; i = i + 5) {
            stats.increaseSkillValue(CoCSkillScore.Skill.GEOLOGY, 3);
            System.out.println(stats.getSkillValue(CoCSkillScore.Skill.GEOLOGY));
        }
    }
}
