package weekly.weekly221;

import java.util.*;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class MaximumXORWithAnElementFromArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}})));
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            Integer max = null;
            int[] query = queries[i];
            for (int num : nums) {
                if (num > query[1]) break;
                int cur = query[0] ^ num;
//                if (max != null && max > cur) break;
                max = max == null ? cur : Math.max(max, cur);
            }
            result[i] = max == null ? -1 : max;
        }
        return result;
    }
}
