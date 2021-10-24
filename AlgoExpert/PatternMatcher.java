/**
 * Created on:  Feb 02, 2021
 * Questions: https://www.algoexpert.io/questions/Pattern%20Matcher
 * Pattern Matcher
 * You're given two non-empty strings. The first one is a pattern consisting of only "x"s and / or "y"s; the other one is a normal string of alphanumeric characters. Write a function that checks whether the normal string matches the pattern.
 * <p>
 * A string S0 is said to match a pattern if replacing all "x"s in the pattern with some non-empty substring S1 of S0 and replacing all "y"s in the pattern with some non-empty substring S2 of S0 yields the same string S0.
 * <p>
 * If the input string doesn't match the input pattern, the function should return an empty array; otherwise, it should return an array holding the strings S1 and S2 that represent "x" and "y" in the normal string, in that order. If the pattern doesn't contain any "x"s or "y"s, the respective letter should be represented by an empty string in the array that you return.
 * <p>
 * You can assume that there will never be more than one pair of strings S1 and S2 that appropriately represent "x" and "y" in the normal string.
 * <p>
 * Sample Input
 * pattern = "xxyxxy"
 * string = "gogopowerrangergogopowerranger"
 * Sample Output
 * ["go", "powerranger"]
 */

public class PatternMatcher {

    public static void main(String[] args) {

    }

    public static String[] patternMatcher(String p, String s) {
        if (p.length() == 0) return new String[0];
        char[] chars = p.toCharArray();
        if (p.charAt(0) == 'y') {
            convert(chars);
            String[] result = patternMatcher(String.valueOf(chars), s);
            return new String[]{result[1], result[0]};
        }
        int xCount = 0, yCount = 0, firstY = -1, len = s.length();
        for (int i = 0; i < chars.length; i++) {
            xCount += chars[i] == 'x' ? 1 : 0;
            yCount += chars[i] == 'y' ? 1 : 0;
            if (chars[i] == 'y' && firstY == -1) firstY = i;
        }
        if (xCount == 0) {
            int y = len % yCount == 0 ? len / yCount : -1;
            if (y < -1) return new String[0];
            String[] res = isPossible(p, s, 0, 0, y, yCount, firstY);
            if (res != null) return res;
        } else if (yCount == 0) {
            int x = len % xCount == 0 ? len / xCount : -1;
            if (x < -1) return new String[0];
            String[] res = isPossible(p, s, x, xCount, 0, 0, -1);
            if (res != null) return res;
        } else {
            for (int x = 1; x < len; x++) {
                int y = getYLen(xCount, yCount, x, len);
                if (y <= 0) continue;
                String[] res = isPossible(p, s, x, xCount, y, yCount, firstY);
                if (res != null) return res;
            }
        }
        return new String[0];
    }

    private static String[] isPossible(String p, String s, int x, int xc, int y, int yc, int firstY) {
        String s1 = s.substring(0, x), s2 = firstY == -1 ? "" : s.substring(x * firstY, (x * firstY) + y);
        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (c == 'x') sb.append(s1);
            else sb.append(s2);
        }
        return sb.toString().equals(s) ? new String[]{s1, s2} : null;
    }

    private static int getYLen(int xc, int yc, int x, int len) {
        if (yc == 0) return xc * x == len ? 0 : -1;
        int temp = len - (x * xc);
        return temp < 0 || temp % yc != 0 ? -1 : temp / yc;
    }

    private static void convert(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                chars[i] = 'y';
            } else {
                chars[i] = 'x';
            }
        }
    }
}
