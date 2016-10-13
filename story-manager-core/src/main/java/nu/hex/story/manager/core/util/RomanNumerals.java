package nu.hex.story.manager.core.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created 2016-jul-29
 *
 * @author hl
 */
public class RomanNumerals {

    private Integer number;
    private static final HashMap<String, Integer> ROMAN_NUMERALS = new LinkedHashMap<>();

    static {
        ROMAN_NUMERALS.put("M", 1000);
        ROMAN_NUMERALS.put("CM", 900);
        ROMAN_NUMERALS.put("D", 500);
        ROMAN_NUMERALS.put("CD", 400);
        ROMAN_NUMERALS.put("C", 100);
        ROMAN_NUMERALS.put("XC", 90);
        ROMAN_NUMERALS.put("L", 50);
        ROMAN_NUMERALS.put("XL", 40);
        ROMAN_NUMERALS.put("X", 10);
        ROMAN_NUMERALS.put("IX", 9);
        ROMAN_NUMERALS.put("V", 5);
        ROMAN_NUMERALS.put("IV", 4);
        ROMAN_NUMERALS.put("I", 1);
    }

    public RomanNumerals(Integer number) {
        this.number = number;
    }

    public String getRoman() {
        String res = "";
        for (Map.Entry<String, Integer> entry : ROMAN_NUMERALS.entrySet()) {
            int matches = number / entry.getValue();
            res += repeat(entry.getKey(), matches);
            number = number % entry.getValue();
        }
        return res;
    }

    private String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(s);
        }
        return result.toString();
    }
    
}
