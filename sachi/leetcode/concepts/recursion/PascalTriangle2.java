import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.

Example:

Input: 3
Output: [1,3,3,1]

Follow up:
Could you optimize your algorithm to use only O(k) extra space?

 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(getRow(n));
        scanner.close();
    }

    private static List<Integer> getRow(int rowIndex) {
        Integer[] sol = new Integer[rowIndex + 1];
        Arrays.fill(sol, 0);
        sol[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                sol[j] = sol[j] + sol[j - 1];
            }
        }
        return Arrays.asList(sol);
    }

    public static void print(List<Integer> list) {
        System.out.println("");
        list.forEach(num -> System.out.print(num + " "));
    }
}