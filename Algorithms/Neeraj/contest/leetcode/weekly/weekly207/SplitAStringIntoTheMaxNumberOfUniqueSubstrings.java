package weekly.weekly207;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    static int max;

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("ababccc") + " = 5");
        System.out.println(maxUniqueSplit("addbsd") + " = 5");
    }

    public static int maxUniqueSplit(String s) {
        max = 0;
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        recursive(0, chars, set);
        return max;
    }

    private static void recursive(int idx, char[] chars, Set<String> set) {
        if (idx >= chars.length) {
            max = Math.max(max, set.size());
        } else {
            StringBuilder sb = new StringBuilder();
            for (int end = idx; end < chars.length; end++) {
                sb.append(chars[end]);
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    recursive(end + 1, chars, set);
                    set.remove(sb.toString());
                }
            }
        }
    }

    public static int maxUniqueSplit_dp(String s) {
        char[] chars = s.toCharArray();
        Integer[] dp = new Integer[chars.length + 1];
//        return helper(0, chars, new HashSet<>(), dp);
        return 0;
    }

    public static int maxUniqueSplit_wrong(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) set.add(sb.toString());
        System.out.println(set);
        return set.size();
    }
}
