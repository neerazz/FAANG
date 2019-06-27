import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

Maximum Pairwise Product Problem
Find the maximum product of two distinct numbers in a sequence of non-negative integers.

Input: A sequence of non-negative integers.
Output: The maximum value that can be obtained by multiplying two different elements from the sequence.

 */
public class Week1Assign2 {

    public static void main(String[] args) {
        FastScan scan = new FastScan(System.in);
        int noOfElements = scan.nextInt();
        int[] elements = new int[noOfElements];

        for (int i = 0; i < noOfElements; i++) {
            elements[i] = scan.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(elements, noOfElements));
    }

    private static long getMaxPairwiseProduct(int[] elements, int noOfElements) {
        long result = 0;

        for (int i = 0; i < noOfElements; i++) {
            for (int j = i + 1; j < noOfElements; j++) {

//                TODO Check an optimal solution. The below solution is failing.
//                Failed case #4/17: time limit exceeded (Time used: 2.99/1.50, memory used: 42606592/536870912.)
                long first = elements[i];
                long second = elements[j];
//                result = Math.max(result, elements[i] * elements[j]);
                result = Math.max(result, Math.multiplyExact(first, second));
//                long temResult = Math.multiplyExact(elements[i],elements[j]);
//                if (result <= temResult) {
//                    result = temResult;
//                }
            }
        }
        return result;
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

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
    }
}
