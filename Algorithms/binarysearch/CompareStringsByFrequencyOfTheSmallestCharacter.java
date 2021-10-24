import java.util.Arrays;

/**
 * Created on:  Aug 17, 2020
 * Questions: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wc = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wc[i] = freq(words[i]);
        }
        Arrays.sort(wc);
        int[] op = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = freq(queries[i]);
            op[i] = search(wc, cur);
        }
        return op;
    }

    private static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) start = mid + 1;
            else end = mid;
        }
        if (start == end && arr[start] > target) return arr.length - start;
        return 0;
    }

    private static int freq(String input) {
        int[] counts = new int[26];
        for (char c : input.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int count : counts) {
            if (count > 0) return count;
        }
        return 0;
    }
}
