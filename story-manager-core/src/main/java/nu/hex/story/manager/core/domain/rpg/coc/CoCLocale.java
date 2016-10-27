package nu.hex.story.manager.core.domain.rpg.coc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nu.hex.story.manager.util.currency.Currency;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public enum CoCLocale {
    AL("Albania", "Albanian", Currency.ALL, "sq"),
    AT("Austria", "Austrian", Currency.ATS, "de-AT"),
    BE("Belgium", "Belgian", Currency.BEF, "fr-BE", "nl-BE", "de-BE"),
    CA("Canada", "Canadian", Currency.CAD, "en-CA", "fr-CA"),
    CH("Swizerland", "Swiss", Currency.CHF, "de-CH", "fr-CH", "it-CH"),
    CN("China", "Chinese", Currency.CNY, "zh"),
    DK("Denmark", "Danish", Currency.DKR, "da"),
    DE("Germany", "German", Currency.DEM, "de"),
    ES("Spain", "Spanish", Currency.ESP, "es", "ca", "eu"),
    FI("Finland", "Finnish", Currency.FMK, "fi", "sv-FI"),
    FR("France", "French", Currency.FRF, "fr"),
    GB("Great Britain", "English", Currency.GBP, "en"),
    GR("Greece", "Greek", Currency.GRD, "el"),
    HK("Hong Kong", "Hong Kongese", Currency.HKD, "zh", "en-HK"),
    IN("India", "Hindu", Currency.INR, "hi", "en"),
    IS("Iceland", "Icelandic", Currency.IKR, "is"),
    IT("Italy", "Italian", Currency.ITL, "it"),
    JP("Japan", "Japanese", Currency.JPY, "ja"),
    NL("Netherlands", "Dutch", Currency.NLG, "nl", "fy", "en"),
    NO("Norway", "Norwegian", Currency.NOK, "no", "se"),
    PT("Portugal", "Portugese", Currency.PTE, "pt"),
    RU("Russia", "", Currency.RUB, "ru"),
    SE("Sweden", "Swedish", Currency.SEK, "sv", "se", "fi-SV", "yi"),
    US("United States of America", "English", Currency.USD, "en-US");
    private final String country;
    private final String nationality;
    private final Currency currency;
    private final List<String> languages = new ArrayList<>();
    public static final CoCLocale DEFAULT_LOCALE = US;

    private CoCLocale(String country, String nationality, Currency currency, String... language) {
        this.country = country;
        this.nationality = nationality;
        this.currency = currency;
        this.languages.addAll(Arrays.asList(language));
    }

    public String getCountry() {
        return country;
    }

    public String getNationality() {
        return nationality;
    }

    public Currency getCurrency() {
        return currency;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
