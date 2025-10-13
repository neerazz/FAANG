import java.util.ArrayList;

/**
 * Created on:  Sep 11, 2021
 * Ref: https://www.codingninjas.com/codestudio/problems/maximum-distance_1170523?topList=top-google-coding-interview-questions&leftPanelTab=0
 */
public class MaximumDistance {
    public static void main(String[] args) {

    }

    public static int maxDiff_optimal(ArrayList<Integer> a, int n) {
        int len = a.size();
        int[] right = new int[len];
        int max = a.get(len - 1);
        for (int i = len - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, a.get(i));
        }
        int i = 0, j = 0;
        max = 0;
        while (i < len && j < len) {
//            If there is a number in right that is greater than the current number:
//              then increase the slide right pointer.
            if (a.get(i) <= right[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }

    public static int maxDiff(ArrayList<Integer> a, int n) {
        int len = a.size();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (a.get(i) <= a.get(j)) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }
        return max;
    }
}
