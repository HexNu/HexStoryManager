package nu.hex.story.manager.core.util;

/**
 * Created 2016-okt-20
 *
 * @author hl
 */
public class TextUtil {

    private final String text;

    public TextUtil(String text) {
        this.text = text;
    }

    public String splitTextIntoLines(int maxLength) {
        return splitText(text, maxLength);
    }

    private String splitText(String text, int maxLength) {
        StringBuilder result = new StringBuilder();
        if (text.length() > maxLength) {
            String a = text.substring(0, maxLength);
            a = a.substring(0, a.lastIndexOf(" "));
            result.append(a);
            result.append("\n").append(splitText(text.substring(a.length() + 1), maxLength));
        } else {
            result.append(text);
        }
        return result.toString();
    }
}
