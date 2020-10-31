import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 29, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3512/
 */

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {

    }

    public static int maxDistToClosest(int[] seats) {
        int len = seats.length, left[] = new int[len], right[] = new int[len];
        int leftIdx = 0, rightIdx = len - 1, max = 0;
        for (int i = 0; i < len; i++) {
            leftIdx = seats[i] == 0 ? leftIdx : i;
            left[i] = i - leftIdx;
        }
        for (int i = len - 1; i >= 0; i--) {
            rightIdx = seats[i] == 0 ? rightIdx : i;
            right[i] = rightIdx - i;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                max = Math.max(max, right[i]);
            } else if (i == len - 1) {
                max = Math.max(max, left[i]);
            } else {
                max = Math.max(max, Math.min(left[i], right[i]));
            }
        }
        return max;
    }
}
