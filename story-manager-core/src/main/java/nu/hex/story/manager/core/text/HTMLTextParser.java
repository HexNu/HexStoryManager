package nu.hex.story.manager.core.text;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nu.hex.story.manager.core.domain.image.Illustration;
import nu.hex.story.manager.core.domain.image.Image;
import nu.hex.story.manager.core.domain.image.Portrait;
import nu.hex.story.manager.core.domain.person.Person;

/**
 * Created 2016-okt-19
 *
 * @author hl
 */
public class HTMLTextParser extends TextParser {

    public HTMLTextParser(String text) {
        super(text);
    }

    @Override
    protected String parseFootnotes(String stringToParse) {
        if (!footnotes.isEmpty()) {
            stringToParse = createFootnoteMarkers(stringToParse);
        }
        stringToParse = formatString(stringToParse);
        stringToParse = createFootnotes(stringToParse);
        return stringToParse;
    }

    @Override
    protected String createPersonLinks(String input) {
        for (Person person : persons) {
            Matcher matcher = Pattern.compile(person.getGivenName() + " *?", Pattern.CASE_INSENSITIVE).matcher(input);
            while (matcher.find()) {
                String link = "<a href=\"persons/" + person.getName() + ".html\">" + matcher.group(0) + "</a>";
                input = input.replaceFirst(matcher.group(0), link);
                break;

            }
        }
        return input;
    }

    @Override
    protected String parseIllustrations(String result) {
        for (Illustration illustration : illustrations) {
            result = createImage(result, illustration.getId(), illustration.getLabel(), illustration.getDescription(), illustration.getImage());
        }
        return result;
    }

    @Override
    protected String parsePortraits(String result) {
        for (Portrait portrait : portraits) {
            result = createImage(result, portrait.getId(), portrait.getLabel(), portrait.getDescription(), portrait.getImage());
        }
        return result;
    }

    private String createImage(String input, Long id, String label, String description, Image image) {
        StringBuilder tagBuilder = new StringBuilder()
                .append("\n<div class=\"image\" style=\"width:")
                .append(image.getWidth())
                .append("px;\">\n")
                .append("<img src=\"data:")
                .append(image.getMediaType())
                .append(";base64,")
                .append(Base64.getEncoder().encodeToString(image.getImageAsByteArray()))
                .append("\" alt=\"")
                .append(label)
                .append("\" width=\"")
                .append(image.getWidth())
                .append("\" height=\"")
                .append(image.getHeight())
                .append("\" title=\"")
                .append(description)
                .append("\"/>\n")
                .append("<p>\n")
                .append("<i><b>")
                .append(label)
                .append("</b></i><br/>\n<i>")
                .append(description.replaceAll("\n", "<br/>\n"))
                .append("</i>\n</p>\n")
                .append("</div>");
        String stringToReplace = "\\[[IP]:" + id + "\\]";
        return input.replaceAll(stringToReplace, tagBuilder.toString());
    }

    @Override
    protected String createFootnoteMarker(String input, Footnote note) {
        String replacement = "<a href=\"#note-"
                + note.getIndex()
                + "\"><sup>"
                + note.getIndex()
                + ")</sup></a>"
                + "<a name=\"note-link-"
                + note.getIndex()
                + "\"></a>";
        return input.replace(note.getStringToReplace(), replacement);
    }

    private String formatString(String stringToParse) {
        StringBuilder result = new StringBuilder();
        for (String line : stringToParse.split("\n")) {
            if (isImageLine(line)) {
                result.append(line);
            } else {
                result.append("\n<p>\n")
                        .append(line)
                        .append("\n</p>");
            }
        }
        return result.toString();
    }

    private boolean isImageLine(String line) {
        return line.trim().matches("\\[[IP]:\\d+\\]");
    }

    @Override
    protected String createFootnotes(String stringToParse) {
        stringToParse = stringToParse + "\n<div class=\"footnote\">\n";
        for (Footnote note : footnotes) {
            stringToParse = createFootnote(stringToParse, note);
        }
        stringToParse = stringToParse + "</div>\n";
        return stringToParse;
    }

    @Override
    protected String createFootnote(String result, Footnote note) {
        return result + "<p>\n  <a href=\"#note-link-"
                + note.getIndex()
                + "\"><sup>"
                + note.getIndex()
                + ")</sup></a>"
                + "<a name=\"note-"
                + note.getIndex()
                + "\"> </a>"
                + note.getContent()
                + "\n</p>\n";
    }
}
