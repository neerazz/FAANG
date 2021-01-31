package contest1472;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 28, 2021
 * Questions:
 */

public class CardsForFriends {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int w = sc.nextInt(), h = sc.nextInt(), n = sc.nextInt();
            int p1 = getCuts(w), p2 = getCuts(h);
            System.out.println(p1 * p2 >= n ? "YES" : "NO");
        }
    }

    private static int getCuts(int val) {
        int cuts = 1;
        while (val % 2 == 0) {
            cuts <<= 1;
            val /= 2;
        }
        return cuts;
    }
}
