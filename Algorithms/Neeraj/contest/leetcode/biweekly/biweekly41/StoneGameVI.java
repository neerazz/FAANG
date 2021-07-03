package biweekly.biweekly41;

import java.util.*;

/**
 * Created on:  Dec 12, 2020
 * Questions:
 */

public class StoneGameVI {

    public static void main(String[] args) {
//        System.out.println(stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
//        System.out.println(stoneGameVI(new int[]{1, 2}, new int[]{3, 1}));
//        System.out.println(stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));
        System.out.println(stoneGameVI(new int[]{6, 5, 1, 2, 10, 6}, new int[]{7, 7, 7, 7, 3, 7}));
    }

    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        for (int i = 0; i < aliceValues.length; i++) {
            pq.add(new int[]{aliceValues[i], bobValues[i]});
        }
        boolean aliceTurn = true;
        int a = 0, b = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (aliceTurn) a += poll[0];
            else b += poll[1];
            aliceTurn = !aliceTurn;
        }
        return Integer.compare(a, b);
    }

    public static int stoneGameVI_dp(int[] aliceValues, int[] bobValues) {
        int stones = aliceValues.length;
        Map<Integer, LinkedHashSet<Integer>> alice = new HashMap<>(), bob = new HashMap<>();
        for (int i = 0; i < stones; i++) {
            alice.computeIfAbsent(aliceValues[i], val -> new LinkedHashSet<>()).add(i);
            bob.computeIfAbsent(bobValues[i], val -> new LinkedHashSet<>()).add(i);
        }
        Map<Combination, int[]> memo = new HashMap<>();
        Set<Integer> taken = new HashSet<>();
        int[] score = helper(aliceValues, bobValues, alice, bob, 0, taken, memo);
        System.out.println("score = " + Arrays.toString(score));
        return Integer.compare(score[0], score[1]);
    }

    private static int[] helper(int[] aliceValues, int[] bobValues, Map<
            Integer, LinkedHashSet<Integer>> alice, Map<Integer, LinkedHashSet<Integer>> bob, int player, Set<
            Integer> taken, Map<Combination, int[]> memo) {
//        When every stone is taken
        if (taken.size() == aliceValues.length) {
            return new int[2];
        }
        Combination cur = new Combination(taken, player);
        if (memo.containsKey(cur)) return memo.get(cur);
        int[] curScore = new int[2];
        if (player == 0) {
//            Loop through all the available stones
            for (int val : alice.keySet()) {
                if (alice.get(val).isEmpty()) continue;
                Integer idx = alice.get(val).iterator().next();
                taken.add(idx);
                alice.get(val).remove(idx);
//                Remove from bob's map.
                bob.get(bobValues[idx]).remove(idx);
                int[] next = helper(aliceValues, bobValues, alice, bob, player ^ 1, taken, memo);
//                if (val + next[0] > curScore[0]) {
                if (val + next[0] - next[1] > curScore[0] - curScore[1] || val + next[0] > next[1]) {
//                if (val + next[0] >= next[1] || val + next[0] >= curScore[0]) {
                    curScore[0] = val + next[0];
                    curScore[1] = next[1];
                }
                bob.get(bobValues[idx]).add(idx);
                taken.remove(idx);
            }
        } else {
//            Loop through all the available stones
            for (int val : bob.keySet()) {
                if (bob.get(val).isEmpty()) continue;
                Integer idx = bob.get(val).iterator().next();
                taken.add(idx);
                bob.get(val).remove(idx);
//                Remove from alice's map.
                alice.get(aliceValues[idx]).remove(idx);
                int[] next = helper(aliceValues, bobValues, alice, bob, player ^ 1, taken, memo);
//                if (val + next[1] > curScore[1]) {
//                if (val + next[1] >= next[0]) {
                if (val + next[1] - next[0] > curScore[1] - curScore[0] || val + next[1] > next[0]) {
                    curScore[0] = next[0];
                    curScore[1] = val + next[1];
                }
                alice.get(aliceValues[idx]).add(idx);
                taken.remove(idx);
            }
        }
        memo.put(cur, curScore);
        return curScore;
    }

    static class Combination {
        Set<Integer> taken;
        int player;

        public Combination(Set<Integer> taken, int player) {
            this.taken = taken;
            this.player = player;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;

            Combination that = (Combination) o;

            if (this.player != that.player) return false;
            return this.taken != null ? this.taken.equals(that.taken) : that.taken == null;
        }

        @Override
        public int hashCode() {
            int result = this.taken != null ? this.taken.hashCode() : 0;
            result = 31 * result + this.player;
            return result;
        }

        @Override
        public String toString() {
            return "Combination{" +
                    "taken=" + taken +
                    ", player=" + player +
                    '}';
        }
    }
}
