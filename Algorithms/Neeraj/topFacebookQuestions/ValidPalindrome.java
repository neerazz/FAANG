/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama") + " = " + isPalindrome_optimal("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car") + " = " + isPalindrome_optimal("race a car"));
    }

    public static boolean isPalindrome_optimal(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
//            Increment start till it reaches next alpha numeric value.
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
//            Reduce end till it reaches next alpha numeric value.
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start < end && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return checkForPalindrome(sb.toString());
    }

    private static boolean checkForPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
