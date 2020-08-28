import java.util.Arrays;

/**
 * Created on:  Aug 18, 2020
 * Questions: https://www.algoexpert.io/questions/Smallest%20Difference
 */
public class SmallestDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] best = {0, 0};
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int p1 = 0, p2 = 0, l1 = arrayOne.length, l2 = arrayTwo.length, closest = Integer.MAX_VALUE;
        while (p1 < l1 && p2 < l2) {
            int curDiff = Math.abs(arrayOne[p1] - arrayTwo[p2]);
            if (curDiff < closest) {
                best = new int[]{arrayOne[p1], arrayTwo[p2]};
                closest = curDiff;
                if (curDiff == 0) return best;
            }
            if (arrayOne[p1] < arrayTwo[p2]) p1++;
            else p2++;
        }
        return best;
    }
}
