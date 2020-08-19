/**
 * Created on:  Aug 18, 2020
 * Questions:
 */
public class MaxSubSetSumNoAdjacent {
    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135}));
        System.out.println(maxSubsetSumNoAdjacent(new int[]{30, 25, 50, 55, 100, 120}));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array == null || array.length == 0) return 0;
        int len = array.length;
        if (len == 1) return array[0];
        int pre2 = 0, pre1 = array[0];
        for (int i = 1; i < len; i++) {
            int cur = Math.max(pre1, pre2 + array[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return Math.max(pre1, pre2);
    }
}
