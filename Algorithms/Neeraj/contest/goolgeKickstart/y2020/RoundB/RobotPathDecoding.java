package y2020.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Aug 11, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83dc
 */
public class RobotPathDecoding {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[][] result = new int[tests][2];
        for (int i = 0; i < tests; i++) {
            result[i] = getEndPoint(fr.next());
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " + result[i][1]);
        }
    }

    private static int[] getEndPoint(String str) {
        String expanded = expandInput(str.toCharArray());
//        System.out.println("expanded = " + expanded);
        int row = 1, col = 1, rows = 1_000_000_000, cols = 1_000_000_000;
        for (char c : expanded.toCharArray()) {
            if (c == 'N') {
                row--;
                if (row < 1) row = rows;
            } else if (c == 'E') {
                col++;
                if (col > cols) col = 1;
            } else if (c == 'S') {
                row++;
                if (row > rows) row = 1;
            } else {
                col--;
                if (col < 1) col = cols;
            }
        }
        return new int[]{col, row};
    }

    private static String expandInput(char[] input) {
        StringBuilder sb = new StringBuilder();
        int i = 0, len = input.length;
        while (i < len) {
            if (Character.isDigit(input[i])) {
                int rep = input[i] - '0';
                int start = i + 2, end = getEnd(input, start);
                String nested = expandInput(Arrays.copyOfRange(input, start, end));
                sb.append(nested.repeat(Math.max(0, rep)));
                i = end + 1;
            } else {
                sb.append(input[i++]);
            }
        }
        return sb.toString();
    }

    private static int getEnd(char[] input, int start) {
        int opens = 0;
        for (int i = start; i < input.length; i++) {
            if (input[i] == '(') opens++;
            else if (input[i] == ')') {
                if (opens == 0) return i;
                else opens--;
            }
        }
//        Handle exception related to invalid brackets.
        return opens == 0 ? input.length - 1 : -1;
    }
}
