import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 24, 2021
 * Questions: https://leetcode.com/problems/3sum-with-multiplicity/
 */

public class ThreeSumWithMultiplicity {

    public static void main(String[] args) {

    }

    public static int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        long count = 0, mod = 1_000_000_007;
        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
//             Perform two sum
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    if (arr[start] == arr[end]) {
//                        If both the values are same then, there are n*(n-1)/2 ways to pick pick that number.
//                        Add all the possible ways and break the loop because, there is nothing to be processed in between.
                        int total = end - start + 1;
                        count += (total * (total - 1)) / 2;
                        count %= mod;
                        break;
                    } else {
//                        Whenever A[j] + A[k] == T, we should count how many A[j] , A[k] are present.
//                        Example: [2,2,2,2,3,3,4,4,4,5,5,5,6,6]:
//                          if A[j] == 2 and A[k] == 6, then A[j] occurs 4 times and A[k] occurs 2 times, and the total number of possible pairs will be 4 * 2 = 8.
//                          We then move to the remaining window A[j:k+1] of [3,3,4,4,4,5,5,5].
                        int oc1 = 1, oc2 = 1;
                        while (start < end && arr[start] == arr[start + 1]) {
                            start++;
                            oc1++;
                        }
                        while (start < end && arr[end] == arr[end - 1]) {
                            end--;
                            oc2++;
                        }
                        count += oc1 * oc2;
                        count %= mod;
                        start++;
                        end--;
                    }
                }
            }
        }
        return (int) count;
    }
}
