package contest1426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://codeforces.com/contest/1426/problem/D
 */
public class NonZeroSegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int n = sc.nextInt(), idx = 0, count = 0, lastIdx = -1;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long sum = 0;
        while (idx < n) {
            sum += sc.nextInt();
            if (map.containsKey(sum) && lastIdx <= map.get(sum) + 1) {
//                If there exists a number in map, whose index was falls after the previous index were zero was found.
                count++;
                lastIdx = idx;
            }
            map.put(sum, idx++);
        }
        System.out.println(count);
    }
}
