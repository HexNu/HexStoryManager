package nu.hex.story.manager.core.text;

import java.util.List;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.util.TextUtil;

/**
 * Created 2016-okt-19
 *
 * @author hl
 */
public class PlainTextParser extends TextParser {

    private static final String INDENT = "   ";

    public PlainTextParser(String text, List<Illustration> illustrations, List<Portrait> portraits) {
        super(text);
    }

    @Override
    protected String parseFootnotes(String input) {
        if (!footnotes.isEmpty()) {
            input = createFootnoteMarkers(input);
            input = formatString(input);
            input = createFootnotes(input);
        }
        return input;
    }

    private String formatString(String stringToParse) {
        StringBuilder result = new StringBuilder();
        for (String line : stringToParse.split("\n")) {
            result.append(INDENT)
                    .append(new TextUtil(line).splitTextIntoLines(80))
                    .append("\n");
        }
        return result.toString().replaceFirst(INDENT, "");
    }

    @Override
    protected String parseIllustrations(String input) {
        for (Illustration illustration : illustrations) {
            input = createImageDescription(input, illustration.getId(), illustration.getLabel(), illustration.getDescription(), illustration.getImage().getName(), false);
        }
        return input.replaceAll("\r", "").replaceAll("\n\n" + INDENT, "\n\n");
    }

    @Override
    protected String parsePortraits(String input) {
        for (Portrait portrait : portraits) {
            input = createImageDescription(input, portrait.getId(), portrait.getLabel(), portrait.getDescription(), portrait.getImage().getName(), true);
        }
        return input.replaceAll("\r", "").replaceAll("\n\n" + INDENT, "\n\n");
    }

    @Override
    protected String createPersonLinks(String result) {
        return result;
    }

    private String createImageDescription(String input, Long id, String label, String description, String filename, boolean isPortrait) {
        String imageLabel = isPortrait ? "[PORTRAIT (" + filename + ")]" : "[ILLUSTRATION (" + filename + ")]";
        String replacementString = "\n\t- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
                + "\t"
                + imageLabel
                + "\n\t"
                + label
                + "\n\t";
        for (String line : description.split("\n")) {
            replacementString = replacementString + new TextUtil(line + "\n").splitTextIntoLines(60).replaceAll("\n", "\n\t");
        }
        replacementString = replacementString + "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        String stringToReplace = "\\[[IP]:" + id + "\\]";
        return input.replaceAll(stringToReplace, replacementString);
    }

    @Override
    protected String createFootnoteMarker(String stringToParse, Footnote note) {
        return stringToParse.replace(note.getStringToReplace(), "(" + note.getIndex() + ")");
    }

    @Override
    protected String createFootnotes(String stringToParse) {
        stringToParse = stringToParse + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
        for (Footnote note : footnotes) {
            stringToParse = createFootnote(stringToParse, note);
        }
        return stringToParse + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    }

    @Override
    protected String createFootnote(String result, Footnote note) {
        return result += "\n" + new TextUtil(" " + note.getIndex() + ") " + note.getContent()).splitTextIntoLines(80).replaceAll("\n", "\n    ");
    }
}
