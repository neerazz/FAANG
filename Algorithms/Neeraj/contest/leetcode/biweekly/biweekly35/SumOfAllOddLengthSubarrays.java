package biweekly.biweekly35;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/sum-of-all-odd-length-subarrays
 */
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {

    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            sum += cur;
            for (int j = i + 1; j < arr.length; j++) {
                cur += arr[j];
                if ((j - i + 1) % 2 == 1) sum += cur;
            }
        }
        return sum;
    }
}
