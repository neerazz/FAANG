import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea_naive(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_divideAndConcur(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_stack(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");
        System.out.println(largestRectangleArea_expand(new int[]{2, 1, 5, 6, 2, 3}) + " should be [10].");

        System.out.println(largestRectangleArea_naive(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea_divideAndConcur(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea_stack(new int[]{1, 1}) + " should be [2].");
        System.out.println(largestRectangleArea_expand(new int[]{1, 1}) + " should be [2].");
    }

    private static int largestRectangleArea_expand(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

//        Build the left side of the building.
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

//        Build the right side of the building.
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    private static int largestRectangleArea_naive(int[] heights) {
        int len = heights.length, max = 0;
        for (int i = 0; i < len; i++) {
            int right = i, height = heights[i];
//            Keep expanding to the right till, you reach the end or the height zero is reached.
            while (right < len && height > 0) {
                height = Math.min(height, heights[right]);
                int area = height * (right - i + 1);
                max = Math.max(max, area);
                right++;
            }
        }
        return max;
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
            int currentHighestArea = getSquare(i, heights);
//            System.out.println("i= " + i + "\t" + "currentHighestArea = " + currentHighestArea);
            output = Math.max(output, currentHighestArea);
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
