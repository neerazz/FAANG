package weekly.weekly188;
/**
 * Created on:  May 09, 2020
 * Questions: https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 */
public class NumberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {

    }

    public static int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            chars[i] = pizza[i].toCharArray();
        }
        backtracking(chars, k, 0, 0, rows, cols);
        return 0;
    }

    private static void backtracking(char[][] chars, int k, int row, int col, int rows, int cols) {
        if (row == rows || col == cols) {
            return;
        }
//        canCutAtRow()
    }
}
