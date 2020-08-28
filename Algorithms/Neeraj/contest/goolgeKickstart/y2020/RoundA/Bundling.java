package y2020.RoundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created on:  Jul 02, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3ff3
 * Pip has N strings. Each string consists only of letters from A to Z. Pip would like to bundle their strings into groups of size K. Each string must belong to exactly one group.
 * <p>
 * The score of a group is equal to the length of the longest prefix shared by all the strings in that group. For example:
 * The group {RAINBOW, RANK, RANDOM, RANK} has a score of 2 (the longest prefix is 'RA').
 * The group {FIRE, FIREBALL, FIREFIGHTER} has a score of 4 (the longest prefix is 'FIRE').
 * The group {ALLOCATION, PLATE, WORKOUT, BUNDLING} has a score of 0 (the longest prefix is '').
 * <p>
 * Please help Pip bundle their strings into groups of size K, such that the sum of scores of the groups is maximized.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and K. Then, N lines follow, each containing one of Pip's strings.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum sum of scores possible.
 * <p>
 * Samples
 * <p>
 * Input 1
 * <p>
 * Output 1
 * <p>
 * 2
 * 2 2
 * KICK
 * START
 * 8 2
 * G
 * G
 * GO
 * GO
 * GOO
 * GOO
 * GOOO
 * GOOO
 * <p>
 * Case #1: 0
 * Case #2: 10
 * <p>
 * <p>
 * Input 2
 * <p>
 * Output 2
 * <p>
 * 1
 * 6 3
 * RAINBOW
 * FIREBALL
 * RANK
 * RANDOM
 * FIREWALL
 * FIREFIGHTER
 * <p>
 * Case #1: 6
 */
public class Bundling {


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
//            PriorityQueue<String> queue = new PriorityQueue<>(comp);
            String[] strs = new String[n];
            for (int j = 0; j < n; j++) {
//                queue.add(sc.next());
                strs[j] = sc.next();
            }
//            result[i] = getScore(n, k, queue);
            result[i] = getScore(n, k, strs);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    static int op;

    static Comparator<String> comp = (s1, s2) -> {
        int l1 = s1.length(), l2 = s2.length();
        int p1 = 0, p2 = 0;
        while (p1 < l1 && p2 < l2) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
            } else if (s1.charAt(p1) > s2.charAt(p2)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (p1 == l1 && p2 == l2) return 0;
        else if (p1 == l1) return -1;
        else return 1;
    };

    private static long getScore(int n, int k, String[] strs) {
        op = 0;
        Trie trie = new Trie();
        for (String str : strs) {
            buildTrie(str, trie);
        }
//        Perform a DFS to get the children counts.
        dfs(trie, k, 0);
        return op;
    }

    private static int dfs(Trie trie, int perGroup, int level) {
        if (trie == null) return 0;
        int cur = trie.count;
        for (Trie dep : trie.dep) {
            cur += dfs(dep, perGroup, level + 1);
        }
        int canForm = cur / perGroup;
        if (canForm > 0) {
            op += canForm * level;
        }
        return cur % perGroup;
    }

    private static void buildTrie(String str, Trie trie) {
        Trie cur = trie;
        for (char c : str.toCharArray()) {
            if (cur.dep[c - 'A'] == null) {
                cur.dep[c - 'A'] = new Trie();
            }
            cur = cur.dep[c - 'A'];
        }
        cur.count++;
    }

    private static long getScore(int n, int k, PriorityQueue<String> queue) {
        long result = 0;
        while (!queue.isEmpty()) {
            String start = queue.poll();
            boolean checkOthers = true;
            int temp = k - 1;
            while (!queue.isEmpty() && temp > 0) {
                if (checkOthers) {
                    start = findCommon(start, queue.poll());
                    if (start.length() == 0) {
                        checkOthers = false;
                    }
                }
                temp--;
            }
            result += start.length();
        }
        return result;
    }

    private static String findCommon(String ref, String cur) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ref.length(); i++) {
            if (ref.charAt(i) == cur.charAt(i)) {
                sb.append(ref.charAt(i));
            } else break;
        }
        return sb.toString();
    }

    static class Trie {
        int count;
        Trie[] dep;

        public Trie() {
            this.dep = new Trie[26];
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "isEnd=" + count +
                    ", dep=" + Arrays.toString(dep) +
                    '}';
        }
    }
}
