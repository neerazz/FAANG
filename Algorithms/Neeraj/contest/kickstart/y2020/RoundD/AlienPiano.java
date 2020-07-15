package y2020.RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Jul 12, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff08/0000000000387174
 */
public class AlienPiano {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int k = fr.nextInt();
            int[] nums = new int[k];
            for (int j = 0; j < k; j++) {
                nums[j] = fr.nextInt();
            }
            result[i] = getBrakes(k, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getBrakes(int len, int[] nums) {
        if (len < 2) return 0;
        int[][] dp = new int[len][4];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            int pre = nums[i - 1], cur = nums[i];
            for (int curJ = 0; curJ < 4; curJ++) {
                for (int preJ = 0; preJ < 4; preJ++) {
                    int breaks = 0;
                    if ((pre > cur && curJ <= preJ) || (cur > pre && preJ <= curJ)) breaks++;
                    dp[i][curJ] = Math.min(dp[i][curJ], dp[i - 1][preJ] + breaks);
                }
            }
        }
        return Arrays.stream(dp[len - 1]).min().getAsInt();
    }
}
