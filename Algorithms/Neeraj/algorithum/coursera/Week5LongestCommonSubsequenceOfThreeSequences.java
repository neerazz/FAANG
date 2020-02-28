import java.util.Scanner;

/*
Sample 1.
Input:
3
1 2 3
3
2 1 3
3
1 3 5
Output:
2
A common subsequence of length 2 is (1, 3).
Sample 2.
Input:
5
8 3 2 1 7
7
8 2 1 3 8 10 7
6
6 8 3 1 4 7
Output:
3
One common subsequence of length 3 in this case is (8, 3, 7). Another one is (8, 1, 7).

Solution: Same as two sequence.
 */
public class Week5LongestCommonSubsequenceOfThreeSequences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int aLength = Integer.parseInt(scanner.next());
        int[] a = scanNInputs(aLength, scanner);

        int bLength = Integer.parseInt(scanner.next());
        int[] b = scanNInputs(bLength, scanner);

        int cLength = Integer.parseInt(scanner.next());
        int[] c = scanNInputs(cLength, scanner);

        System.out.println(getLongestCommonSubsequence(a, b, c));

    }

    private static int getLongestCommonSubsequence(int[] a, int[] b, int[] c) {

        int[][][] temp = new int[a.length + 1][b.length + 1][c.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                for (int k = 1; k <= c.length; k++) {
                    int c1 = temp[i - 1][j][k];
                    int c2 = temp[i][j - 1][k];
                    int c3 = temp[i][j][k - 1];

                    if (a[i - 1] == b[j - 1] && a[i - 1] == c[k - 1]) {
                        temp[i][j][k] = temp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        temp[i][j][k] = maxValue(c1, c2, c3);
                    }
                }
            }
        }
        return temp[a.length][b.length][c.length];
    }

    private static int maxValue(int c1, int c2, int c3) {
        if (c1 >= c2 && c1 >= c3) return c1;
        else if (c2 >= c1 && c2 >= c3) return c2;
        else return c3;
    }

    private static int[] scanNInputs(int aLength, Scanner scanner) {
        int[] output = new int[aLength];

        for (int i = 0; i < aLength; i++) {
            output[i] = Integer.parseInt(scanner.next());
        }
        return output;
    }
}
