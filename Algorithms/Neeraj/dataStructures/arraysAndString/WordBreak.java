import java.util.*;

class WordBreak{
  public static void main(String[] args) {
    System.out.println(wordBreak("bb",new ArrayList<>(Arrays.asList(
            "a","b","bbb","bbbb"
    ))));
    System.out.println(wordBreak("cbca",new ArrayList<>(Arrays.asList(
            "bc","ca"
    ))));
  }
  public static boolean wordBreak(String s, List<String> wordDict) {
      if(s == null || s.length() ==0) return true;
      return helper(s,new HashSet<>(wordDict),0, new Boolean[s.length()]);
  }

  private static boolean helper(String s, HashSet<String> set, int start, Boolean[] memo) {
      if(start == s.length()) return true;
      if(memo[start] != null){
          return memo[start];
      }
      for(int end = start+1; end <= s.length(); end++){
          if(set.contains(s.substring(start,end)) && helper(s,set,end,memo)){
              return memo[start] = true;
          }
      }
      return memo[start] = false;
  }
}
