import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Partitioning Souvenirs
You and two of your friends have just returned back home after visiting various countries. Now you would
like to evenly split all the souvenirs that all three of you bought.
Problem Description
Input Format. The first line contains an integer 𝑛. The second line contains integers 𝑣1, 𝑣2, . . . , 𝑣𝑛 separated
by spaces.
Constraints. 1 ≤ 𝑛 ≤ 20, 1 ≤ 𝑣𝑖 ≤ 30 for all 𝑖.
Output Format. Output 1, if it possible to partition 𝑣1, 𝑣2, . . . , 𝑣𝑛 into three subsets with equal sums, and
0 otherwise.
Sample 1.
Input:
4
3 3 3 3
Output:
0
Sample 2.
Input:
1
40
Output:
0
Sample 3.
Input:
11
17 59 34 57 17 23 67 1 18 2 59
Output:
1
34 + 67 + 17 = 23 + 59 + 1 + 17 + 18 = 59 + 2 + 57.
Sample 4.
Input:
13
1 2 3 4 5 5 7 7 8 10 12 19 25
Output:
1
1 + 3 + 7 + 25 = 2 + 4 + 5 + 7 + 8 + 10 = 5 + 12 + 19.
 */
public class Week6PartitioningSouvenirs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            values[i] = scanner.nextInt();
        }

        if (partition(values)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean subsetSum(int[] S, int n, int a, int b, int c,
                                    Map<String, Boolean> lookup) {
        // return true if subset is found
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }

        // base case: no items left
        if (n < 0) {
            return false;
        }

        // construct a unique map key from dynamic elements of the input
        String key = a + "|" + b + "|" + c + "|" + n;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key)) {
            // Case 1. current item becomes part of first subset
            boolean A = false;
            if (a - S[n] >= 0) {
                A = subsetSum(S, n - 1, a - S[n], b, c, lookup);
            }

            // Case 2. current item becomes part of second subset
            boolean B = false;
            if (!A && (b - S[n] >= 0)) {
                B = subsetSum(S, n - 1, a, b - S[n], c, lookup);
            }

            // Case 3. current item becomes part of third subset
            boolean C = false;
            if ((!A && !B) && (c - S[n] >= 0)) {
                C = subsetSum(S, n - 1, a, b, c - S[n], lookup);
            }

            // return true if we get solution
            lookup.put(key, A || B || C);
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }

    // Function for solving 3-partition problem. It return true if given
    // set S can be divided into three subsets with equal sum
    public static boolean partition(int[] S) {
        if (S.length < 3) {
            return false;
        }

        // create a map to store solutions of subproblems
        Map<String, Boolean> lookup = new HashMap<>();

        // get sum of all elements in the set
        int sum = Arrays.stream(S).sum();

        // return true if sum is divisble by 3 and the set can can
        // be divided into three subsets with equal sum
        return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum / 3,
                sum / 3, sum / 3, lookup);
    }

    private static int partitioningSouvenirs(int count, int[] values, int sum) {

        boolean[][] temp = new boolean[sum / 3 + 1][count + 1];

        for (int i = 0; i <= count; i++) temp[0][i] = true;

        for (int i = 1; i <= sum / 3; i++) {
            for (int j = 1; j <= count; j++) {
                temp[i][j] = temp[i][j - 1];
                if (i > values[j - 1]) {
                    temp[i][j] = temp[i][j] || temp[i - values[j - 1]][j - 1];
                }
            }
        }
        return temp[sum / 3][count] ? 1 : 0;
    }
}
