public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int p1 = 0, p2 = c.length - 1;
        while (p1 <= p2) {
            char c1 = c[p1];
            char c2 = c[p2];
            if (!Character.isLetter(c1) && !Character.isDigit(c1)) {
                p1++;
                continue;
            }
            if (!Character.isLetter(c2) && !Character.isDigit(c2)) {
                p2--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
