package biweekly.biweekly44;

import java.util.*;

/**
 * Created on:  Jan 24, 2021
 * Questions:
 */

public class MinimumNumberOfPeopleToTeach {

    public static void main(String[] args) {
        System.out.println(minimumTeachings(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int user = languages.length, fLen = friendships.length;
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int i = 1; i <= user; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < languages[i - 1].length; j++) {
                map.get(i).add(languages[i - 1][j]);
            }
        }
        boolean[] pairs = new boolean[fLen];
        for (int i = 0; i < fLen; i++) {
            pairs[i] = canTalk(map, map.get(friendships[i][0]), map.get(friendships[i][1]));
        }
        //        Loop through all the languages check the communication between friends.
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int count = getTeachCount_1(i, map, pairs, friendships);
            min = Math.min(count, min);
        }
        return min;
    }

    private static int getTeachCount_1(int lan, Map<Integer, Set<Integer>> users, boolean[] pairs, int[][] friendships) {
        Set<Integer> teach = new HashSet<>();
        for (int i = 0; i < friendships.length; i++) {
            if (pairs[i]) continue;
            int u1 = friendships[i][0], u2 = friendships[i][1];
            if (!users.get(u1).contains(lan)) teach.add(u1);
            if (!users.get(u2).contains(lan)) teach.add(u2);
        }
        return teach.size();
    }

    public static int minimumTeachings_naive(int n, int[][] languages, int[][] friendships) {
        int user = languages.length, fLen = friendships.length;
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int i = 1; i <= user; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < languages[i - 1].length; j++) {
                map.get(i).add(languages[i - 1][j]);
            }
        }
        boolean[] pairs = new boolean[fLen];
        for (int i = 0; i < fLen; i++) {
            pairs[i] = canTalk(map, map.get(friendships[i][0]), map.get(friendships[i][1]));
        }
//        Loop through all the languages check the communication between friends.
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int count = getTeachCount(i, map, pairs, friendships);
            min = Math.min(count, min);
        }
        return min;
    }

    private static int getTeachCount(int lan, Map<Integer, Set<Integer>> users, boolean[] pairs, int[][] friendships) {
        int count = 0;
        Map<Integer, Set<Integer>> tempUsers = new HashMap<>();
        for (int key : users.keySet()) {
            tempUsers.put(key, new HashSet<>(users.get(key)));
        }
        for (int i = 0; i < friendships.length; i++) {
            int u1 = friendships[i][0], u2 = friendships[i][1];
            Set<Integer> lan1 = tempUsers.get(u1);
            Set<Integer> lan2 = tempUsers.get(u2);
            if (pairs[i] || canTalk(users, lan1, lan2)) continue;
            if (lan1.add(lan)) count++;
            if (lan2.add(lan)) count++;
        }
        return count;
    }

    private static boolean canTalk(Map<Integer, Set<Integer>> users, Set<Integer> u1, Set<Integer> u2) {
//        Loop through the user i languages and find if there is any thing common in user2.
        for (int lan : u1) {
            if (u2.contains(lan)) return true;
        }
        return false;
    }
}
