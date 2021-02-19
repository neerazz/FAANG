package contest1486;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 18, 2021
 * Questions: https://codeforces.com/contest/1486/problem/B
 */

public class EasternExhibition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int[] x = new int[n], y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
//            Sort all the indexes, based on x and y axis.
            Arrays.sort(x);
            Arrays.sort(y);
//              If there are odd number of inputs then you will only have one shortest possibility, that will be center point after sorting.
//              If there are even number of inputs then you can place the point between the mid-1 and mid point (Including those points).
            if (n % 2 == 0) {
                int mid = n / 2;
                long xAxis = x[mid] - x[mid - 1] + 1;
                long yAxis = y[mid] - y[mid - 1] + 1;
                System.out.println(xAxis * yAxis);
            } else {
                System.out.println(1);
            }
        }
    }
}
