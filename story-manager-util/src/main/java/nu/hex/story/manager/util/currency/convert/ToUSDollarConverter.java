package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class ToUSDollarConverter extends AbstractDollarConverter {

    public ToUSDollarConverter(Integer year) {
        super(year, 1927, 2015);
    }

    static {
    }
}
