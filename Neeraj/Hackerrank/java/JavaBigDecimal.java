package java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-bigdecimal/problem
Sample Input
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000
Sample Output
90
56.6
50
02.34
0.12
.12
0
000.000
-100
 */
public class JavaBigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, (s1, s2) -> {
            if (s1 == null || s2 == null) return 0;
            return new BigDecimal(s2).compareTo(new BigDecimal(s1));
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
