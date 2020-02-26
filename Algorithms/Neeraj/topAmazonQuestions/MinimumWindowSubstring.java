import java.util.*;

class MinimumWindowSubstring{
  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC","ABC"));
  }

  public static String minWindow(String s, String t) {
    if(s == null || t == null || t.length() == 0 || s.length() ==0 || s.length() < t.length()) return "";
    Map<Character, Integer> tMap = new HashMap<>();
    int tL = t.length();
    for(int i = 0 ; i < tL ; i++){
        tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
    }

    int found = 0, start = 0, end = 0, uniqueTs = tMap.size();
    int[] output = new int[]{-1,0,0};
    Map<Character, Integer> loop = new HashMap<>();
    while(end < s.length()){
        char cur = s.charAt(end);
        loop.put(cur,loop.getOrDefault(cur,0)+1);
        if(tMap.containsKey(cur) && tMap.get(cur).equals(loop.get(cur))){
            found++;
        }
        while(start <= end && found == uniqueTs){
            if(output[0] == -1 || output[0] > end-start+1){
                output[0] = end-start+1;
                output[1] = start;
                output[2] = end;
            }
            char curS = s.charAt(start);
            loop.put(curS, loop.getOrDefault(curS,0)-1);
            if(tMap.containsKey(curS) && tMap.get(curS) > loop.get(curS)){
                found--;
            }
            start++;
        }
        end++;
    }
    return output[0] == -1 ? "" : s.substring(output[1],output[2]+1);
  }
  public static String minWindow_naive(String s, String t) {
    if(s == null || t == null || t.length() == 0 || s.length() ==0) return "";
    int start = 0, end = t.length()-1, counter = Integer.MAX_VALUE;
    String op = "";

    while(end < s.length()){
        while(containsAllTs(t, s.substring(start,end+1))){
            if(end-start+1 < counter){
                op = s.substring(start,end+1);
                counter = end-start +1;
            }
            start++;
        }
        end++;
    }
    return op;
}
private static boolean containsAllTs(String t , String check){
    List<Character> tChars = new ArrayList<>();
    for(char c: check.toCharArray()){
        tChars.add(c);
    }
    for(char c: t.toCharArray()){
        if(tChars.contains(c)){
            tChars.remove((Character)c);
        }else{
            return false;
        }
    }
    return true;
  }
}
