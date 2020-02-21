package firecode.level1;

/*
A palindrome is a string or sequence of characters that reads the same backward as forward. For example, "madam" is a palindrome. Write a method that takes in a String and returns a boolean -> true if the input String is a palindrome and false if it is not. An empty string and a null input are considered palindromes. You also need to account for the space character. For example, "race car" should return false as read backward it is "rac ecar".
Examples:
isStringPalindrome("madam") -> true
isStringPalindrome("aabb") -> false
isStringPalindrome("race car") -> false
isStringPalindrome("") -> true
isStringPalindrome(null) -> true
 */
public class PalindromeTester {
    public static void main(String[] args) {
        System.out.println(isStringPalindrome("madam"));
    }

    public static boolean isStringPalindrome(String str) {
        if (str.isEmpty() || str.isEmpty()) return true;
        int stat = 0, end = str.length() - 1;
        while (stat < end) {
            if (str.charAt(stat++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
