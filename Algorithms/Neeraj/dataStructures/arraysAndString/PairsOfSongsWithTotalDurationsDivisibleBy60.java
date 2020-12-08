import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 08, 2020
 * Questions: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {

    }

    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
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
