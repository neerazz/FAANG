import java.util.ArrayList;
import java.util.List;

/*
Problem: https://leetcode.com/problems/falling-squares/

Solution: https://leetcode.com/articles/falling-squares/
 */
public class FallingSquares {
    public static void main(String[] args) {
        int[][] value = {
                {1, 2},
                {2, 3},
                {6, 1}
        };
        List<Integer> output = getOutput(value);
        System.out.println(output);
    }

    private static List<Integer> getOutput(int[][] value) {
        System.out.println(value.length);
        int noOfCubes = value.length;

        List<Integer> output = new ArrayList<>();

        long maxValue = Long.MIN_VALUE;

        for (int i = 0; i < noOfCubes; i++) {
            int x = value[i][0];
            int y = value[i][0];
            maxValue = Math.max(maxValue, y);
        }

        return output;
    }
}
