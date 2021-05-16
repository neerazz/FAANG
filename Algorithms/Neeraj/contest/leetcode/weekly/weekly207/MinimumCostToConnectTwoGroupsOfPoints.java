package weekly.weekly207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points
 */
public class MinimumCostToConnectTwoGroupsOfPoints {

    private static int min;

    public static void main(String[] args) {
        System.out.println(connectTwoGroups(getList(new int[][]{{15, 96}, {36, 2}})) + " = 17");
        System.out.println(connectTwoGroups(getList(new int[][]{{1, 3, 5}, {4, 1, 1}, {1, 5, 3}})) + " = 4");
        System.out.println(connectTwoGroups(getList(new int[][]{{2, 5, 1}, {3, 4, 7}, {8, 1, 2}, {6, 2, 4}, {3, 8, 8}})) + " = 10");
        System.out.println(connectTwoGroups(getList(new int[][]{{93, 56, 92}, {53, 44, 18}, {86, 44, 69}, {54, 60, 30}})) + " = 172");
    }

    public static List<List<Integer>> getList(int[][] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] num : nums) {
            result.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
        }
        return result;
    }

    public static int connectTwoGroups(List<List<Integer>> cost) {
        min = Integer.MAX_VALUE;
        int size1 = cost.size(), size2 = size1 > 0 ? cost.get(0).size() : 0;
        boolean[] connected = new boolean[size1 + size2 + 1];
        helper(0, size1, size2, 0, connected, cost);
        return min;
    }

    private static void helper(int i, int size1, int size2, int sum, boolean[] connected, List<List<Integer>> cost) {
        if (i == size1 + size2) {
            min = Math.min(min, sum);
            return;
        }
        if (sum >= min) return;
        if (i < size1) {
            connected[i] = true;
//            Loop through all the second group values and try to connect
            for (int j = size1; j < size1 + size2; j++) {
//                Always pass a new instance of the connected. So that the previously set values are not reverted back.
                boolean[] tmp = Arrays.copyOfRange(connected, 0, connected.length);
                tmp[j] = true;
                helper(i + 1, size1, size2, sum + cost.get(i).get(j - size1), tmp, cost);
            }
        } else {
//            If it is connected, then no need to connect again.
            if (connected[i]) {
                helper(i + 1, size1, size2, sum, connected, cost);
            } else {
                connected[i] = true;
//                Loop through all the first group and get the min value.
                int cur = Integer.MAX_VALUE;
                for (int j = 0; j < size1; j++) {
                    cur = Math.min(cur, cost.get(j).get(i - size1));
                }
                helper(i + 1, size1, size2, sum + cur, connected, cost);
            }
        }
    }

    public static int connectTwoGroups_greedy(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = size1 > 0 ? cost.get(0).size() : 0;
        Integer[] left = new Integer[size1], right = new Integer[size2];
        int op = 0;
        for (int i = 0; i < size1; i++) {
            int cur = Integer.MAX_VALUE, idx = 0;
            for (int j = 0; j < size2; j++) {
                if (cost.get(i).get(j) < cur) {
                    cur = cost.get(i).get(j);
                    idx = j;
                }
            }
            left[i] = cur;
            op += cur;
            right[idx] = 0;
        }
        for (int i = 0; i < size2; i++) {
            if (right[i] == null) {
                int cur = Integer.MAX_VALUE;
                for (int j = 0; j < size1; j++) {
                    cur = Math.min(cur, cost.get(j).get(i));
                }
                op += cur;
            }
        }
        return op;
    }
}
