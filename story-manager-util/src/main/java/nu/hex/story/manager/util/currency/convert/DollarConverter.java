package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public interface DollarConverter {

    Double getCurrencyToDollar(Double currency);

    Double getCurrencyToDollar(Integer currency);

    Double getDollarToCurrency(Double dollar);

    Double getDollarToCurrency(Integer dollar);

    Integer getStartYear();

}
