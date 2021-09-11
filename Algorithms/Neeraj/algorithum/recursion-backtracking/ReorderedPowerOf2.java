/**
 * Created on:  Mar 21, 2021
 * Questions: https://leetcode.com/problems/reordered-power-of-2/
 */

public class ReorderedPowerOf2 {

    public static void main(String[] args) {

    }

    public static boolean reorderedPowerOf2(int N) {
        int[] counts = new int[10];
        int digits = 0;
        while (N > 0) {
            counts[N % 10]++;
            N /= 10;
            digits++;
        }
        for (int i = 1; i < 10; i++) {
            if (counts[i] > 0) {
                counts[i]--;
                if (helper(i, counts, digits - 1)) return true;
                counts[i]++;
            }
        }
        return false;
    }

    static boolean helper(int val, int[] counts, int digits) {
        if (digits == 0) {
            while (val % 2 == 0 && val > 0) {
                val /= 2;
            }
            return val == 1;
        } else {
            for (int i = 0; i < 10; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    if (helper(val * 10 + i, counts, digits - 1)) return true;
                    counts[i]++;
                }
            }
            return false;
        }
    }
}
