import java.util.Stack;

/**
 * Created on:  Aug 16, 2021
 * Ref : https://leetcode.com/problems/buildings-with-an-ocean-view/
 */
public class BuildingsWithAnOceanView {
    public static void main(String[] args) {

    }

    public int[] findBuildings(int[] heights) {
//         0: heigth, 1: idx
        Stack<int[]> stack = new Stack<>();
        int len = heights.length;
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek()[0] < heights[i]) {
                stack.add(new int[]{heights[i], i});
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop()[1];
        }
        return result;
    }
}
