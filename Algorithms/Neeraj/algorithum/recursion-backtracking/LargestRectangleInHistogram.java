import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_divideAndConcur(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_stack(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");

        System.out.println(largestRectangleArea(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea_divideAndConcur(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea_stack(new int[]{1, 1}) + " should be [2].");
    }

    public static int largestRectangleArea_stack(int[] heights) {
//        Add 0 heights at start, and after moving from left to right, while traversing right to left
        Stack<int[]> stack = new Stack<>();
//        0: idx, 1: height
        stack.push(new int[]{-1, 0});
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
//            As we are adding a filler building at the beginning, the comparison should only done till the last-1 building.
            while (stack.size() > 1 && stack.peek()[1] >= heights[i]) {
                int currentHeight = stack.pop()[1];
                int currentWidth = i - stack.peek()[0] - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(new int[]{i, heights[i]});
        }
        while (stack.size() > 1) {
            int currentHeight = stack.pop()[1];
            int currentWidth = length - stack.peek()[0] - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
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

    public static int largestRectangleArea_divideAndConcur(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public static int largestRectangleArea(int[] heights) {
        int output = 0;
        List<Integer> uniqueSorted = Arrays.stream(heights).boxed().distinct().collect(Collectors.toList());
        for (Integer i : uniqueSorted) {
            int currentHeighestArea = getSquare(i, heights);
//            System.out.println("i= " + i + "\t" + "currentHeighestArea = " + currentHeighestArea);
            output = Math.max(output, currentHeighestArea);
        }
        return output;
    }

    private static int getSquare(Integer maxHeight, int[] heights) {
        int maxArea = 0, width = 0;
        for (int cur : heights) {
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
