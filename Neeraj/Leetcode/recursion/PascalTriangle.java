package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(getRow(3));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            output.add(getRow(i));
        }
        return output;
    }

    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Collections.singletonList(1));
        }
        if (rowIndex == 1) {
            return new ArrayList<>(Arrays.asList(1, 1));
        }
        List<Integer> previousLayer = getRow(rowIndex - 1);
        List<Integer> currentLayer = new ArrayList<>();
        currentLayer.add(1);
        for (int i = 1; i < rowIndex; i++) {
            currentLayer.add(previousLayer.get(i - 1) + previousLayer.get(i));
        }
        currentLayer.add(1);
        return currentLayer;
    }
}
