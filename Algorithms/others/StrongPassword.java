import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://www.hackerrank.com/challenges/strong-password/problem
 */
public class StrongPassword {
    public static void main(String[] args) {
        System.out.println(minimumNumber(3, "Abl") + " should return [3]");
        System.out.println(minimumNumber(11, "#HackerRank") + " should return [1]");
        System.out.println(minimumNumber(4, "4700") + " should return [3]");
    }

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int count = 0;
        Matcher matcherDigit = Pattern.compile("(\\d)").matcher(password);
        Matcher matcherUpper = Pattern.compile("([A-Z])").matcher(password);
        Matcher matcherLower = Pattern.compile("([a-z])").matcher(password);
        Matcher matcherSpecial = Pattern.compile("(\\W)").matcher(password);

        if (!matcherDigit.find()) {
            count++;
        }
        if (!matcherUpper.find()) {
            count++;
        }
        if (!matcherLower.find()) {
            count++;
        }
        if (!matcherSpecial.find()) {
            count++;
        }
        return Math.max(6 - n, count);
    }
}
