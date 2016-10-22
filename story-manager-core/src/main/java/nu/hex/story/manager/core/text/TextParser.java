package nu.hex.story.manager.core.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;

/**
 * Created 2016-okt-19
 *
 * @author hl
 */
public abstract class TextParser {

    protected static final String
            FOOTNOTE = "F",
            ILLUSTRATION = "I",
            PORTRAIT = "P",
            MAP = "M",
            MARGIN_BOX = "B";
    // RPG:
    protected static final String
            HANDOUT = "HO",
            FLOOR_PLAN = "FP",
            MASTER_NOTE = "MN",
            MASTER_INFORMATION = "MI";
    protected static final String REG_EXP = "\\[(.*?)\\]";
    protected static final Pattern PATTERN = Pattern.compile(REG_EXP);
    private final String text;
    protected List<Footnote> footnotes = new ArrayList<>();
    protected List<MasterNote> masterNotes = new ArrayList<>();
    protected List<Illustration> illustrations;
    protected List<Portrait> portraits;
    protected List<Person> persons;

    public TextParser(String text) {
        this.text = text;
    }

    public void setIllustrations(List<Illustration> illustrations) {
        this.illustrations = illustrations;
    }

    public void setPortraits(List<Portrait> portraits) {
        this.portraits = portraits;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String parse() {
        String result = text;
        Matcher matcher = PATTERN.matcher(result);
        extractNotes(matcher);
        result = parseFootnotes(result);
        result = createPersonLinks(result);
        result = parseIllustrations(result);
        result = parsePortraits(result);
        return result;
    }

    protected final String createFootnoteMarkers(String result) {
        for (Footnote note : footnotes) {
            result = createFootnoteMarker(result, note);
        }
        return result;
    }

    protected abstract String parseFootnotes(String result);

    protected abstract String parseIllustrations(String result);

    protected abstract String parsePortraits(String result);

    protected abstract String createPersonLinks(String result);

    protected abstract String createFootnotes(String result);

    protected abstract String createFootnote(String result, Footnote note);

    protected abstract String createFootnoteMarker(String result, Footnote note);

    private void extractNotes(Matcher matcher) {
        int fIndex = 1;
        int mnIndex = 1;
        while (matcher.find()) {
            String key = matcher.group(1);
            switch (key.substring(0, key.indexOf(":"))) {
                case FOOTNOTE:
                    footnotes.add(new Footnote(fIndex, matcher.group(0), matcher.group(1)));
                    fIndex++;
                    break;
                case MASTER_NOTE:
                    masterNotes.add(new MasterNote(fIndex, matcher.group(0), matcher.group(1)));
                    mnIndex++;
                    break;
            }
        }
    }

    protected class Footnote extends Note {

        public Footnote(Integer index, String stringToReplace, String content) {
            super(index, stringToReplace, content);
        }
    }

    protected class MasterNote extends Note {

        public MasterNote(Integer index, String stringToReplace, String content) {
            super(index, stringToReplace, content);
        }
    }

    protected abstract class Note {

        private final Integer index;
        private final String stringToReplace;
        private final String content;

        public Note(Integer index, String stringToReplace, String content) {
            if (stringToReplace == null || stringToReplace.isEmpty()) {
                throw new IllegalArgumentException("String to replace is missing");
            }
            this.index = index;
            this.stringToReplace = stringToReplace;
            this.content = content.substring(content.indexOf(":") + 1);
        }

        public Integer getIndex() {
            return index;
        }

        public String getStringToReplace() {
            return stringToReplace;
        }

        public String getContent() {
            return content;
        }
    }
}
