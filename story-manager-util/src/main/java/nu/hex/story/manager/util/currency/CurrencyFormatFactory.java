package nu.hex.story.manager.util.currency;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
class CurrencyFormatFactory {

    private final Currency currency;

    CurrencyFormatFactory(Currency currency) {
        this.currency = currency;
    }

    NumberFormat getFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
        String format = "#,###,##0.00";
        switch (currency) {
            case ALL:
                format = format + "\u00A0" + currency.getSign();
                break;
            case ATS:
                format = format + "\u00A0" + currency.getSign();
                break;
            case BEF:
                format = format + "\u00A0" + currency.getSign();
                break;
            case CAD:
                format = currency.getSign() + format;
                break;
            case CHF:
                format = format + "\u00A0" + currency.getSign();
                break;
            case CNY:
                format = currency.getSign() + format;
                break;
            case DEM:
                format = currency.getSign() + "\u00A0" + format;
                break;
            case DKR:
                symbols.setDecimalSeparator(',');
                symbols.setGroupingSeparator('\u00A0');
                format = format + "\u00A0" + currency.getSign();
                break;
            case ESP:
                format = format + "\u00A0" + currency.getSign();
                break;
            case EUR:
                format = currency.getSign() + format;
                break;
            case FMK:
                format = format + "\u00A0" + currency.getSign();
                break;
            case FRF:
                format = format + "\u00A0" + currency.getSign();
                break;
            case GBP:
                format = currency.getSign() + format;
                break;
            case GRD:
                format = format + "\u00A0" + currency.getSign();
                break;
            case HKD:
                format = currency.getSign() + format;
                break;
            case IKR:
                symbols.setGroupingSeparator('\u00A0');
                symbols.setDecimalSeparator(',');
                format = format + "\u00A0" + currency.getSign();
                break;
            case INR:
                format = currency.getSign() + format;
                break;
            case ITL:
                symbols.setGroupingSeparator(',');
                format = currency.getSign() + "##,###,###";
                break;
            case JPY:
                format = currency.getSign() + format;
                break;
            case NOK:
                symbols.setDecimalSeparator(',');
                symbols.setGroupingSeparator('\u00A0');
                format = currency.getSign() + "\u00A0" + format;
                break;
            case NLG:
                format = currency.getSign() + format;
                break;
            case PTE:
                symbols.setDecimalSeparator('\u0024');
                break;
            case RUB:
                format = format + "\u00A0" + currency.getSign();
                break;
            case SEK:
                symbols.setDecimalSeparator(':');
                symbols.setGroupingSeparator('\u00A0');
                format = format + "\u00A0" + currency.getSign();
                break;
            case USD:
                format = currency.getSign() + format;
                break;
            default:
                format = currency.getSign() + "\u00A0" + format;
        }
        return new DecimalFormat(format, symbols);
    }
}
