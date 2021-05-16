package biweekly.biweekly36;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
 */
public class FindServersThatHandledMostNumberOfRequests {
    public static void main(String[] args) {
        System.out.println(busiestServers(3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}));
    }

    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] time = new int[k], counts = new int[k];
        int max = 0;
        for (int i = 0; i < arrival.length; i++) {
            int curTime = arrival[i];
            int server = getNextAvailable(time, i % k, curTime);
            if (server < 0) continue;
            time[server] = curTime + load[i];
            max = Math.max(max, ++counts[server]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (counts[i] == max) result.add(i);
        }
        return result;
    }

    private static int getNextAvailable(int[] time, int start, int curTime) {
//            Find the point where the task can be fit.
        for (int j = start; j < time.length; j++) {
            if (time[j] <= curTime) {
                return j;
            }
        }
        for (int j = 0; j < start; j++) {
            if (time[j] <= curTime) {
                return j;
            }
        }
        return -1;
    }
}
