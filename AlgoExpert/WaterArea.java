/**
 * Created on:  Aug 31, 2020
 * Questions: https://www.algoexpert.io/questions/Water%20Area
 */
public class WaterArea {
    public static void main(String[] args) {

    }

    public static int waterArea(int[] heights) {
        if (heights == null || heights.length < 3) return 0;
        int len = heights.length;
        int[] left = new int[len], right = new int[len];
        // Get all the max values at your left
        int max = 0;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, heights[i - 1]);
            left[i] = max;
        }
        max = 0;
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, heights[i + 1]);
            right[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int pillarMax = Math.min(left[i], right[i]);
            int currHeight = heights[i];
            if (currHeight < pillarMax) {
                sum += pillarMax - currHeight;
            }
        }
        return sum;
    }
}
