import java.util.*;

public class LongestPalindromicSubstring{
  public static void main(String[] arg){
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("a"));
    System.out.println(longestPalindrome("bb"));
  }

  public static String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    String reverse = new StringBuilder(s).reverse().toString();

    int max = 0, p1 = 0, p2 = 0;
    String output = "";
    for(int i = 0; i < s.length() ; i++){
      if (s.charAt(i) == reverse.charAt(i)) {
        p2++;
      }else{
        if (max < (p2-p1+1)) {
          output = s.substring(p1,p2+1);
        }
        p1 = i+1;
      }
    }
    if(p1 < p2){
      output = s.substring(p1,p2);
    }
    return output;
  }
}
