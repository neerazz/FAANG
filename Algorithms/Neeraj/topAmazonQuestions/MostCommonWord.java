package topAmazonQuestions;

import java.util.*;

class MostCommonWord{
  public static void main(String[] args) {
    System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
    System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",new String[]{"a"}));
    System.out.println(mostCommonWord("bob",new String[]{}));
  }

  public static String mostCommonWord(String paragraph, String[] banned) {
    if(paragraph == null || paragraph.length() == 0) return "";
    Set<String> ban = new HashSet<>();
    for(String s: banned){
        ban.add(s);
    }
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    String op = "";
    map.put(op,0);
    for(char c : paragraph.toCharArray()){
      if(Character.isLetter(c)){
        sb.append(Character.toLowerCase(c));
      } else if(sb.length() > 0){
        String newString = sb.toString();
        if(!ban.contains(newString)){
          map.put(newString, map.getOrDefault(newString,0)+1);
          if(map.get(op) < map.get(newString)){
            op = newString;
          }
        }
        sb = new StringBuilder();
      }
    }
    String newString = sb.toString();
    map.put(newString, map.getOrDefault(newString,0)+1);
    if(map.get(op) < map.get(newString)){
      op = newString;
    }
    // System.out.println(map);
    return op;
  }

  public static String mostCommonWord_wrong(String paragraph, String[] banned) {
    if(paragraph == null || paragraph.length() == 0) return "";
    Set<String> ban = new HashSet<>();
    for(String s: banned){
        ban.add(s);
    }
    Map<String, Integer> map = new HashMap<>();
    for(String s : paragraph.split(" ")){
        String stripped = s.replaceAll("[!?',;.]","").toLowerCase();
        if(!ban.contains(stripped)){
            map.put(stripped, map.getOrDefault(stripped,0)+1);
        }
    }
    System.out.println(map);
    return map.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).map(e -> e.getKey()).findFirst().orElse("");
  }
}
