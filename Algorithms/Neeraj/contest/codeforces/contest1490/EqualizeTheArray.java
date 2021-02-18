package contest1490;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 16, 2021
 * Questions: https://codeforces.com/contest/1490/problem/F
 */

public class EqualizeTheArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int cur = sc.nextInt();
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            System.out.println(getSteps(n, map));
        }
    }

    private static int getSteps(int n, Map<Integer, Integer> map) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int minOcc = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            set.add(key);
            minOcc = Math.min(minOcc, map.get(key));
        }
        int c = Math.min(minOcc, set.floor(minOcc));
        int steps = 0;
        for (int occ : map.values()) {
            steps += occ - c;
        }
        return steps;
    }
}
