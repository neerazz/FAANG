package weekly.weekly228;

/**
 * Created on:  Feb 13, 2021
 * Questions:
 */

public class CountNumberOfHomogenousSubstrings {

    public static void main(String[] args) {

    }

    public static int countHomogenous(String s) {
        long count = 0, mod = 1_000_000_007, sub = 0;
        char pre = ' ';
        for (char cur : s.toCharArray()) {
            sub = pre == cur ? sub + 1 : 0;
            count += sub + 1;
            count %= mod;
            pre = cur;
        }
        return (int) count;
    }
}
