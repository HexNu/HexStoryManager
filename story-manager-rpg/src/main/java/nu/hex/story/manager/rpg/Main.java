package nu.hex.story.manager.rpg;

import nu.hex.story.manager.util.rpg.Currency;
import nu.hex.story.manager.util.rpg.CurrencyFormat;
import nu.hex.story.manager.util.rpg.PoundToDollarConverter;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public class Main {

    public static void main(String[] args) {
        Double pounds;
        String result;
        pounds = new PoundToDollarConverter(1794).getDollarToPound(2450);
        result = new CurrencyFormat(Currency.OLD_GBP).format(pounds);
        System.out.println(result);
        pounds = new PoundToDollarConverter(1820).getDollarToPound(2450);
        result = new CurrencyFormat(Currency.OLD_GBP).format(pounds);
        System.out.println(result);
        pounds = new PoundToDollarConverter(1894).getDollarToPound(2450);
        result = new CurrencyFormat(Currency.OLD_GBP).format(pounds);
        System.out.println(result);
        pounds = new PoundToDollarConverter(1920).getDollarToPound(2450);
        result = new CurrencyFormat(Currency.OLD_GBP).format(pounds);
        System.out.println(result);
        pounds = new PoundToDollarConverter(1994).getDollarToPound(2450);
        result = new CurrencyFormat(Currency.GBP).format(pounds);
        System.out.println(result);
    }
}
