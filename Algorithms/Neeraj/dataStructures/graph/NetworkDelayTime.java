import java.util.Arrays;

/**
 * Created on:  Jul 29, 2020
 * Questions: https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public static void main(String[] args) {

    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = distances[K] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int[] time : times) {
                if (distances[time[0]] != Integer.MAX_VALUE &&
                        distances[time[1]] > distances[time[0]] + time[2]) {
                    distances[time[1]] = distances[time[0]] + time[2];
                }
            }
        }

//         Check for negative path
        for (int[] time : times) {
            if (distances[time[1]] > distances[time[0]] + time[2]) {
                // System.out.println("It have a negative Path.");
                return -1;
            }
        }

//         Check if all the nodes are visited.
        int max = Integer.MIN_VALUE;
        // System.out.println(Arrays.toString(distances));
        for (int dist : distances) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist);
        }
        return max;
    }
}
