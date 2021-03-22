import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 22, 2021
 * Questions: https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 */

public class FindSmallestCommonElementInAllRows {

    public static void main(String[] args) {

    }

    public static int smallestCommonElement(int[][] mat) {
        int len = mat.length;
        if (len == 0) return -1;
        List<Integer> nums = new ArrayList<>();
        for (int num : mat[0]) {
            nums.add(num);
        }
        for (int i = 1; i < len; i++) {
            int j = 0, k = 0;
            List<Integer> level = new ArrayList<>();
            while (k < mat[i].length && j < nums.size()) {
                if (nums.get(j) == mat[i][k]) {
                    level.add(nums.get(j++));
                    k++;
                } else if (nums.get(j) < mat[i][k]) {
                    j++;
                } else {
                    k++;
                }
            }
            nums = new ArrayList<>(level);
            if (nums.isEmpty()) return -1;
        }
        return nums.isEmpty() ? -1 : nums.get(0);
    }
}
