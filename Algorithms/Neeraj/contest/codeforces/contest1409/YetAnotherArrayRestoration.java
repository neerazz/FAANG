package contest1409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 27, 2020
 * Questions: https://codeforces.com/contest/1409/problem/C
 */
public class YetAnotherArrayRestoration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            System.out.println(String.join(" ", getArray(n, x, y)));
        }
    }

    private static List<String> getArray(int n, int x, int y) {
        if (n == 2) return Arrays.asList("" + x, "" + y);
        int diff = y - x;
        for (int i = n - 1; i > 0; i--) {
            if (diff % i != 0) continue;
            diff /= i;
            break;
        }
        List<String> result = new ArrayList<>();
        int temp = y;
        while (temp > 0 && result.size() < n) {
            result.add("" + temp);
            temp -= diff;
        }
        temp = y;
        while (result.size() < n) {
            temp += diff;
            result.add("" + temp);
        }
        return result;
    }
}
