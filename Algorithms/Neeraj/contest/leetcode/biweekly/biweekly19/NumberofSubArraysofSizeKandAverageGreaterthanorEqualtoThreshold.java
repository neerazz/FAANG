package biweekly.biweekly19;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers arr and two integers k and threshold.
Return the number of sub-arrays of size k and average greater than or equal to threshold.
Example 1:
Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
Example 2:
Input: arr = [1,1,1,1,1], k = 1, threshold = 0
Output: 5
Example 3:
Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
Example 4:
Input: arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
Output: 1
 */
public class NumberofSubArraysofSizeKandAverageGreaterthanorEqualtoThreshold {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
        System.out.println(numOfSubarrays(new int[]{1,1,1,1,1},1,0));
        System.out.println(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},3,5));
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
//        Loop through the array and get the average of k sub-arrays into a list.
        int sum = 0, counter = 0, removeIndex = 0;
        List<Double> averageList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (counter >= k){
//                Then remove one value from
                sum -= arr[removeIndex++];
                counter--;
            }
            sum += arr[i];
            counter++;
            if (counter == k){
                averageList.add((double)sum /counter);
            }
        }
        return (int) averageList.parallelStream().filter(val -> val>=threshold).count();
    }
}
