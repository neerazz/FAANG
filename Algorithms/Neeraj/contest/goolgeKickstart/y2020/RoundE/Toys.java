package y2020.RoundE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created on:  Sep 15, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bede9
 */
public class Toys {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        String[] result = new String[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
//            Index : -> Entertainment time, 1: Remember time
            int[][] values = new int[n][2];
            for (int j = 0; j < n; j++) {
                values[j] = new int[]{fr.nextInt(), fr.nextInt()};
            }
//            result[i] = getMaxTime(n, values);
            result[i] = getMaxTime_optimal(n, values);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String getMaxTime_optimal(int toys, int[][] values) {
        long sum = 0;
//        Collect all the entertainment times.
        PriorityQueue<int[]> list = new PriorityQueue<>((t1, t2) -> t2[1] - t1[1]);
        for (int i = 0; i < toys; i++) {
            sum += values[i][0];
            values[i][1] += values[i][0];
            list.add(new int[]{i, values[i][1]});
        }
//        Prefix sum
        long[] prefSum = new long[toys];
        prefSum[0] = values[0][0];
        for (int i = 1; i < toys; i++) {
            prefSum[i] = prefSum[i - 1] + values[i][0];
        }

        PriorityQueue<Integer> removed = new PriorityQueue<>();
        long removedSum = 0;
        long[] best = {0, sum};
        while (!list.isEmpty()) {
//        Loop through all the toys list and, removeToyIdx the toys that violates the rule.
            while (!list.isEmpty() && list.peek()[1] > (sum - removedSum)) {
                removed.add(list.poll()[0]);
            }
            if (removed.isEmpty()) break;
            int removeToyIdx = removed.poll();
            long current = sum - 2 * removedSum + prefSum[removeToyIdx] - values[removeToyIdx][0];
            //System.out.println(current + " " + sum + " " + prefSum[removeToyIdx]);
            if (current > best[1]) {
                best[0] = toys - (list.size() + removed.size() + 1);
                best[1] = current;
            }
            removedSum += values[removeToyIdx][0];
        }
        if (!list.isEmpty()) {
            return toys - list.size() + " INDEFINITELY";
        } else {
            return best[0] + " " + best[1];
        }
    }

    private static String getMaxTime(int toys, int[][] values) {
        boolean[] removed = new boolean[toys];
//        visited[i][j] = Check if the value is calculated.
        boolean[][] visited = new boolean[toys + 1][toys + 1];
//        Indexes: 0 -> toys to be removed, 1 -> longest time that can be played.
//        Initialize the best time without removing any toys.
        long[] best = {0, getPlayTime(toys, values, removed)};
        Set<Integer> available = new HashSet<>();
        IntStream.range(0, toys).forEach(available::add);
        checkAllPermutations(0, toys, available, visited, best, removed, values);
        return best[0] + " " + (best[1] == Long.MAX_VALUE ? "INDEFINITELY" : best[1]);
    }

    private static void checkAllPermutations(int start, int toys, Set<Integer> available, boolean[][] dp, long[] best, boolean[] removed, int[][] values) {
        if (available.size() == 1 || best[1] == Long.MAX_VALUE) return;
        if (dp[start][available.size()]) return;
        dp[start][available.size()] = true;
        for (int end = start; end < toys; end++) {
            if (removed[end]) continue;
//            Try removing each item and find the play playTime.
            available.remove(end);
            removed[end] = true;
            long playTime = getPlayTime(toys, values, removed);
            if (playTime > best[1]) {
                best[0] = toys - available.size();
                best[1] = playTime;
                if (playTime == Long.MAX_VALUE) break;
            }
            checkAllPermutations(end + 1, toys, available, dp, best, removed, values);
            available.add(end);
            removed[end] = false;
        }
    }

    private static long getPlayTime(int n, int[][] toys, boolean[] removed) {
        int loop = 0, idx = 0;
        long[] freezeTime = new long[n];
        long curTime = 0;
        while (true) {
            while (idx < n) {
                if (!removed[idx]) {
//            Loop through all the un-removed toys, and check
//              if we can play, then increase current time and set freezing time.
//              else you will be bored, you have to return the current time.
                    if (curTime >= freezeTime[idx]) {
//                    Can be played till the entertainment time.
                        curTime += toys[idx][0];
//                    That toy must not be played till currentTime + resting time.
                        freezeTime[idx] = curTime + toys[idx][1];
                    } else return curTime;
                }
                idx++;
            }
            if (loop == 1) return Long.MAX_VALUE;
            if (idx == n) {
                loop++;
                idx = 0;
            }
        }
    }
}
