package nu.hex.story.manager.core.domain.rpg.coc.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import nu.hex.story.manager.core.domain.DomainEntity;
import nu.hex.story.manager.core.domain.rpg.coc.CoCLocale;
import nu.hex.story.manager.util.currency.Currency;
import nu.hex.story.manager.util.currency.CurrencyFormat;
import nu.hex.story.manager.util.currency.convert.DollarConverterFactory;

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
    @OneToOne(targetEntity = CoCPlayingCharacter.class)
    private CoCPlayingCharacter playingCharacter;
    @Column
    private Double income = 0d;
    @Column
    private Double cashOnHand = 0d;
    @Column
    private Double savings = 0d;
    @Column
    private Double personalProperty = 0d;
    @Column
    private Double realEstate = 0d;
    @Transient
    private CurrencyFormat currencyFormat;

    public CoCIncomeAndSavings() {
    }

    public CoCIncomeAndSavings(CoCPlayingCharacter playingCharacter) {
        this.playingCharacter = playingCharacter;
        this.currencyFormat = new CurrencyFormat(playingCharacter.getLocale().getCurrency(), playingCharacter.getEra().getYear());
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
        return "Income & Savings";
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setCurrency(CoCLocale locale) {
        switch (locale) {
            case US:
                setCurrency(Currency.USD);
                break;
            case SE:
                setCurrency(Currency.SEK);
                break;
            case GB:
                setCurrency(Currency.GBP);
                break;
            default:
                setCurrency(Currency.DEFAULT);
                break;
        }
    }

    public Double getIncome() {
        return income;
    }

    public String getFormatedIncome() {
        return currencyFormat.format(income);
    }

    public void setIncome(Integer incomeInDollar) {
        setIncome(incomeInDollar.doubleValue());
    }

    public void setIncome(Double incomeInDollar) {
        this.income = getDollarAsCurrency(incomeInDollar);
    }

    public Double getCashOnHand() {
        return cashOnHand;
    }

    public String getFormatedCashOnHand() {
        return currencyFormat.format(cashOnHand);
    }

    public void setCashOnHand(Double cashOnHand) {
        this.cashOnHand = getDollarAsCurrency(cashOnHand);
    }

    public void setCashOnHand(Integer cashOnHand) {
        setCashOnHand(cashOnHand.doubleValue());
    }

    public Double getSavings() {
        return savings;
    }

    public String getFormatedSavings() {
        return currencyFormat.format(savings);
    }

    public void setSavings(Double savings) {
        this.savings = getDollarAsCurrency(savings);
    }

    public void setSavings(Integer savings) {
        setSavings(savings.doubleValue());
    }

    public Double getPersonalProperty() {
        return personalProperty;
    }

    public String getFormatedPersonalProperty() {
        return currencyFormat.format(personalProperty);
    }

    public void setPersonalProperty(Double personalProperty) {
        this.personalProperty = getDollarAsCurrency(personalProperty);
    }

    public void setPersonalProperty(Integer personalProperty) {
        setPersonalProperty(personalProperty.doubleValue());
    }

    public Double getRealEstate() {
        return realEstate;
    }

    public String getFormatedRealEstate() {
        return currencyFormat.format(realEstate);
    }

    public void setRealEstate(Double realEstate) {
        this.realEstate = getDollarAsCurrency(realEstate);
    }

    public void setRealEstate(Integer realEstate) {
        setRealEstate(realEstate.doubleValue());
    }

    public CoCPlayingCharacter getPlayingCharacter() {
        return playingCharacter;
    }

    public void setPlayingCharacter(CoCPlayingCharacter playingCharacter) {
        this.playingCharacter = playingCharacter;
    }

    private Double getDollarAsCurrency(Double dollar) {
        if (getCurrency().equals(Currency.USD)) {
            return dollar;
        }
        Integer year = getPlayingCharacter().getEra().getYear();
        return new DollarConverterFactory(year).getConverter(getCurrency()).getDollarToCurrency(dollar);
    }
}
