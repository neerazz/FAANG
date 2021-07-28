package topQuestions.wayfair;

/*
https://leetcode.com/problems/valid-palindrome/
F

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeNaive(s));
        System.out.println(isPalindrome(s));
    }

    //Insight - Use two pointers to comapre them from front and back
    //use loops to push through unwanted characters

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeNaive(String s) {
        StringBuilder f = new StringBuilder();
        StringBuilder b = new StringBuilder();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                f.append(c);
                b.insert(0, c);
            }
        }
        return b.toString().equals(f.toString());
    }

}
