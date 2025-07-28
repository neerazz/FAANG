import java.util.*;

/**
 *
 * @author :  bnira
 * Created :  7/28/2025
 * Problem : <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2025-07-28">...</a>
 *
 */
 
public class CountNumberOfMaximumBitwiseOrSubsets {


    public static void main(String[] args) {
        CountNumberOfMaximumBitwiseOrSubsets sol = new CountNumberOfMaximumBitwiseOrSubsets();
    }

    int result =0;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0, len = nums.length;
        for(int i=0; i<len; i++){
            max |= nums[i];
        }
        helper(nums, 0, len, 0, max);
        return result;
    }

    private void helper(int[] nums, int i, int len, int soFar, int max){
        if(i == len){
            if(soFar == max){
                result++;
            }
            return;
        }
        helper(nums, i+1, len, soFar | nums[i], max);
        helper(nums, i+1, len, soFar, max);
    }
    
}
