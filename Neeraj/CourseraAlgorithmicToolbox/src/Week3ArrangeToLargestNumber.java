import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

Given an array of number print the largest Number that can be formed.
 */
public class Week3ArrangeToLargestNumber {
    public static void main(String[] args) {
        int numberOfNumbers = FastScan.nextInt();
        int[] numberArray = new int[numberOfNumbers];
        for (int i = 0; i < numberOfNumbers; i++) {
            numberArray[i] = FastScan.nextInt();
        }
        System.out.println(getTheLargetNumber(numberArray));
    }

    private static String getTheLargetNumber(int[] numberArray) {
        StringBuilder b = new StringBuilder();
        List<Integer> integerList = Arrays.stream(numberArray).sorted().boxed().collect(Collectors.toList());
        for (int i = integerList.size() - 1; i >= 0; i--) {
            b.append(integerList.get(i));
        }
        return b.toString();
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
