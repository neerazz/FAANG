package algorithms;

import java.util.Arrays;
import java.util.List;

/*
https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        System.out.println(diagonalDifference(Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        )));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int leftValue = 0, rightValue = 0;
        int leftI = 0, leftJ = 0, rightI = 0, rightJ = size - 1;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                leftValue += arr.get(leftI++).get(leftJ++);
                rightValue += arr.get(rightI++).get(rightJ--);
            }
        }
        return Math.abs(leftValue - rightValue);
    }
}
