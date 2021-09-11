import java.util.*;

/**
 * Created on:  Jan 18, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-find-substrings
 */

public class FindSubstrings {

    public static void main(String[] args) {
//        System.out.println(findSubstrings("ba") + " = [b, a]");
//        System.out.println(findSubstrings("abab")+ " = [abab]");
//        System.out.println(findSubstrings("baddacxb") + " = [c, dd, x]");
//        System.out.println(findSubstrings("abcabc") + " = [abcabc]");
        System.out.println(findSubstrings("bacbxzecvacbxzecvb") + " = [bacbxzecvacbxzecvb]");
    }

    public static List<String> findSubstrings(String input) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            map.putIfAbsent(cur, new int[]{i, i});
            map.get(cur)[1] = i;
        }
//        Expand the ranges.
        expandRange(input, map);
        PriorityQueue<int[]> pq = new PriorityQueue<>((r1, r2) -> r1[0] == r2[0] ? Integer.compare(r2[1], r1[0]) : Integer.compare(r1[0], r2[0]));
        pq.addAll(map.values());
        List<String> result = new ArrayList<>();
        if (pq.isEmpty()) return result;
        int[] pre = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!hasOverLap(pre, cur)) {
                result.add(input.substring(pre[0], pre[1] + 1));
            }
            pre = cur;
        }
        result.add(input.substring(pre[0], pre[1] + 1));
        return result;
    }

    private static void expandRange(String input, Map<Character, int[]> map) {
        char cur = 'a';
        for (int i = 0; i < 26; i++) {
            int[] range = map.get(cur);
            if (range != null) {
                for (int j = range[0]; j <= range[1]; j++) {
                    int[] range2 = map.get(input.charAt(j));
                    range[0] = Math.min(range[0], range2[0]);
                    range[1] = Math.max(range[1], range2[1]);
                }
            }
            cur++;
        }
    }

    private static boolean hasOverLap(int[] a, int[] b) {
//        return b[0] <= a[1];
        return Math.max(a[0], b[0]) <= Math.min(a[1], b[1]);
    }

    private static void expandRange(Map<Character, int[]> map, Character key) {
        int[] range = map.get(key);
        char cur = 'a';
        for (int i = 0; i < 26; i++) {
            if (cur != key) {
                int[] range2 = map.get(cur);
                if (range2 != null && inRange(range, range2)) {
                    range[0] = Math.min(range[0], range2[0]);
                    range[1] = Math.max(range[1], range2[1]);
                }
            }
            cur++;
        }
    }

    private static boolean inRange(int[] range, int[] range2) {
        return (range[0] <= range2[0] && range2[0] <= range[1]) || (range[0] <= range2[1] && range2[1] <= range[1]);
    }
}
