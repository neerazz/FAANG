package concepts.arraysStrings;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println("Is Palindrome  " + str + " " + isPalindrome(str));
    }

    private static boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) return true;
        int n = input.length();
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) return false;
        }
        return true;
    }

}
