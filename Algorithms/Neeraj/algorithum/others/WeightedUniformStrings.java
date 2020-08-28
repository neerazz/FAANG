

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
https://www.hackerrank.com/challenges/weighted-uniform-string/problem

 */
public class WeightedUniformStrings {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(weightedUniformStrings("abccddde", new int[]{6, 1, 3, 12, 5, 9, 10})));
        System.out.println(Arrays.toString(weightedUniformStrings("aaabbbbcccddd", new int[]{5, 9, 7, 8, 12, 5})));
    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        s = s + "\0";
        int[] char_num = new int[27];
        int local_len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                int index = s.charAt(i - 1) - 'a' + 1;
                char_num[index] = Math.max(char_num[index], local_len);
                local_len = 1;
            } else local_len++;
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean flag = false;
            int j = 1;
            while (j < char_num.length) {
                if (char_num[j] > 0 && queries[i] % j == 0 && queries[i] / j <= char_num[j]) {
                    ans[i] = "Yes";
                    flag = true;
                    break;
                }
                j++;
            }
            if (!flag) ans[i] = "No";
        }
        return ans;
    }

    static String[] weightedUniformStrings1(String s, int[] queries) {
//        Take all characters and its weight in a hash map.
        HashMap<Character, Integer> characters = new HashMap<>();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characters.put(chars[i], i + 1);
        }
//        Keep all possible weights in an set.
        HashSet<Integer> integers = new HashSet<>();
        char prev = ' ';
        int prevWeight = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (prev != ' ') {
                if (prev != cur) {
                    integers.add(characters.get(cur));
                    prev = cur;
                    prevWeight = 0;
                }
            }
            prev = cur;
            prevWeight += characters.get(cur);
            integers.add(prevWeight);
        }

//        Loop through the queries. And find in integers. If found return "YES", else "NO".
        String[] output = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = integers.contains(queries[i]) ? "YES" : "NO";
        }
        return output;
    }
}
