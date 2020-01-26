package problems.arraysAndString;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println("Answer is: " + strStr("hello", "ll") + " should be 2");
        System.out.println("Answer is: " + strStr("aaaaa", "bba") + " should be -1");
        System.out.println("Answer is: " + strStr("mississippi", "issi") + " should be 1");
        System.out.println("Answer is: " + strStr("bbaa", "aab") + " should be -1");
        System.out.println("Answer is: " + strStr("mississippi", "issip") + " should be 4");
        System.out.println("Answer is: " + strStr("aaa", "a") + " should be 0");
        System.out.println("+++++++++++++++KMP++++++++++++++++++++");
        System.out.println("Answer is: " + strStr_KMP("hello", "ll") + " should be 2");
        System.out.println("Answer is: " + strStr_KMP("aaaaa", "bba") + " should be -1");
        System.out.println("Answer is: " + strStr_KMP("mississippi", "issi") + " should be 1");
        System.out.println("Answer is: " + strStr_KMP("bbaa", "aab") + " should be -1");
        System.out.println("Answer is: " + strStr_KMP("mississippi", "issip") + " should be 4");
        System.out.println("Answer is: " + strStr_KMP("aaa", "a") + " should be 0");
    }

    public static int strStr_KMP(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();

        int[] lps = calculateLPS(needle);
        int j = 0;

        for (int i = 0; i < hayLength; i++) {
            char current = haystack.charAt(i);
            if (current == needle.charAt(j)) {
                j++;
            }
            if (j == needleLength) {
//                Match Found return go back by J in I to get the Starting index.
                return i - j + 1;
            } else if (i < needleLength && current == needle.charAt(j)) {
                if (j != 0) j = lps[j];
                else i++;
            }
        }
        return -1;
    }

    private static int[] calculateLPS(String needle) {
        int[] lps = new int[needle.length()];
        Map<String, Integer> combination = new HashMap<>();
        for (int i = 0; i < needle.length(); i++) {
            String current = String.valueOf(needle.charAt(i));
            if (combination.containsKey(current)) {
                lps[i] = combination.get(current);
                combination.put(current, i + 1);
            } else {
                lps[i] = 0;
                combination.put(current, i + 1);
            }
        }
        return lps;
    }

    public static int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        if (hayLength == needleLength) return haystack.equals(needle) ? 0 : -1;
        if (needleLength == 0) return 0;
        if (hayLength < needleLength) return -1;
        if (needleLength == 1) {
            return haystack.indexOf(needle);
        }

        char[] hayChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        int index = 0, index2 = 1;
        while (index < hayLength) {
            if (hayChars[index] == needleChars[0] && index + needleLength <= hayLength) {
                int index3 = index + 1;
                while (index2 < needleLength) {
                    if (hayChars[index3] != needleChars[index2]) {
                        break;
                    }
                    if (index2 == needleLength - 1) return index;
                    index2++;
                    index3++;
                }
            }
            index2 = 1;
            index++;
        }
        return -1;
    }
}
