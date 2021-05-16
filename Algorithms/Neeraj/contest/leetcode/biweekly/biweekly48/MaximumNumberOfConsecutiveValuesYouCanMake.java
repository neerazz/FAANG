package biweekly.biweekly48;

import java.util.*;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class MaximumNumberOfConsecutiveValuesYouCanMake {

    public static void main(String[] args) {

    }

    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
//        As we always start from 0, because zero can be formed by default
        int range = 1;
        for (int num : coins) {
            if (num <= range) {
//            If my range can be reached till the num then, the range can be increased.
                range += num;
            } else break;
        }
        return range;
    }
}
