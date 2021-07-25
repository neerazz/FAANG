package biweekly.biweekly57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-57/problems/describe-the-painting/
 */
public class DescribeThePainting {

    public static void main(String[] args) {
        System.out.println(splitPainting_wrong(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));
    }

    public static List<List<Long>> splitPainting_wrong(int[][] segments) {
        int max = 1_00_001;
        long[] line = new long[max];
        TreeSet<Integer> breakPoint = new TreeSet<>();
        for (int[] seg : segments) {
            int start = seg[0], end = seg[1];
            line[start] += seg[2];
            line[end] -= seg[2];
            breakPoint.add(start);
            breakPoint.add(end);
        }
//         find cumulative sum
        long sum = 0;
        for (int i = 1; i < max - 1; i++) {
            sum += line[i];
            line[i] = sum;
        }
        List<List<Long>> result = new ArrayList<>();
        int pre = breakPoint.first();
        breakPoint.remove(pre);
        for (int cur : breakPoint) {
            if (line[pre] != 0) {
                result.add(Arrays.asList(pre * 1L, cur * 1L, line[pre]));
            }
            pre = cur;
        }
        return result;
    }
}
