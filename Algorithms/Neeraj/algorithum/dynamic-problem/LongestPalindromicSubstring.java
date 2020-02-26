import java.util.*;

public class LongestPalindromicSubstring{
  public static void main(String[] arg){

      System.out.println(longestPalindrome_dp_consecutive_character("babad"));
      System.out.println(longestPalindrome_dp_consecutive_character("cbbd"));
      System.out.println(longestPalindrome_dp_consecutive_character("a"));
      System.out.println(longestPalindrome_dp_consecutive_character("bb"));
  }

  public static int longestPalindrome_dp_len(String s) {
      int size = s.length();
      int[][] dp = new int[size][size];

//        Set the values at size 1 as 1. Because one is a palindrome.
      for(int len = 1; len <= size; len++){
          for(int row = 0; row + len <= size; row++){
              int col = row + len-1;
              if(row ==col) {
                  dp[row][col] = 1;
              }else if(s.charAt(col) == s.charAt(row)){
                  dp[row][col] = dp[row+1][col-1] + 2;
              }else{
                  dp[row][col] = Math.max(dp[row][col-1],dp[row+1][col]);
              }
          }
      }
      return dp[0][size-1];
  }

  public static String longestPalindrome_naive(String s) {
      if(s.length() <1) return "";
      HashSet<String> set = new HashSet<>();
      int len = s.length();
      for(int i = 0; i < len ; i++){
          for(int j = i; j < len ; j++){
              set.add(s.substring(i,j+1));
          }
      }
      List<String> collect = set.stream().filter(val -> new StringBuilder(val).reverse().toString().equals(val)).sorted((v1, v2) -> v2.length() - v1.length()).collect(Collectors.toList());
      System.out.println(collect);
      return collect.get(0);
  }

  public static String longestPalindrome_dp_consecutive_character(String s) {
      int len = s.length();
      boolean[][] dp = new boolean[len][len];
      String result = "";
      for(int l = 0 ; l < len ; l++){
//            Loop only one half of the matrix.
          for(int row = 0; row+l < len ; row++){
//                We have decided to loop only the upper half.
              int col = row + l;
              if(s.charAt(row) == s.charAt(col)){
//                    Here we are checking
//                    if length is 0 (one char), set to true.
//                    If len is one (two char) and both are same then set true.
//                    If len is greater then 1 then take the adjacent value (next row & pre col).
                  dp[row][col] = l <= 1 ? true : dp[row+1][col-1];
              }

//                If the current value is true and
//                the previous len less than the current length.
//                populate the new result.
              if(dp[row][col] && result.length() <= l){
//                    Take the value from the cur row till the col. So it should be col+1, if you need value till col.
                  result = s.substring(row,col+1);
              }
          }
      }
      return result;
  }

  public static String longestPalindrome_dp_any_character(String s) {
      int size = s.length();
      int[][] dp = new int[size+1][size+1];
      String reverse = new StringBuilder(s).reverse().toString();

//        Set the values at size 1 as 1. Because one is a palindrome.
      for(int row = 0; row <= size ; row++){
          for(int col = 0; col <= size ; col++){
              if(row == 0 || col == 0){
                  dp[row][col] = 0;
              }else if(s.charAt(row-1) == reverse.charAt(col-1)){
                  dp[row][col] = dp[row-1][col-1] +1;
              }else{
                  dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);
              }
          }
      }
      System.out.println(Arrays.deepToString(dp));
      int length = dp[size][size];
//        All the values are now filled. Now get the largest string from the dp array.
//        Take the reverse string, and compare with the original string.
//        If same then go down adjacently,
//        if not then so to the side that has larger value.
      StringBuilder sb = new StringBuilder();
      int i1 = size, i2 = size;
      while(i1 > 0 && i2 > 0){
          if(s.charAt(i1-1) == reverse.charAt(i2-1)){
              sb.append(s.charAt(i1-1));
              i2--;
              i1--;
              length--;
          }else if(dp[i1-1][i2] > dp[i1][i2-1]){
              i1--;
          }else{
              i2--;
          }
      }
      return sb.toString();
  }

  static Set<String> strings;
  public static String longestPalindrome_expanding_sides(String s) {
      int start =0, end =0;
      for (int i =0 ; i < s.length() ; i++) {
          int len1 = expandSides(s,i,i);
          int len2 = expandSides(s,i,i+1);
          int len = Math.max(len1,len2);
          if(start- end < len){
              start = i - (len-1)/2;
              end = i + len /2 ;
          }
      }
      return s.substring(start,end);
  }
  public static int expandSides(String s, int l,int r) {
      while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
          l--;
          r++;
      }
      return r-l-1;
  }
}
