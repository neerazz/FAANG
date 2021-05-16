package biweekly.biweekly47;

import java.util.*;

/**
 * Created on:  Mar 06, 2021
 * Questions:
 */

public class SumOfBeautyOfAllSubstrings {

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }

    public static int beautySum(String s) {
        int sum = 0, len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int[] counts = new int[26];
            Set<Character> collected = new HashSet<>();
            for (int j = i; j < len; j++) {
                counts[chars[j] - 'a']++;
                collected.add(chars[j]);
                if (collected.size() > 1) {
                    int min = len, max = 0;
                    for (int count : counts) {
                        if (count == 0) continue;
                        min = Math.min(min, count);
                        max = Math.max(max, count);
                    }
                    if (min == len) continue;
                    sum += max - min;
                }
            }
        }
        return sum;
    }
}
