package nu.hex.story.manager.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCSkillScore;

/**
 * Created 2016-okt-20
 *
 * @author hl
 */
public class TextUtil {

    private final String text;
    private static final String DELIMITER = " ";
    private final String[] lowerCaseWords = {"a", "an", "and", "at", "but", "by", "es", "for", "from", "into", "nor", "of", "or", "outof", "the", "to", "versus", "vs.", "v."};
    private final List<String> lowerCaseWordList = Arrays.asList(lowerCaseWords);
    private final Pattern p1 = Pattern.compile("[(\"\'].*");
    private final Pattern p2 = Pattern.compile("[:\\?!\\-]\\s.*");

    public TextUtil(String text) {
        this.text = text.replaceAll("\\s{2,}", " ");
    }

    public String splitTextIntoLines() {
        return splitTextIntoLines(80);
    }

    public String splitTextIntoLines(int maxLength) {
        return splitText(text, maxLength);
    }

    public String capitalize() {
        return capitalizeString();
    }

    private String capitalizeString() {
        String result = "";
        result = setLowerCaseWords(result);
        result = handleSubParts(result);
        result = romanNumeralsToUpperCase(result);
        result = firstLetterToUpperCase(result);
        return result;
    }

    private String setLowerCaseWords(String result) {
        for (String s : text.split(DELIMITER)) {
            if (lowerCaseWordList.contains(s.toLowerCase().trim())) {
                result += s.toLowerCase() + " ";
            } else {
                result += s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";
            }
        }
        return result;
    }

    private String handleSubParts(String string) {
        Matcher matcher1 = p1.matcher(string);
        while (matcher1.find()) {
            if (matcher1.group(0) != null) {
                String orig = matcher1.group(0);
                String replacement = orig.substring(0, 2).toUpperCase() + orig.substring(2);
                string = string.replace(orig, replacement);
            }
        }
        Matcher matcher2 = p2.matcher(string);
        while (matcher2.find()) {
            if (matcher2.group(0) != null) {
                String orig = matcher2.group(0);
                String replacement = orig.substring(0, 3).toUpperCase() + orig.substring(3);
                string = string.replace(orig, replacement);
            }
        }
        return string;
    }

    private String romanNumeralsToUpperCase(String string) {
        List<String> romanNumerals = getRomanNumerals();
        String result = "";
        for (String s : string.split(DELIMITER)) {
            if (romanNumerals.contains(s.toUpperCase().replaceAll("\\W", "").trim())) {
                result += s.toUpperCase() + " ";
            } else {
                result += s + " ";
            }
        }
        return result;
    }

    private String firstLetterToUpperCase(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).trim();
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

    private List<String> getRomanNumerals() {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 2021; i++) {
            result.add(new RomanNumerals(i).getRoman());
        }
        return result;
    }

    public static void main(String[] args) {
//        String testString = "the summoning of darkness (a call of cthulhu mdccclxxxix adventure) - part i: egypt, cairo and the nile";
//        String title;
//        title = new TextUtil(testString).capitalize();
//        System.out.println(title);
//        testString = "the summoning of darkness (a call of cthulhu mdccclxxxix adventure) - part ii: journey into the heart of darkness";
//        title = new TextUtil(testString).capitalize();
//        System.out.println(title);
//        System.out.println();
//        System.out.println(new TextUtil(title).splitTextIntoLines(50));
//        String testString = "the summoning of darkness (a call of cthulhu mdccclxxxix adventure)";

        System.out.println(CoCSkillScore.Skill.OPERATE_HEAVY_MACHINERY.getLabel());
        System.out.println(new TextUtil("CALL OF CTHULHU").capitalize());
        System.out.println(new TextUtil("the summoning of darkness (a cthulhu by gaslight adventure)").capitalize());
        System.out.println(new TextUtil("part i: marseille").capitalize());
        System.out.println(new TextUtil("part ii: egypt, cairo and the nile").capitalize());
        System.out.println(new TextUtil("part iii: a journey into the heart of darkness").capitalize());
        System.out.println(new TextUtil("part iv: dar es salaam").capitalize());
    }
}
