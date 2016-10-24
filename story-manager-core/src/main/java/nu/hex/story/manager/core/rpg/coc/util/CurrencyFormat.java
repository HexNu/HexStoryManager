package nu.hex.story.manager.core.rpg.coc.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCIncomeAndSavings.Currency;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class CurrencyFormat {

    Currency currency;

    public CurrencyFormat(Currency currency) {
        this.currency = currency;
    }

    public String format(Integer input) {
        return format(input.doubleValue());
    }

    public String format(Double input) {
        if (currency.equals(Currency.OLD_GBP)) {
            return convertToPoundShillingPence(input);
        }
        NumberFormat format = new DecimalFormat("#,###,##0.00");
        return currency.getSymbol() + format.format(input).replaceAll(",", ".").replace("\u00A0", ",");
    }

    private String convertToPoundShillingPence(Double input) {
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

    public static void main(String[] args) {
        Double dollar = 1000000d;
        PoundToDollarConverter converter;
        System.out.println("For $" + dollar.intValue() + " you got £:");
        for (int i = 1791; i <= 2015; i++) {
            converter = new PoundToDollarConverter(i);
            Double pound = converter.getDollarToPound(dollar);
            Currency currency = i < 1971 ? Currency.OLD_GBP : Currency.GBP;
            CurrencyFormat format = new CurrencyFormat(currency);
            System.out.println(i + " " + format.format(pound));
        }
    }
}
