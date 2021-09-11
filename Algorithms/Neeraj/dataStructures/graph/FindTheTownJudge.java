/*
    Created on:  May 10, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions: https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}) + " should be [2]");
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}) + " should be [3]");
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}) + " should be [-1]");
        System.out.println(findJudge(3, new int[][]{{1, 2}, {2, 3}}) + " should be [-1]");
        System.out.println(findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}) + " should be [3]");
        System.out.println("**************** Elegant ********************************");
        System.out.println(findJudge_elegant(2, new int[][]{{1, 2}}) + " should be [2]");
        System.out.println(findJudge_elegant(3, new int[][]{{1, 3}, {2, 3}}) + " should be [3]");
        System.out.println(findJudge_elegant(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}) + " should be [-1]");
        System.out.println(findJudge_elegant(3, new int[][]{{1, 2}, {2, 3}}) + " should be [-1]");
        System.out.println(findJudge_elegant(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}) + " should be [3]");
    }

    public static int findJudge_elegant(int N, int[][] trust) {
        int[] inbound = new int[N], outbound = new int[N];
//        zero index for in-bond, 1 index for out-bond.
        for (int[] t : trust) {
            outbound[t[0] - 1]++;
            inbound[t[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
//            If in-bound count is N-1 (all are trusting except himself & and no out-bound then he is the judge)
            if (inbound[i] == N - 1 && outbound[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int findJudge(int N, int[][] trust) {
//        First Create N people.
        Map<Integer, People> town = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            town.put(i, new People(i));
        }
//        Loop through the trusts and updated the trusts from teh town.
        for (int[] t : trust) {
            town.get(t[0]).outBounds++;
            town.get(t[1]).inBounds++;
        }
//        Loop through all the people in town and return the person that doesn't trust any one, if not found then return -1;
        return town.entrySet().stream().filter(e -> e.getValue().inBounds == N - 1 && e.getValue().outBounds == 0).map(Map.Entry::getKey).findFirst().orElse(-1);
    }

    static class People {
        int number;
        int inBounds = 0;
        int outBounds = 0;

        public People(int number) {
            this.number = number;
        }
    }
}
