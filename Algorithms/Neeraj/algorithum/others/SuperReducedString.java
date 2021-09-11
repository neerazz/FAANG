/*
https://www.hackerrank.com/challenges/reduced-string/problem
 */
public class SuperReducedString {
    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd") + " should be [abd]");
        System.out.println(superReducedString("aa") + " should be []");
        System.out.println(superReducedString("baab") + " should be []");
    }

    static String superReducedString(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                i = 0;
            }
        }
        return str.length() == 0 ? "Empty String" : str;
    }
}
