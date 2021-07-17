

/**
 * Created on:  Jun 23, 2021
 * Ref: https://leetcode.com/problems/maximal-network-rank/
 */

public class MaximalNetworkRank {

    public static void main(String[] args) {

    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] hasRoad = new boolean[n][n];
        int[] counts = new int[n];
        int max = 0;
        for (int[] road : roads) {
            hasRoad[road[0]][road[1]] = hasRoad[road[1]][road[0]] = true;
            counts[road[0]]++;
            counts[road[1]]++;
        }
        for (int r1 = 0; r1 < n; r1++) {
            for (int r2 = 0; r2 < n; r2++) {
                if (r1 == r2) continue;
//                Lop though each pair of roads and find the counts, and then reduce if any by one if any roard connects to both r1, and r2.
                int cur = counts[r1] + counts[r2];
                if (hasRoad[r1][r2]) cur--;
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
