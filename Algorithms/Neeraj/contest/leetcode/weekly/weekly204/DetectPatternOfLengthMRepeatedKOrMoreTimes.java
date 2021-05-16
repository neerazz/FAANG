package weekly.weekly204;

/**
 * Created on:  Aug 29, 2020
 * Questions: https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public static void main(String[] args) {
        System.out.println(containsPattern(new int[]{2, 2}, 1, 2));
        System.out.println(containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        System.out.println(containsPattern(new int[]{1, 2, 1, 2, 4, 4}, 2, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) return false;
        for (int i = 0; i < arr.length; i++) {
            label:
            if (i < arr.length - m * k + 1) {
                int round = 1;
                while (round < k) {
                    int idx = 0;
                    while (idx < m) {
                        if (arr[i + idx] == arr[(round * m) + i + idx]) idx++;
                        else break label;
                    }
                    round++;
                }
                if (round == k) return true;
            }
        }
        return false;
    }
}
