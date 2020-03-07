import java.util.*;

class NumberOfCoins{
  public static void main(String[] args) {
    System.out.println(minNumberOfCoinsForChange(4,new int[]{1,5,10}));
    System.out.println(minNumberOfCoinsForChange(7,new int[]{1,5,10}));
    System.out.println(minNumberOfCoinsForChange(15,new int[]{1,5,10}));
    System.out.println(minNumberOfCoinsForChange(7,new int[]{2,4}));
  }
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int len = denoms.length;
    if(len == 0) return -1;
    int[] dp = new int[n+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    dp[0] = 0;
		Arrays.sort(denoms);
		for(int i = 1;i<=len ; i++){
      System.out.println(Arrays.toString(dp));
			for(int j = 1; j <= n; j++){
				if(j >= denoms[i-1]){
					int cur = dp[j-denoms[i-1]] == Integer.MAX_VALUE ? dp[j-denoms[i-1]] : dp[j-denoms[i-1]] +1;
					dp[j] = Math.min(cur, dp[j]);
				}
			}
		}
    return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
  }
}
