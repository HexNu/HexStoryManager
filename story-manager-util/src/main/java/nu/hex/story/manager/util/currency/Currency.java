package nu.hex.story.manager.util.currency;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public enum Currency {

    ALL("Albanian lek", "L"),
    ATS("Austrian schilling", "öS"),
    BEF("Belgian franc", "fr"),
    CAD("Canadian dollar", "C$"),
    CHF("Swiss franc", "SFr"),
    CNY("Chinese yuan", "¥"),
    DEM("German mark", "DM"),
    DKR("Danish krone", "kr"),
    ESP("Spanish peseta", "Pta"),
    EUR("Euro", "€"),
    FRF("French franc", "Fr"),
    FMK("Finnish markka", "mp"),
    GBP("Brittish pound", "£"),
    GRD("Greek drachma", "Δρ"),
    HKD("Hong Kong dollar", "$"),
    IKR("Icelandic króne", "Íkr"),
    INR("Indian rupee", "₹"),
    ITL("Italian lira", "₤"),
    JPY("Japanese yen", "¥"),
    NOK("Norwegian krone", "kr"),
    NLG("Dutch guilder", "ƒ"),
    PTE("Portuguese escudo", "$"),
    RUB("Russian ruble", "₽"),
    SEK("Swedish krona", "kr"),
    USD("US dollar", "$"),;
    private final String label;
    private final String sign;
    public static final Currency DEFAULT = USD;

    private Currency(String label, String sign) {
        this.label = label;
        this.sign = sign;

    }

    public String getLabel() {
        return label;
    }

    public String getSign() {
        return sign;
    }
}
