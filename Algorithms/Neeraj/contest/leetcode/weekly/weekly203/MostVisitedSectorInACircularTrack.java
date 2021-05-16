package weekly.weekly203;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/most-visited-sector-in-a-circular-track
 */
public class MostVisitedSectorInACircularTrack {
    public static void main(String[] args) {
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(mostVisited(7, new int[]{1, 3, 5, 7}));
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> op = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (end < start) {
            for (int i = 1; i <= end; i++) {
                op.add(i);
            }
            for (int i = start; i <= n; i++) {
                op.add(i);
            }
        } else {
            for (int i = start; i <= end; i++) {
                op.add(i);
            }
        }
        return op;
    }
}
