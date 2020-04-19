import java.util.*;

class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("bb", new ArrayList<>(Arrays.asList(
                "a", "b", "bbb", "bbbb"
        ))));
        System.out.println(wordBreak("cbca", new ArrayList<>(Arrays.asList(
                "bc", "ca"
        ))));
    }

    public boolean wordBreak_rev1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper_2(s,set);
    }
    Map<String, Boolean> memo = new HashMap<>();
    private boolean helper_2(String s, Set<String> set){
        if(s.length() == 0 || set.contains(s)) return true;
        if(memo.containsKey(s)) return memo.get(s);
        String cur = "";
        boolean op = false;
        for(int i =0; i< s.length(); i++){
            cur += s.charAt(i);
            if(set.contains(cur) && helper_2(s.substring(i+1), set)){
                op = true;
                break;
            }
        }
        memo.put(s,op);
        return op;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean helper(String s, HashSet<String> set, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && helper(s, set, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
