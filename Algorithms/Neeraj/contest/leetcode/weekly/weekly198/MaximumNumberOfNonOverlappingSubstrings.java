package weekly.weekly198;

import java.util.*;

/**
 * Created on:  Jul 18, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 * Maximum Number of Non-Overlapping Substrings
 */
public class MaximumNumberOfNonOverlappingSubstrings {
    public static void main(String[] args) {
        System.out.println(maxNumOfSubstrings("adefaddaccc"));
        System.out.println(maxNumOfSubstrings("abbaccd"));
        System.out.println(maxNumOfSubstrings("abab") + " should be [\"abab\"]");
    }

    public static List<String> maxNumOfSubstrings(String s) {
        Map<Character, int[]> map = new LinkedHashMap<>();
        int len = s.length();
        char[] chars = s.toCharArray();
//        Get range of each character
        for (int i = 0; i < len; i++) {
            char cur = chars[i];
            if (map.containsKey(cur)) {
                map.get(cur)[1] = i;
            } else {
                map.put(cur, new int[]{i, i});
            }
        }
//        Extend the character range
        for (int[] value : map.values()) {
            getNewRanges(chars, value, map);
        }
//        Collect the sub-array ranges.
        Stack<int[]> stack = new Stack<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] cur = entry.getValue();
            if (stack.isEmpty() || stack.peek()[1] < cur[0]) {
//                If the stack is empty or if the top element end point is less than the current start.
                stack.add(cur);
            } else if (stack.peek()[1] >= cur[1]) {
//                If the current element is ending before the top stack element ending range.
//                Ex: pre range is {2,4}, ie ada, and cur is {3,3} ie, d.
//                Then remove the pre element as that subarray is larger in size.
                stack.pop();
                stack.add(cur);
            }
        }
        List<String> op = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            op.add(s.substring(pop[0], pop[1] + 1));
        }
        return op;
    }

    private static void getNewRanges(char[] chars, int[] cur, Map<Character, int[]> map) {
        int start = cur[0], end = cur[1];
        for (int i = start; i < end; i++) {
//            For every item in between the ranges, check if the end needs to be expanded.
            end = Math.max(end, map.get(chars[i])[1]);
            start = Math.min(start, map.get(chars[i])[0]);
        }
        cur[0] = start;
        cur[1] = end;
    }
}
