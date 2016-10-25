package nu.hex.story.manager.util.rpg;

/**
 * Created 2016-okt-25
 *
 * @author hl
 */
public enum Currency {

    USD("US Dollar", "$"),
    GBP("Brittish Pound", "£"),
    OLD_GBP("Brittish Pound", "£");
    private final String name;
    private final String symbol;

    private Currency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;

    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
