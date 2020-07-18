import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        int[] pre = intervals[0];
        List<int[]> op = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            int os = Math.max(pre[0], cur[0]), oe = Math.min(pre[1], cur[1]);
            if (os <= oe) {
//                 There is a overlap, extend previous
                pre[1] = cur[1];
            } else {
//                 No overlap
                op.add(pre);
                pre = cur;
            }
        }
        op.add(pre);
        return op.toArray(new int[0][0]);
    }
}
