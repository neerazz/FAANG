import java.util.*;

class MaximumSubarray{
  public static void main(String[] args) {

  }

  public int maxSubArray(int[] nums) {
    int max = nums[0], sumSoFar = nums[0];
    for (int i = 1; i < nums.length ; i++ ) {
      int pre = dp[i-1];
      int cur = nums[i];
      dp[i] = Math.max()
    }
  }
}
