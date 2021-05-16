package biweekly.biweekly39;

import java.util.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/contest/biweekly-contest-39/problems/minimum-jumps-to-reach-home/
 */

public class MinimumJumpsToReachHome {

    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
        System.out.println(minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98},
                29, 98, 80));
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = 4000, level = 0;
        Set<String> visited = new HashSet<>();
//        Mark all the forbidden as visited
        for (int cur : forbidden) {
            visited.add(cur + "0");
            visited.add(cur + "-1");
        }
        visited.add(0 + "0");
        Queue<int[]> queue = new LinkedList<>();
//        0:step, 1:continues back
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == x) return level;
//                Check if you can go forward
                if (cur[0] + a <= max && visited.add(cur[0] + a + "0")) queue.add(new int[]{cur[0] + a, 0});
                if (cur[0] - b > 0 && cur[1] == 0 && visited.add(cur[0] - b + "-1"))
                    queue.add(new int[]{cur[0] - b, -1});
            }
            level++;
        }
        return -1;
    }
}
