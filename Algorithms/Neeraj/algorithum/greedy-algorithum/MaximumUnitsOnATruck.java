import java.util.Arrays;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/maximum-units-on-a-truck/
 */

public class MaximumUnitsOnATruck {

    public static void main(String[] args) {

    }

    public static int maximumUnits(int[][] boxes, int truckSize) {
        Arrays.sort(boxes, (b1, b2) -> Integer.compare(b2[1], b1[1]));
        int total = 0;
        for (int[] box : boxes) {
            if (box[0] <= truckSize) {
                truckSize -= box[0];
                total += box[0] * box[1];
            } else {
                total += truckSize * box[1];
                truckSize = 0;
            }
        }
        return total;
    }
}
