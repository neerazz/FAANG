package contest1472;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 28, 2021
 * Questions:
 */

public class CorrectPlacement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] h = new int[n], w = new int[n];
            for (int j = 0; j < n; j++) {
                h[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }
            int[] result = getPrevPositions(n, h, w);
            System.out.println(Arrays.stream(result).boxed().map(val -> "" + val).collect(Collectors.joining(" ")));
        }
    }

    private static int[] getPrevPositions(int n, int[] h, int[] w) {
        int[] result = new int[n];
        int[][] dp = new int[n][3];
//        0: min(h,w), 1: max(h,w), 2: idx
        for (int i = 0; i < n; i++) {
            int min = Math.min(h[i], w[i]), max = Math.max(h[i], w[i]);
            dp[i] = new int[]{min, max, i + 1};
            Arrays.sort(dp[i], 0, 2);
        }
        Arrays.sort(dp, (v1, v2) -> Integer.compare(v1[1], v2[1]));
        Queue<int[]> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int min = dp[i][0], max = dp[i][1], idx = dp[i][2];
            while (!queue.isEmpty() && queue.peek()[1] < max) {
//                Copy all the people and sort, if the max is less then cur max.
                int[] poll = queue.poll();
//                Add to the queue with min value and idx
                map.put(poll[0], poll[2]);
            }
//            Now the map will have all the people with value less than max, search among the people with value less then the min value.
            Map.Entry<Integer, Integer> lower = map.lowerEntry(min);
            result[idx - 1] = lower == null ? -1 : lower.getValue();
            queue.add(dp[i]);
        }
        return result;
    }

    private static int[] getPrevPositions_naive(int n, int[] h, int[] w) {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        long[][] sorted = new long[n][2];
//        0: area, 1: idx
        for (int i = 0; i < n; i++) {
            sorted[i] = new long[]{(long) h[i] * w[i], i};
        }
        Arrays.sort(sorted, (v1, v2) -> v1[0] == v2[0] ? Integer.compare(h[(int) v1[1]], h[(int) v2[1]]) : Long.compare(v1[0], v2[0]));
        for (int i = 0; i < n; i++) {
            int smallerIdx = getSmallerIdx(sorted, h, w, i);
            result[i] = smallerIdx;
        }
        return result;
    }

    private static int getSmallerIdx(long[][] sorted, int[] h, int[] w, int tar) {
        int start = 0, end = h.length - 1;
        long curArea = (long) h[tar] * w[tar];
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            Check if the cur index candidate can be placed in front of tar index candidate
            if (curArea > sorted[mid][0]) {
                for (int i = start; i <= end && curArea > sorted[i][0]; i++) {
                    int cur = (int) sorted[i][1];
                    if (canPlace(h[cur], w[cur], h[tar], w[tar])) {
                        return cur + 1;
                    }
                }
                break;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static boolean canPlace(int ch, int cw, int th, int tw) {
        return (ch < th && cw < tw) || (cw < th && ch < tw);
    }
}
