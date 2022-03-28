package nu.hex.story.manager.util.currency;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class CurrencyFormat {

    public static final int DEFAULT_YEAR = 1920;
    private final Currency currency;
    private final Integer year;
    private final CurrencyFormatFactory formatFactory = new CurrencyFormatFactory();

    public CurrencyFormat(Currency currency) {
        this(currency, DEFAULT_YEAR);
    }

    public CurrencyFormat(Currency currency, Integer year) {
        this.currency = currency;
        this.year = year;
    }

    public String format(Integer input) {
        return format(input.doubleValue());
    }

    public String format(Double input) {
        if (currency.equals(Currency.GBP) && year < 1971) {
            return new £sdFormat().format(input);
        }
        return formatFactory.getFormat(currency).format(input);
    }
}
