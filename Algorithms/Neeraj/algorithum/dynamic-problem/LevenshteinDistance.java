import java.util.*;

class LevenshteinDistance{
  public static void main(String[] args) {
    System.out.println(levenshteinDistance("abc","abx"));
  }
  public static int levenshteinDistance(String str1, String str2) {
		if(str1 == null && str2 == null) return 0;
		if(str1 == null) return str2.length();
		if(str2 == null) return str1.length();
		if(str1.equals(str2)) return 0;
    int l1 = str1.length(), l2 = str2.length();
		int[][] dp = new int[l1+1][l2+1];
		for(int i = 1;i<= l1 ; i++){
			dp[i][0] = i;
		}
		for(int i = 1;i<= l2 ; i++){
			dp[0][i] = i;
		}
		for(int i = 1; i <= l1 ; i++){
			for(int j = 1; j<= l2 ; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) +1;
				}
			}
		}
    return dp[l1][l2];
  }
}
