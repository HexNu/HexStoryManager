package nu.hex.story.manager.util.currency;

/**
 * Created 2016-okt-26
 *
 * @author hl
 */
public class £sdCalculator {

    private String calculation;

    public £sdCalculator(String calculation) {
        this.calculation = calculation.replaceAll("\\s", "");
    }

    public String get() {
        if (calculation.contains("+")) {
            return add();
        } else if (calculation.startsWith("-")) {
            calculation = 0 + calculation;
            return subtract();
        } else if (calculation.contains("-")) {
            return subtract();
        } else if (calculation.contains("*")) {
            return multiply();
        } else if (calculation.contains("/")) {
            return divide();
        }
        return convert();
    }

    private String add() {
        Split split = new Split(calculation);
        Integer total = split.getFirst() + split.getSecond();
        StringBuilder result = getPoundsShillingsAndPence(total);
        return result.toString();
    }

    private String subtract() {
        Split split = new Split(calculation);
        Integer total = split.getFirst() - split.getSecond();
        StringBuilder result = getPoundsShillingsAndPence(total);
        return result.toString();
    }

    private String multiply() {
        Split split = new Split(calculation);
        Integer total = split.getFirst() * split.getSecond();
        StringBuilder result = getPoundsShillingsAndPence(total);
        return result.toString();
    }

    private String divide() {
        Split split = new Split(calculation);
        Integer total = split.getFirst() / split.getSecond();
        StringBuilder result = getPoundsShillingsAndPence(total);
        return result.toString();
    }

    private String convert() {
        StringBuilder result = getPoundsShillingsAndPence(new Pence(calculation).getPence());
        return result.toString();
    }

    private StringBuilder getPoundsShillingsAndPence(Integer total) {
        StringBuilder result = new StringBuilder();
        if (total < 0) {
            result.append("-");
        }
        total = Math.abs(total);
        String pounds = getPounds(total);
        String shillings = getShillings(total);
        String pence = getPence(total);
        result = getResultString(result, pounds, shillings, pence);
        return result;
    }

    private StringBuilder getResultString(StringBuilder result, String pounds, String shillings, String pence) {
        if (pounds != null) {
            result.append(pounds);
        }
        if (shillings != null) {
            if (!hasContent(result)) {
                result.append(".");
            }
            result.append(shillings);
        }
        if (pence != null) {
            if (!hasContent(result)) {
                result.append(".");
            }
            result.append(pence);
        }
        return result;
    }

    private static boolean hasContent(StringBuilder result) {
        return result.toString().isEmpty() || result.toString().equals("-");
    }

    private String getPounds(Integer input) {
        Integer pounds = Math.floorDiv(input, 240);
        return pounds == 0 ? null : "£" + pounds;
    }

    private String getShillings(Integer input) {
        Integer shillings = Math.floorDiv(input % 240, 12);
        return shillings == 0 ? null : shillings + "s";
    }

    private String getPence(Integer input) {
        Integer pence;
        pence = input % 12;
        return pence == 0 ? null : pence + "d";
    }

    private class Split {

        private Integer first = 0, second = 0;

        public Split(String input) {
            String[] parts = input.split("[-\\+\\/\\*]");
            first = new Pence(parts[0]).getPence();
            second = new Pence(parts[1]).getPence();
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }

    }
}
