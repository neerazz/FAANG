import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Problem Description
Task. The goal in this problem is to find the minimum number of coins needed to change the input value
(an integer) into coins with denominations 1, 5, and 10.
Input Format. The input consists of a single integer 𝑚.
Constraints. 1 ≤ 𝑚 ≤ 103
.
Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.
Sample 1.
Input:
2
Output:
2
2 = 1 + 1.
Sample 2.
Input:
28
Output:
6
28 = 10 + 10 + 5 + 1 + 1 + 1.
 */
public class Week3MoneyChange {

    public static void main(String[] args) {
        int[] inputDenominations = new int[]{1, 5, 10};
        int inputValue = FastScan.nextInt();
        System.out.println(getDenominations(inputValue, inputDenominations));
    }

    private static int getDenominations(int inputValue, int[] inputDenominations) {
        int numberOfCoins = 0;
        int givenMoney = 0;
        while (givenMoney < inputValue) {
            int remainingMoney = inputValue - givenMoney;
//            Find the largest denomination that can be given. Assuming that the denominations are in acceding order.
            for (int i = inputDenominations.length - 1; i >= 0; i--) {
                if (inputDenominations[i] <= remainingMoney) {
//                    Then give that coin.
                    givenMoney += inputDenominations[i];
                    numberOfCoins++;
                    break;
                }
            }
        }
        return numberOfCoins;
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

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static double nextLong() {
            return Long.parseLong(next());
        }
    }
}
