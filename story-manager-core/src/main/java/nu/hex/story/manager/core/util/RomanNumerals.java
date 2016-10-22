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
    private static final HashMap<String, Integer> ROMAN_NUMERALS_INTEGER = new LinkedHashMap<>();

    static {
        ROMAN_NUMERALS_INTEGER.put("ↈ", 100000);
        ROMAN_NUMERALS_INTEGER.put("Mↈ", 90000);
        ROMAN_NUMERALS_INTEGER.put("ↇ", 50000);
        ROMAN_NUMERALS_INTEGER.put("Mↇ", 40000);
        ROMAN_NUMERALS_INTEGER.put("ↂ", 10000);
        ROMAN_NUMERALS_INTEGER.put("Mↂ", 9000);
        ROMAN_NUMERALS_INTEGER.put("ↁ", 5000);
        ROMAN_NUMERALS_INTEGER.put("Mↁ", 4000);
        ROMAN_NUMERALS_INTEGER.put("M", 1000);
        ROMAN_NUMERALS_INTEGER.put("CM", 900);
        ROMAN_NUMERALS_INTEGER.put("D", 500);
        ROMAN_NUMERALS_INTEGER.put("CD", 400);
        ROMAN_NUMERALS_INTEGER.put("C", 100);
        ROMAN_NUMERALS_INTEGER.put("XC", 90);
        ROMAN_NUMERALS_INTEGER.put("L", 50);
        ROMAN_NUMERALS_INTEGER.put("XL", 40);
        ROMAN_NUMERALS_INTEGER.put("X", 10);
        ROMAN_NUMERALS_INTEGER.put("IX", 9);
        ROMAN_NUMERALS_INTEGER.put("V", 5);
        ROMAN_NUMERALS_INTEGER.put("IV", 4);
        ROMAN_NUMERALS_INTEGER.put("I", 1);
    }

    public RomanNumerals(Integer number) {
        this.number = number;
    }

    public RomanNumerals(Long number) {
        this.number = number.intValue();
    }

    public String getRoman() {
        String res = "";
        for (Map.Entry<String, Integer> entry : ROMAN_NUMERALS_INTEGER.entrySet()) {
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
