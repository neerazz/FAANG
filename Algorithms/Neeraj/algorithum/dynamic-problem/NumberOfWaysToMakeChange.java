import java.util.*;

class NumberOfWaysToMakeChange{
  public static void main(String[] args) {
    System.out.println(numberOfWaysToMakeChange(6,new int[]{1,5}));
    System.out.println(numberOfWaysToMakeChange(9,new int[]{5}));
    System.out.println(numberOfWaysToMakeChange(4,new int[]{1,5,10,25}));
    System.out.println(numberOfWaysToMakeChange_elegent(6,new int[]{1,5}));
    System.out.println(numberOfWaysToMakeChange_elegent(9,new int[]{5}));
    System.out.println(numberOfWaysToMakeChange_elegent(4,new int[]{1,5,10,25}));
  }
  public static int numberOfWaysToMakeChange_elegent(int n, int[] denoms) {
    int len = denoms.length;
    int[] dp = new int[n+1];
    dp[0] = 1;
    for(int i = 0 ; i < len ; i++){
      for (int j = 1; j<= n ; j++ ) {
        if(j >= denoms[i]){
          dp[j] += dp[j-denoms[i]];
        }
      }
    }
    return dp[n];
  }
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int len = denoms.length;
    int[][] dp = new int[len+1][n+1];
    dp[0][0] =1;
    // for(int i =0; i <= len; i++){
    //   dp[i][0] =1;
    // }
    for(int row = 1; row <= len ; row++){
      for (int col = 1; col <= n; col++ ) {
        if(denoms[row-1] <= col){
          dp[row][col] = dp[row-1][col] + dp[row-1][col-denoms[row-1]];
        }else{
          dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[len][n];
  }
}
