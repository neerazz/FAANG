import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Week2Fibonacci {

    public static void main(String[] args) {
        FastScan scan = new FastScan();
        int fibonacciNumber = scan.nextInt();
        System.out.println(getNFibonacciNumber(fibonacciNumber));

    }

    private static String getNFibonacciNumber(int fibonacciNumber) {
        long[] numberArray = new long[fibonacciNumber];
        for (int i = 0; i < fibonacciNumber; i++) {
            if (i == 0) numberArray[i] = 0;
            else if (i == 1) numberArray[i] = 1;
            else numberArray[i] = numberArray[i - 1] + numberArray[i - 2];
        }
        return Arrays.toString(numberArray);
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;
        FastScan() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
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
