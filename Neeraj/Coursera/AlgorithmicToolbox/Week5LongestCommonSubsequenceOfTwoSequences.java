import java.util.Scanner;

/*

Longest Common Subsequence of Two Sequences

Sample 1.
Input:
3
2 7 5
2
2 5
Output:
2
A common subsequence of length 2 is (2, 5).
Sample 2.
Input:
1
7
4
1 2 3 4
Output:
0
The two sequences do not share elements.
Sample 3.
Input:
4
2 7 8 3
4
5 2 8 7
Output:
2
One common subsequence is (2, 7). Another one is (2, 8).
 */
public class Week5LongestCommonSubsequenceOfTwoSequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstArrayLength = Integer.parseInt(scanner.next());
        int[] firstArray = new int[firstArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstArray[i] = Integer.parseInt(scanner.next());
        }

        int secondArrayLength = Integer.parseInt(scanner.next());
        int[] secondArray = new int[secondArrayLength];

        for (int i = 0; i < secondArrayLength; i++) {
            secondArray[i] = Integer.parseInt(scanner.next());
        }

        System.out.println(findLargestCommonSubSequence(firstArray, secondArray));
    }

    private static int findLargestCommonSubSequence(int[] firstArray, int[] secondArray) {

        int[][] values = new int[firstArray.length + 1][secondArray.length + 1];

        for (int i = 1; i <= firstArray.length; i++) {
            for (int j = 1; j <= secondArray.length; j++) {
                if (firstArray[i - 1] == secondArray[j - 1]) {
                    values[i][j] = values[i - 1][j - 1] + 1;
                } else {
                    values[i][j] = Math.max(values[i - 1][j], values[i][j - 1]);
                }
            }
        }
        return values[firstArray.length][secondArray.length];
    }
}
