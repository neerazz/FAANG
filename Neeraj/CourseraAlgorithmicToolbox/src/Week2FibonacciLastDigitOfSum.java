import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

Problem Description
Task. Given an integer 𝑛, find the last digit of the sum 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.
Input Format. The input consists of a single integer 𝑛.
Constraints. 0 ≤ 𝑛 ≤ 1014
.
Output Format. Output the last digit of 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.
Sample 1.
Input:
3
Output:
4
𝐹0 + 𝐹1 + 𝐹2 + 𝐹3 = 0 + 1 + 1 + 2 = 4.
Sample 2.
Input:
100
Output:
5
The sum is equal to 927 372 692 193 078 999 175, the last digit is 5.

 */
public class Week2FibonacciLastDigitOfSum {
    public static void main(String[] args) {
        FastScan scan = new FastScan();
        long fibonacciNumber = scan.nextLong();
        ArrayList<Integer> nFibonacciNumber = getNFibonacciNumber(fibonacciNumber + 1);
        System.out.println(getLastDigit(sumOfArray(nFibonacciNumber)));
    }

    private static int sumOfArray(ArrayList<Integer> nFibonacciNumber) {
        int result = 0;
        return nFibonacciNumber.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    static ArrayList<Integer> getNFibonacciNumber(long fibonacciNumber) {
        ArrayList<Integer> numberArray = new ArrayList<>();
//        int[] numberArray = new int[fibonacciNumber];
        for (int i = 0; i < fibonacciNumber; i++) {
            if (i == 0) numberArray.add(0);
            else if (i == 1) numberArray.add(1);
            else numberArray.add(getLastDigit(numberArray.get(i - 1) + numberArray.get(i - 2)));
        }
        return numberArray;
    }

    static int getLastDigit(int number) {
        String value = String.valueOf(number);
        return Integer.parseInt(String.valueOf(value.charAt(value.length() - 1)));
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        FastScan() {
            try {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FastScan(InputStream stream) {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
