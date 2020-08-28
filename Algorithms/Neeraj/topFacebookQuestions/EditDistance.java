

/**
 * Created on:  Aug 19, 2020
 * Questions: https://www.facebook.com/careers/life/sample_interview_questions
 * <p>
 * Write a function that returns whether two words are exactly "one edit" away using the following signature:
 * bool OneEditApart(string s1, string s2);
 * An edit is:
 * Inserting one character anywhere in the word (including at the beginning and end)
 * Removing one character
 * Replacing one character
 */
public class EditDistance {
    public static void main(String[] args) {

    }

    private boolean oneEditApart(String str1, String str2) {
        return helper(str1, str2, true);
    }

    private boolean helper(String str1, String str2, boolean ignoreOne) {
        if (Math.abs(str1.length() - str2.length()) > 1) return false;
        if (!ignoreOne) return str1.equals(str2);
        int p1 = 0, p2 = 0, l1 = str1.length(), l2 = str2.length();
        while (p1 < l1 && p2 < l2) {
            if (str1.charAt(p1) == str2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                return helper(str1.substring(1), str2, false) ||
                        helper(str1, str2.substring(1), false) || helper(str1.substring(1), str2.substring(1), false);
            }
        }
        return false;
    }
}
