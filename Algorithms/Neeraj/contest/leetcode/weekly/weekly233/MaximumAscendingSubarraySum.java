package weekly.weekly233;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class MaximumAscendingSubarraySum {

    public static void main(String[] args) {

    }
    public static int maxAscendingSum(int[] nums) {
        int max = 0, len = nums.length;
        for(int i=0; i<len; i++){
            int sum = nums[i], j =i+1;
            while(j < len && nums[j-1] < nums[j]){
                sum += nums[j++];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
