import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 18, 2021
 * Questions: https://aonecode.com/amazon-interview-questions/rearrange-string-k-distance-apart
 */

public class RearrangeString {

    public static void main(String[] args) {
//        System.out.println(rearrangeString("aabb", 2));
//        System.out.println(rearrangeString("aaaa", 2));
//        System.out.println(rearrangeString("aaabbbc", 3));
//        System.out.println(rearrangeString("akaka", 2));
        System.out.println(rearrangeString("aaaaa", 0));
        System.out.println(rearrangeString("a b c d e ", 2));
    }

    public static String rearrangeString(String str, int k) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int max = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
//            if(c == ' ') continue;
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            max = Math.max(count, max);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v2[0] == v1[0] ? Integer.compare(v1[2], v2[2]) : Integer.compare(v2[0], v1[0]));
//        0: count, 1 : char, 2: next
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey(), 0});
        }
        Map<Integer, int[]> processed = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (processed.containsKey(i)) {
                pq.add(processed.remove(i));
            }
            if (pq.isEmpty()) return "";
            int[] cur = pq.poll();
            if (cur[2] > i) return "";
            chars[i] = (char) cur[1];
            if (cur[0] > 1) {
                processed.put(i + Math.max(k, 1), new int[]{cur[0] - 1, cur[1], i + Math.max(k, 1)});
            }
        }
        return pq.isEmpty() ? String.valueOf(chars) : "";
    }
}
