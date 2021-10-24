/*
https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
public class HackerRankInAString {
    public static void main(String[] args) {
        System.out.println(hackerrankInString("hereiamstackerrank") + " should be [YES]");
        System.out.println(hackerrankInString("hackerworld") + " should be [NO]");
    }

    static String hackerrankInString(String s) {
        if (s == null || s.length() == 0) {
            return "NO";
        }
        char[] chars = "hackerrank".toCharArray();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == chars[index]) {
                index++;
            }
        }
        return index < 10 ? "NO" : "YES";
    }
}
