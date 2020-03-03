import java.util.*;

class UniquePaths{
  public static void main(String[] args) {

  }
  // Solution: https://www.youtube.com/watch?v=GO5QHC_BmvM
  public int uniquePaths(int cols, int rows) {
    int[][] dp = new int[rows][cols];
    Arrays.fill(dp[0],1);
    for(int i = 1; i < rows ; i++){
        dp[i][0] = 1;
    }
    for(int row = 1; row < rows ; row++){
        for(int col = 1; col < cols; col++){
            dp[row][col] = dp[row-1][col] + dp[row][col-1];
        }
    }
    // System.out.println(Arrays.deepToString(dp));
    return dp[rows-1][cols-1];
  }
}
