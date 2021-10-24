/**
 * Created on:  Dec 08, 2020
 * Questions: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {

    }

    public static int numPairsDivisibleBy60_rev1(int[] time) {
        int[] count = new int[60];
        for (int val : time) {
            count[val % 60]++;
        }
        int total = (count[0] * (count[0] - 1)) / 2;
        total += (count[30] * (count[30] - 1)) / 2;
        for (int i = 1; i < 30; i++) {
            total += count[i] * count[60 - i];
        }
        return total;
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60], count = 0;
        for (int t : time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}
