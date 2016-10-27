package nu.hex.story.manager.util.currency;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
class Pence {

    private Integer pence = 0;

    public Pence(String input) {
        for (String p : input.toLowerCase().split("\\.")) {
            if (p.startsWith("£")) {
                pence += poundsToPence(getInteger(p));
            } else if (p.endsWith("s")) {
                pence += shillingsToPence(getInteger(p));
            } else if (p.endsWith("d")) {
                pence += getInteger(p);
            } else {
                pence = getInteger(p);
            }
        }
    }

    public Integer getPence() {
        return pence;
    }

    private Integer getInteger(String p) throws NumberFormatException {
        return Integer.valueOf(p.replaceAll("\\D", ""));
    }

    private Integer shillingsToPence(Integer shillings) {
        return shillings * 12;
    }

    private Integer poundsToPence(Integer pounds) {
        return pounds * 20 * 12;
    }
}
