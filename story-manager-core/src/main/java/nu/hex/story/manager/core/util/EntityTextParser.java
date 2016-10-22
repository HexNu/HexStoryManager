package nu.hex.story.manager.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 2016-okt-20
 *
 * @author hl
 */
public class EntityTextParser {

    protected final Pattern pattern;
    private final String text;

    public EntityTextParser(String text, String regexp) {
        this.pattern = Pattern.compile(regexp);
        this.text = text;
    }

    public Long getSingle() {
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            return Long.valueOf(matcher.group(1));
        }
        return null;
    }

    public List<Long> getIdList() {
        List<Long> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(Long.valueOf(matcher.group(1)));
        }
        return result;
    }
}
