package y2020.RoundA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created on:  Jun 23, 2020
 * Questions:Tambourine has prepared a fitness program so that she can become more fit! The program is made of N sessions. During the i-th session, Tambourine will exercise for Mi minutes. The number of minutes she exercises in each session are strictly increasing.
 * <p>
 * The difficulty of her fitness program is equal to the maximum difference in the number of minutes between any two consecutive training sessions.
 * <p>
 * To make her program less difficult, Tambourine has decided to add up to K additional training sessions to her fitness program. She can add these sessions anywhere in her fitness program, and exercise any positive integer number of minutes in each of them. After the additional training session are added, the number of minutes she exercises in each session must still be strictly increasing. What is the minimum difficulty possible?
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and K. The second line contains N integers, the i-th of these is Mi, the number of minutes she will exercise in the i-th session.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum difficulty possible after up to K additional training sessions are added.
 * <p>
 * Samples
 * <p>
 * Input 1
 * <p>
 * Output 1
 * <p>
 * 1
 * 3 1
 * 100 200 230
 * <p>
 * Case #1: 50
 * <p>
 * <p>
 * Input 2
 * <p>
 * Output 2
 * <p>
 * 3
 * 5 2
 * 10 13 15 16 17
 * 5 6
 * 9 10 20 26 30
 * 8 3
 * 1 2 3 4 5 6 7 10
 */
public class Workout {
    public static void main(String[] args) {
        Scanner sr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sr.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int n = sr.nextInt();
            int changes = sr.nextInt();
            long[] minutes = new long[n];
            for (int j = 0; j < n; j++) {
                minutes[j] = sr.nextLong();
            }
            result[i] = getMinimumDifficulty(n, changes, minutes);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    //    Passed only one test case.
    private static long getMinimumDifficulty(int n, int changes, long[] minutes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v1[0] == v2[1] - v2[0] ? Long.compare(v2[0], v1[0]) : Long.compare((v2[1] - v2[0]), (v1[1] - v1[0])));
        for (int i = 1; i < n; i++) {
            pq.add(new long[]{minutes[i - 1], minutes[i]});
        }
        while (!pq.isEmpty() && changes > 0) {
            long[] poll = pq.poll();
            long diff = poll[1] - poll[0];
            if (diff <= 1) {
                return 1;
            } else {
                long[] n1 = {poll[0], poll[0] + diff / 2};
                long[] n2 = {poll[0] + diff / 2, poll[1]};
                pq.add(n1);
                pq.add(n2);
            }
            changes--;
        }
        return pq.isEmpty() ? 1 : pq.peek()[1] - pq.peek()[0];
    }
}