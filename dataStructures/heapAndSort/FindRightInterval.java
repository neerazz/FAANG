import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on:  Aug 27, 2020
 * Questions: https://leetcode.com/problems/find-right-interval/
 */
public class FindRightInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1, 2}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1, 2}, {2, 3}, {0, 1}, {3, 4}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] result = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(intervals[i][1]);
            if (ceiling != null) {
                result[i] = ceiling.getValue();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
