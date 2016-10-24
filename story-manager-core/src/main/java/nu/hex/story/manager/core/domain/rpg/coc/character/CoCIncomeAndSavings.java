package nu.hex.story.manager.core.domain.rpg.coc.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nu.hex.story.manager.core.domain.DomainEntity;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
@Entity
@Table(name = "CoCIncomeAndSavings")
public class CoCIncomeAndSavings implements DomainEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column
    private Integer income;
    @Column
    private Integer cashOnHand;
    @Column
    private Integer savings;
    @Column
    private Integer personalProperty;
    @Column
    private Integer realEstate;

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
        return "Income & Savings";
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getIncome() {
        return income;
    }

    public String getFormatedIncome() {
        return String.format(currency.getSymbol() + "%,4f", income.doubleValue());
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(Integer cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    public Integer getSavings() {
        return savings;
    }

    public void setSavings(Integer savings) {
        this.savings = savings;
    }

    public Integer getPersonalProperty() {
        return personalProperty;
    }

    public void setPersonalProperty(Integer personalProperty) {
        this.personalProperty = personalProperty;
    }

    public Integer getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(Integer realEstate) {
        this.realEstate = realEstate;
    }

    public enum Currency {
        USD("US Dollar", "$"),
        GBP("Brittish Pound", "£"),
        OLD_GBP("Brittish Pound", "£");
        private final String name;
        private final String symbol;

        private Currency(String name, String symbol) {
            this.name = name;
            this.symbol = symbol;

        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
