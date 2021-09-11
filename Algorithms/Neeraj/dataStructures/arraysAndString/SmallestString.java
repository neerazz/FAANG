/*
    Created on:  Apr 27, 2020
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/smallest-string-1-ab268aff/
 */
public class SmallestString {
    public static void main(String[] args) {
        FastReader sr = new FastReader("C:\\Users\\bnira\\Downloads\\860053ea82db11ea.txt.clean.txt");
        int n = sr.nextInt();
        List<String> op = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(sr.readLine());
            String input = sr.readLine();
            op.add(getSmallestString(input, len));
        }
        op.forEach(System.out::println);
    }

    private static String getSmallestString(String input, int len) {
        String op = input;
        for (int i = 0; i < len; i++) {
            String temp = input.substring(0, i) + input.substring(i + 1);
            for (int j = 0; j < len - 1; j++) {
                String temp2 = temp.substring(0, j) + input.charAt(i) + temp.substring(j);
                if (temp2.compareTo(op) < 0) {
                    op = temp2;
                }
            }
        }
        return op;
    }
}
