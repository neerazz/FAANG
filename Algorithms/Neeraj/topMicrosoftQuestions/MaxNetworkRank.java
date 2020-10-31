import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/discuss/interview-question/364760/
 * similar Question : https://leetcode.com/problems/maximal-network-rank/
 */

public class MaxNetworkRank {

    public static void main(String[] args) {

    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] hasRoad = new boolean[n][n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            hasRoad[road[0]][road[1]] = hasRoad[road[1]][road[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int val = count[i] + count[j] - (hasRoad[i][j] ? 1 : 0);
                max = Math.max(max, val);
            }
        }
        return max;
    }
}
