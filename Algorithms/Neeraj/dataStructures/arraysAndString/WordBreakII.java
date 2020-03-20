import java.util.*;

class WordBreakII{
  public static void main(String[] args) {
    System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
  }

  static Map<Integer, List<String>> memo;
  public static List<String> wordBreak(String s, List<String> wordDict) {
      memo = new HashMap<>();
      if(s != null){
          return helper(s,new HashSet<>(wordDict),0);
      }
      return new ArrayList<>();
  }
  private static List<String> helper(String input, Set<String> dict, int start){
    if(memo.containsKey(start)){
      return memo.get(start);
    }
    List<String> result = new ArrayList<>();
    if(input.length() == 0){
      result.add(" ");
      return result;
    }
    for(int i = 1; i <= input.length(); i++){
      String cur = input.substring(0,i);
      if(dict.contains(cur)){
        List<String> temp = helper(input.substring(i),dict,start+i);
        // System.out.println("cur = " + cur + " temp = " + temp);
        // For all the possibilities, append the cur and add to the possible result.
        for (String s: temp) {
          // If the value is empty, then only add the cur value,
          // Else add a space and then the value.
          String tempString = cur + (s.equals(" ") ? "" : " " + s);
          result.add(tempString);
        }
      }
    }
    memo.put(start, result);
    // System.out.println("start =" + start + " result =" + result);
    // System.out.println(memo);
    return result;
  }
}
