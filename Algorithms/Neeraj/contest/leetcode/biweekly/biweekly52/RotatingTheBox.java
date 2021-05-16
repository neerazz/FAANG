package biweekly.biweekly52;

import java.util.Arrays;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-52/problems/rotating-the-box/
 */

public class RotatingTheBox {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{'#', '.', '#'}})));
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}})));
    }

    public static char[][] rotateTheBox(char[][] box) {
        int rows = box.length, cols = rows > 0 ? box[0].length : 0;
        char[][] result = new char[cols][rows];
        for (int r = 0; r < rows; r++) {
            char[] row = box[r];
            int len = row.length;
            for (int i = len - 1; i >= 0; i--) {
                char cur = row[i];
                if (cur == '#') {
//                    This can fall till last or till obstacle.
                    int fall = i;
                    while (fall + 1 < len && row[fall + 1] == '.') {
                        fall++;
                    }
                    row[i] = '.';
                    row[fall] = '#';
                }
            }
//            System.out.println("Rows = " + String.valueOf(row));
            int rotateCol = rows - r - 1;
            for (int rotatedRow = 0; rotatedRow < cols; rotatedRow++) {
                result[rotatedRow][rotateCol] = row[rotatedRow];
            }
        }
        return result;
    }
}
