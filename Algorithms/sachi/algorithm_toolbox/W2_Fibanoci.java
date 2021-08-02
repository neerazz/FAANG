package algorithm_toolbox;//Given an integer 𝑛, find the 𝑛th Fibonacci number 𝐹𝑛
//SOL : a=0, b=1, a+b
//Fi = Fi-1 + Fi-2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W2_Fibanoci {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getFibonacciNumber(n));
    }


    private static long getFibonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long first = 0, second = 1, sum = 0;
        for (int i = 1; i < n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
