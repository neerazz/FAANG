package biweekly.biweekly31;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 */
public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {

    }

    public static int countOdds(int low, int high) {
        int o1 = (high + 1) / 2, o2 = (low) / 2;
        return o1 - o2;
    }
}
