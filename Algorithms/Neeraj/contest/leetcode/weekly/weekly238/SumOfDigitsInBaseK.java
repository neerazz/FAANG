package weekly.weekly238;

/**
 * Created on:  Apr 24, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-238/problems/sum-of-digits-in-base-k/
 */

public class SumOfDigitsInBaseK {

    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
    }

    public static int sumBase(int n, int k) {
        String change = Integer.toString(n, k);
        int sum = 0;
        for (char c : change.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
