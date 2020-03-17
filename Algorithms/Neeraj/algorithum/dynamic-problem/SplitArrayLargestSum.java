import java.util.*;

class SplitArrayLargestSum{
  public static void main(String[] args) {

  }
  public int splitArray(int[] nums, int m) {
    if(nums == null || nums.length == 0) return 0;
    int len = nums.length;
    int[] sums = new int[len+1];
    int[][] dp = new int[m+1][len+1];
    for(int i=1; i<=len; i++){
      sums[i] = sums[i-1] + nums[i-1];
    }
    for(int i = 0; i<=m;i++){
      Arrays.fill(dp[i],Integer.MAX_VALUE);
    }
    dp[0][0] = 0;
    // Loop through each element as cols and m as rows.
    for (int i =1; i <=m ; i++ ) {
      for (int j =1; j<= len ; j++ ) {
        // Find the best value at this point by comparing with the previous calculated values.
        for(int k =0; k < i ; k++){
          // Loop through till the elements and decide that can be splitted based on the values at that point and the new value.
          // We are taking the mim of (maximum value of the sum of splits) with all the possibilities
          dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j-1],sums[i]-sums[k]));
        }
      }
    }
    return dp[m][len];
  }
}
