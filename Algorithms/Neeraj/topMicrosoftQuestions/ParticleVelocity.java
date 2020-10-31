import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/428272/
 */

public class ParticleVelocity {

    public static void main(String[] args) {

    }

    public static int numberOfArithmeticSlices(int[] a) {
        int len = a.length;
        int[] dp = new int[len];
        if (len < 3) return 0;
        int count = 0;
        for (int i = 2; i < len; i++) {
            if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                count += dp[i];
                if (count > 1_000_000_000) return -1;
            }
        }
        return count;
    }
}
