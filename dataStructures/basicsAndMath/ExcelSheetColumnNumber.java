/**
 * Created on:  Aug 10, 2020
 * Questions: https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {

    }

    public static int titleToNumber(String s) {
        int result = 0, len = s.length();
        for (char c : s.toCharArray()) {
            result += (int) (Math.pow(26, --len) * getNum(c));
        }
        return result;
    }

    private static int getNum(char c) {
        return c - 'A' + 1;
    }
}
