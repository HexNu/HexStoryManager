package nu.hex.story.manager.util.currency;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
public class £sdFormat {

    private final static double SHILLING = 12d, 
            POUND = 20d * SHILLING;

    public Double parse(String input) {
        return (new Pence(input).getPence() / POUND); 
    }

    public String format(Integer input) {
        return format(input.doubleValue());
    }

    public String format(Double input) {
        Integer pounds = new Double(Math.floor(input)).intValue();
        Integer p = new Double(Math.round((input - pounds) * 240)).intValue();
        Integer shillings = new Double(Math.floor(p / 12)).intValue();
        Integer pence = new Double(Math.round(p % 12)).intValue();
        if (pence == 12) {
            shillings++;
            pence = 0;
        }
        if (shillings == 20) {
            pounds++;
            shillings = 0;
        }
        StringBuilder result = new StringBuilder();
        if (pounds > 0) {
            NumberFormat format = new DecimalFormat("#,###,###");
            result.append("£").append(format.format(pounds).replace("\u00A0", ","));
        }
        if (shillings > 0) {
            if (!result.toString().isEmpty()) {
                result.append(".");
            }
            result.append(shillings).append("s");
        }
        if (pence > 0) {
            if (!result.toString().isEmpty()) {
                result.append(".");
            }
            result.append(pence).append("d");
        }
        return result.toString();
    }
}
