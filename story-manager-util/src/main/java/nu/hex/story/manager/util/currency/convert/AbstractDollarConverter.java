package nu.hex.story.manager.util.currency.convert;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created 2016-okt-23
 * <br>
 * Calculate approximate exchange rate for a currency and dollar between min
 * year and max year.
 *
 * @author hl
 */
public abstract class AbstractDollarConverter implements DollarConverter {

    private static final NumberFormat FORMAT = new DecimalFormat("#,##0.0000");
    protected static final Map<Integer, Double> RATIO_MAP = new HashMap<>();
    protected final Integer year;
    protected Integer min = 1873;
    protected Integer max = 2015;

    public AbstractDollarConverter(Integer year, Integer min, Integer max) {
        this.year = year;
        this.min = min;
        this.max = max;
        if (year < min || year > max) {
            throw new IllegalArgumentException("The value is out of range (" + min + " - " + max + ")");
        }
    }

    @Override
    public Integer getStartYear() {
        return min;
    }

    @Override
    public Double getDollarToCurrency(Double dollar) {
        return getDoubleWithUpToFourDecimalDigits(dollar / RATIO_MAP.get(year));
    }

    @Override
    public Double getDollarToCurrency(Integer dollar) {
        return getDollarToCurrency(dollar.doubleValue());
    }

    @Override
    public Double getCurrencyToDollar(Double currency) {
        return getDoubleWithUpToFourDecimalDigits(currency * RATIO_MAP.get(year));
    }

    @Override
    public Double getCurrencyToDollar(Integer currency) {
        return getCurrencyToDollar(currency.doubleValue());
    }

    private Double getDoubleWithUpToFourDecimalDigits(Double input) {
        return Double.valueOf(FORMAT.format(input).replaceAll(",", ".").replaceAll("\u00A0", ""));
    }
}
