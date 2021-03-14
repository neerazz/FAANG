import java.util.*;

class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak_rev2("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreak_rev2("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreak("ab", Arrays.asList("a", "b")));
        System.out.println(wordBreak_rev2("ab", Arrays.asList("a", "b")));
        System.out.println(wordBreak("a", Arrays.asList("b")));
        System.out.println(wordBreak_rev2("a", Arrays.asList("b")));
    }

    static Map<String, List<String>> memo_2 = new HashMap<>();

    public static List<String> wordBreak_rev2(String s, List<String> wordDict) {
        return helper_2(s, new HashSet<>(wordDict));
    }

    private static List<String> helper_2(String s, Set<String> set) {
        if (s.length() == 0) {
            return Collections.singletonList("");
        }
        if (memo_2.containsKey(s)) return memo_2.get(s);
        List<String> op = new ArrayList<>();
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            cur += s.charAt(i);
            if (set.contains(cur)) {
                List<String> temp = helper_2(s.substring(i + 1), set);
                for (String next : temp) {
                    op.add(next.length() > 0 ? cur + " " + next : cur);
                }
            }
        }
        memo_2.put(s, op);
        return op;
    }

    static Map<Integer, List<String>> memo;

    public static List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        if (s != null) {
            return helper(s, new HashSet<>(wordDict), 0);
        }
        return new ArrayList<>();
    }

    private static List<String> helper(String input, Set<String> dict, int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        List<String> result = new ArrayList<>();
        if (input.length() == 0) {
            result.add(" ");
            return result;
        }
        for (int i = 1; i <= input.length(); i++) {
            String cur = input.substring(0, i);
            if (dict.contains(cur)) {
                List<String> temp = helper(input.substring(i), dict, start + i);
                // System.out.println("cur = " + cur + " temp = " + temp);
                // For all the possibilities, append the cur and add to the possible result.
                for (String s : temp) {
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
