import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {
    static Map<Integer, String> denom = new LinkedHashMap<>();
    static Map<Integer, String> unique = new HashMap<>();

    static {
        denom.put(1_000_000_000, "Billion ");
        denom.put(1_000_000, "Million ");
        denom.put(1_000, "Thousand ");

        unique.put(1, "One ");
        unique.put(2, "Two ");
        unique.put(3, "Three ");
        unique.put(4, "Four ");
        unique.put(5, "Five ");
        unique.put(6, "Six ");
        unique.put(7, "Seven ");
        unique.put(8, "Eight ");
        unique.put(9, "Nine ");
        unique.put(10, "Ten ");
        unique.put(11, "Eleven ");
        unique.put(12, "Twelve ");
        unique.put(13, "Thirteen ");
        unique.put(14, "Fourteen ");
        unique.put(15, "Fifteen ");
        unique.put(16, "Sixteen ");
        unique.put(17, "Seventeen ");
        unique.put(18, "Eighteen ");
        unique.put(19, "Nineteen ");
        unique.put(20, "Twenty ");
        unique.put(30, "Thirty ");
        unique.put(40, "Forty ");
        unique.put(50, "Fifty ");
        unique.put(60, "Sixty ");
        unique.put(70, "Seventy ");
        unique.put(80, "Eighty ");
        unique.put(90, "Ninety ");
    }

    public static void main(String[] args) {
//        System.out.println(numberToWords(0));
//        System.out.println(numberToWords(12));
        System.out.println(numberToWords(100));
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int key : denom.keySet()) {
            if (num >= key) {
                int div = num / key;
                num %= key;
                sb.append(getString(div)).append(denom.get(key));
            }
        }
        if (num > 0) sb.append(getString(num));
        return sb.toString().trim();
    }

    private static String getString(int val) {
        if (val < 1000 && val >= 100) return getThreeDigitString(val);
        else if (val < 100 && val >= 10) return getTwoDigitString(val);
        else return unique.get(val);
    }

    private static String getThreeDigitString(int val) {
        if (val % 100 == 0) return getString(val / 100) + "Hundred ";
        return getString(val / 100) + "Hundred " + getTwoDigitString(val % 100);
    }

    private static String getTwoDigitString(int val) {
        if (val <= 20) return unique.get(val);
        int div = (val / 10) * 10, rem = val % 10;
        if (rem > 0) {
            return unique.get(div) + unique.get(val % 10);
        }
        return unique.get(div);
    }
}
