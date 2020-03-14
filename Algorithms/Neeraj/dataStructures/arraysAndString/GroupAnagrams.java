import java.util.*;

class GroupAnagrams{
  public static void main(String[] args) {

  }
  public static List<List<String>> groupAnagrams(List<String> words) {
    Map<String,List<String>> map = new HashMap<>();
    for(String word: words){
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sorted = new StringBuilder().append(chars).toString();
      List<String> values = map.getOrDefault(sorted,new ArrayList<>());
      values.add(word);
      map.put(sorted,values);
    }
    return new ArrayList<>(map.values());
  }
}
