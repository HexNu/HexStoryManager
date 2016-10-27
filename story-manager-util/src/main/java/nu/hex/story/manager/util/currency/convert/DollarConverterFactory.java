package nu.hex.story.manager.util.currency.convert;

import nu.hex.story.manager.util.currency.Currency;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public class DollarConverterFactory {

    private final Integer year;

    public DollarConverterFactory(Integer year) {
        this.year = year;
    }

    public DollarConverter getConverter(Currency currency) {
        switch (currency) {
            case ALL:
                return getAlbanianConverter();
            case ATS:
                return getAustrianConverter();
            case BEF:
                return getBelgianConverter();
            case CAD:
                return getCanadianConverter();
            case CHF:
                return getSwissConverter();
            case CNY:
                return getChineseConverter();
            case DEM:
                return getGermanConverter();
            case DKR:
                return getDanishConverter();
            case ESP:
                return getSpanishConverter();
            case EUR:
                return getEuroConverter();
            case FMK:
                return getFinnishConverter();
            case FRF:
                return getFrenchConverter();
            case GBP:
                return getBrittishConverter();
            case GRD:
                return getGreekConverter();
            case HKD:
                return getHongKongConverter();
            case IKR:
                return getIcelandicConverter();
            case INR:
                return getIndianConverter();
            case ITL:
                return getItalianConverter();
            case JPY:
                return getJapaneseConverter();
            case NLG:
                return getDutchConverter();
            case NOK:
                return getNorwegianConverter();
            case PTE:
                return getPortugeseConverter();
            case RUB:
                return getRussianConverter();
            case SEK:
                return getSwedishConverter();
        }
        return null;
    }

    public AlbanianLeiToUSDollarConverter getAlbanianConverter() {
        return new AlbanianLeiToUSDollarConverter(year);
    }

    public AustrianSchillingToUSDollarConverter getAustrianConverter() {
        return new AustrianSchillingToUSDollarConverter(year);
    }

    public BelgianFrancToUSDollarConverter getBelgianConverter() {
        return new BelgianFrancToUSDollarConverter(year);
    }

    public BrittishPoundToUSDollarConverter getBrittishConverter() {
        return new BrittishPoundToUSDollarConverter(year);
    }

    public CanadianDollarToUSDollarConverter getCanadianConverter() {
        return new CanadianDollarToUSDollarConverter(year);
    }

    public ChineseYuanToUSDollarConverter getChineseConverter() {
        return new ChineseYuanToUSDollarConverter(year);
    }

    public DanishCrownToUSDollarConverter getDanishConverter() {
        return new DanishCrownToUSDollarConverter(year);
    }

    public DutchGuilderToUSDollarConverter getDutchConverter() {
        return new DutchGuilderToUSDollarConverter(year);
    }

    public EuroToUSDollarConverter getEuroConverter() {
        return new EuroToUSDollarConverter(year);
    }

    public FinnishMarkToUSDollarConverter getFinnishConverter() {
        return new FinnishMarkToUSDollarConverter(year);
    }

    public FrenchFrancToUSDollarConverter getFrenchConverter() {
        return new FrenchFrancToUSDollarConverter(year);
    }

    public GermanMarkToUSDollarConverter getGermanConverter() {
        return new GermanMarkToUSDollarConverter(year);
    }

    public GreekDrachmaToUSDollarConverter getGreekConverter() {
        return new GreekDrachmaToUSDollarConverter(year);
    }

    public HongKongDollarToUSDollarConverter getHongKongConverter() {
        return new HongKongDollarToUSDollarConverter(year);
    }

    public IcelandicCrownToUSDollarConverter getIcelandicConverter() {
        return new IcelandicCrownToUSDollarConverter(year);
    }

    public IndianRupeeToUSDollarConverter getIndianConverter() {
        return new IndianRupeeToUSDollarConverter(year);
    }

    public ItalianLiraToUSDollarConverter getItalianConverter() {
        return new ItalianLiraToUSDollarConverter(year);
    }

    public JapaneseYenToUSDollarConverter getJapaneseConverter() {
        return new JapaneseYenToUSDollarConverter(year);
    }

    public NorwegianCrownToUSDollarConverter getNorwegianConverter() {
        return new NorwegianCrownToUSDollarConverter(year);
    }

    public PortugeseEscudoToUSDollarConverter getPortugeseConverter() {
        return new PortugeseEscudoToUSDollarConverter(year);
    }

    public RussianRubleToUSDollarConverter getRussianConverter() {
        return new RussianRubleToUSDollarConverter(year);
    }

    public SpanishPesetaToUSDollarConverter getSpanishConverter() {
        return new SpanishPesetaToUSDollarConverter(year);
    }

    public SwedishCrownToUsDollarConverter getSwedishConverter() {
        return new SwedishCrownToUsDollarConverter(year);
    }

    public SwissFrancToUSDollarConverter getSwissConverter() {
        return new SwissFrancToUSDollarConverter(year);
    }
}
