import java.util.LinkedHashSet;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/two-characters/problem
Sample Input
beabeefeab
Sample Output
5
Solution:
First of all identify all the distinct characters in string. To do this, we have removed duplicates from original string using a set.
Now iterate over distinct characters in pairs, use the string having no duplicates which we generated in above step.
Form the potential string having this pair of characters. To do this, iterate over original string and check for occurrences of these two characters and add them to potential string.
Now check the validity of potential string for alternate characters
If potential string is valud, keep count of max length of such strings to get the answer.
 */
public class TwoCharacters {
    public static void main(String[] args) {
        System.out.println(alternate("abaacdabd"));
    }

    static int alternate(String s) {
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return 2;
        }
        String noDups = removeDuplicates(s);
        int max = 0;
        for (int i = 0; i < noDups.length(); i++) {
            char a = noDups.charAt(i);
            for (int j = i + 1; j < noDups.length(); j++) {
                char b = noDups.charAt(j);
                String t = formString(s, a, b);
                if (isValid(t)) {
                    if (t.length() > max) {
                        max = t.length();
                    }
                }
            }
        }
        return max;
    }

    //form string from original string using these two chars
    static String formString(String s, char a, char b) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                newString += a;
            }
            if (s.charAt(i) == b) {
                newString += b;
            }
        }
        return newString;
    }

    static boolean isValid(String s) {
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i - 1) == s.charAt(i + 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    //    Run time 2^n.
    static int alternate_naive(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            String inputAfterRemoving = removeCharFromString(s, s.charAt(0));
            if (isAlternate(inputAfterRemoving)) {
                maxLength = Math.max(maxLength, inputAfterRemoving.length());
            }
            maxLength = Math.max(maxLength, alternate(inputAfterRemoving));
        }
        return maxLength;
    }

    private static String removeCharFromString(String input, char first) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur != first) {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    private static boolean isAlternate(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char first = s.charAt(0);
        int altStart = 0, altEnd = s.substring(1).indexOf(first) + 1, altIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(altIndex++)) {
                return false;
            }
            if (altIndex >= altEnd) {
                altIndex = 0;
            }
        }
        return true;
    }
}
