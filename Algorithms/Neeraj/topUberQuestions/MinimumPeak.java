import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 06, 2020
 * Questions: https://leetcode.com/discuss/interview-question/908341/Uber-OA-or-Oct-2020
 * https://www.geeksforgeeks.org/minimum-peak-elements-from-an-array-by-their-repeated-removal-at-every-iteration-of-the-array/
 */

public class MinimumPeak {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minPeak(new int[]{1, 9, 7, 8, 2, 6})) + " Should be [6, 8, 9, 7, 2, 1]");
        System.out.println(Arrays.toString(minPeak(new int[]{1, 5, 3, 7, 2})) + " Should be [5, 7, 3, 2, 1]");
    }

    private static int[] minPeak(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int[] result = new int[nums.length];
        int idx = 0, remove = 0;
        while (remove < nums.length) {
            int peek = Integer.MAX_VALUE, peekIdx = -1;
            int len = list.size();
            for (int i = 0; i < len; i++) {
                if (i == 0 && i + 1 < len) {
//                Processing first element
                    if (list.get(i) > list.get(i + 1) && peek > list.get(i)) {
                        peek = list.get(i);
                        peekIdx = i;
                    }
                } else if (i == len - 1 && i > 0) {
//                Processing last element
                    if (list.get(i) > list.get(i - 1) && peek > list.get(i)) {
                        peek = list.get(i);
                        peekIdx = i;
                    }
                } else if (len == 1) {
//                    Then only one element is present
                    peek = list.get(i);
                    peekIdx = 0;
                } else {
//                    This element is in center
                    if (list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1) && peek > list.get(i)) {
                        peek = list.get(i);
                        peekIdx = i;
                    }
                }
            }
//            Remove the peek element from the list and add it to the result
            list.remove(peekIdx);
            result[idx++] = peek;
            remove++;
        }
        return result;
    }
}
