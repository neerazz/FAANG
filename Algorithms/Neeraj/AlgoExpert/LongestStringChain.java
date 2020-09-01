import java.util.*;

/**
 * Created on:  Aug 29, 2020
 * Questions: https://www.algoexpert.io/questions/Longest%20String%20Chain
 */
public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStringChain(Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef")));
        System.out.println(longestStringChain(Arrays.asList("abcdefg1",
                "1234c",
                "abdefg2",
                "abdfg",
                "123",
                "122",
                "bgg",
                "g",
                "1a2345",
                "12a345")));
    }

    public static List<String> longestStringChain(List<String> strings) {
        List<String> result = new ArrayList<>();
        strings.sort((s1, s2) -> s2.length() - s1.length());
        Set<String> set = new HashSet<>(strings);
        Map<String, LinkedList<String>> memo = new HashMap<>();
        for (String str : strings) {
            helper(str, set, memo);
        }
        for (Map.Entry<String, LinkedList<String>> entry : memo.entrySet()) {
            if (entry.getValue().size() > 0 && result.size() < entry.getValue().size() + 1) {
                result.clear();
                result.add(entry.getKey());
                result.addAll(entry.getValue());
            }
        }
        System.out.println("memo = " + memo);
        return result;
    }

    private static LinkedList<String> helper(String str, Set<String> set, Map<String, LinkedList<String>> memo) {
        if (memo.containsKey(str)) return memo.get(str);
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(0, i) + str.substring(i + 1);
            if (set.contains(cur)) {
                LinkedList<String> curRes = helper(cur, set, memo);
                if (result.size() < curRes.size() + 1) {
                    result.clear();
                    result.add(cur);
                    result.addAll(curRes);
                }
            }
        }
        memo.put(str, result);
        return result;
    }
}
