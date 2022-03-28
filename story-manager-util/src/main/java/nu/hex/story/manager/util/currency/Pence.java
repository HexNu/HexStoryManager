package nu.hex.story.manager.util.currency;

/**
 * Created 2016-okt-27
 *
 * @author hl
 */
class Pence {

    private Integer pence = 0;

    Pence(String input) {
        for (String part : input.toLowerCase().split("\\.")) {
            if (part.startsWith("£")) {
                pence += poundsToPence(getInteger(part));
            } else if (part.endsWith("s")) {
                pence += shillingsToPence(getInteger(part));
            } else if (part.endsWith("d")) {
                pence += getInteger(part);
            } else {
                pence = getInteger(part);
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
