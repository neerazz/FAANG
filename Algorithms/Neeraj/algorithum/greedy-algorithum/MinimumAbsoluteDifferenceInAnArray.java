import java.util.Arrays;

/*
https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(new int[]{3, -7, 0}) + " should be [3]");
        System.out.println(minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}) + " should be [1]");
        System.out.println(minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}) + " should be [3]");
    }

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minValue = Math.min(minValue, Math.abs(arr[i] - arr[i + 1]));
        }
        return minValue;
    }
}
