package weekly.weekly217;

import java.util.*;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class RichestCustomerWealth {

    public static void main(String[] args) {

    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] bank : accounts) {
            int sum = Arrays.stream(bank).sum();
            max = Math.max(max, sum);
        }
        return max;
    }
}
