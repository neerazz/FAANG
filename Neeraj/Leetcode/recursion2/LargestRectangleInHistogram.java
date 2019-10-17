package recursion2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_divideandconcure(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
    }

    public static int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minindex] > heights[i]) {
                minindex = i;
            }
        }
        return Math.max(heights[minindex] * (end - start + 1),
                Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    public static int largestRectangleArea_divideandconcure(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public static int largestRectangleArea(int[] heights) {
        int output = 0;
        List<Integer> uniqueSorted = Arrays.stream(heights).boxed().distinct().collect(Collectors.toList());
        for (Integer i : uniqueSorted) {
            int currentHeighestArea = getSquare(i, heights);
            System.out.println("i= " + i + "\t" + "currentHeighestArea = " + currentHeighestArea);
            output = Math.max(output, currentHeighestArea);
        }
        return output;
    }

    private static int getSquare(Integer maxHeight, int[] heights) {
        int maxArea = 0, width = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            if (cur >= maxHeight) {
                width++;
            } else {
                maxArea = Math.max(maxHeight * width, maxArea);
                width = 0;
            }
        }
        return Math.max(maxHeight * width, maxArea);
    }
}
