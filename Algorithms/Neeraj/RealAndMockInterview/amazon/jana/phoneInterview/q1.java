import java.util.*;

/**
 * Created on:  Aug 23, 2020
 * Questions:
 */
public class q1 {
    public static void main(String[] args) {
        System.out.println(getString("aaaaaaaa", 2));
        System.out.println(getString("democracy", 5));
        System.out.println(getString("abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd", 5));
        System.out.println(getString("wawaglknagagwunagkwkwagl", 4));
        System.out.println(getString("bawagla", 4));
        System.out.println(getString("abcdbedfgghijklmlnoopqrtst", 4));
        System.out.println(getString("awaglk", 4));
        System.out.println(getString("awagla", 4));
        System.out.println(getString("awa", 3));
        System.out.println(getString("lqjinczgly", 8));
        System.out.println(getString("qdpjoaofqq", 8));
    }

    private static List<String> getString(String inputStr, int num) {
        int[] counts = new int[26];
        Set<String> result = new HashSet<>();
        int left = 0, right = 0, dupSize = 0, len = inputStr.length();
        if (len < num || num > 27) return new ArrayList<>(result);
        while (right < len) {
            char cur = inputStr.charAt(right++);
            if (counts[cur - 'a'] > 0) {
                dupSize++;
            }
            counts[cur - 'a']++;
            if (right - left == num) {
                if (dupSize == 1) {
                    result.add(inputStr.substring(left, right));
                }
//                More number of duplicates encountered, reduce the left pointer.
                cur = inputStr.charAt(left++);
//                Reduce the duplicate only if the counts of that char is greater then 1.
                if (counts[cur - 'a']-- > 1) dupSize--;
            }
        }
        List<String> output = new ArrayList<>(result);
        Collections.sort(output);
        return output;
    }
}
