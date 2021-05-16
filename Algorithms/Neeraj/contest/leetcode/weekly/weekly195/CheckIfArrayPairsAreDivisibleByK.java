package weekly.weekly195;

/**
 * Created on:  Jun 27, 2020
 * Questions:
 * Check If Array Pairs Are Divisible by k
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
 */
public class CheckIfArrayPairsAreDivisibleByK {
    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 *****************************");
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5) + " should be [true]");
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7) + " should be [true]");
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10) + " should be [false]");
        System.out.println(canArrange(new int[]{-10, 10}, 2) + " should be [true]");
        System.out.println(canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3) + " should be [true]");
        System.out.println(canArrange(new int[]{3, 8, 7, 2}, 10) + " should be [true]");
        System.out.println(canArrange(new int[]{3, 8, 17, 2, 5, 6}, 10) + " should be [false]");
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int val : arr) {
            int cur = val % k;
            if (cur < 0) cur += k;
            rem[cur]++;
        }
        for (int i = 1; i < k; i++) {
            if (rem[i] != rem[k - i]) return false;
        }
//        After we find all the pairs, check if the zero remainders can be paired or not.
        return rem[0] % 2 == 0;
    }
}
