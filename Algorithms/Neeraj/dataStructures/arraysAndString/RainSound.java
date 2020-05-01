/*
    Created on:  Apr 25, 2020
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/rain-41f57695/
 */
public class RainSound {
    public static void main(String[] args) {
        FastReader reader = new FastReader("C:\\Users\\bnira\\Downloads\\633dd04c5ede11ea.txt.clean.txt");
        int tests = reader.nextInt();
        for (int i = 0; i < tests; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();
            int min = -1;
            if (a % c == 0) min = a / c;
            else if (((a / c) + 1) * c <= b) min = (a / c) + 1;
            int max = -1;
            if (min != -1) {
                if (b % c == 0) max = b / c;
                else if ((b / c) > 0) max = b / c;
            }
            System.out.println(min + " " + max);
        }
    }
}
