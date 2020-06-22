package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class MinimumDistance3SortedArrays {

    @EpiTest(testDataFile = "minimum_distance_3_sorted_arrays.tsv")

    public static int findMinDistanceSortedArrays(List<List<Integer>> sortedArrays) {
        int dif = Integer.MAX_VALUE, val = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        int l1 = sortedArrays.get(0).size(), l2 = sortedArrays.get(1).size(), l3 = sortedArrays.get(2).size();
        while (p1 < l1 && p2 < l2 && p3 < l3) {
            int v1 = sortedArrays.get(0).get(p1), v2 = sortedArrays.get(1).get(p2), v3 = sortedArrays.get(2).get(p3);
            int[] minCenterAndDif = getMinCenterAndDiff(v1, v2, v3);
            if (minCenterAndDif[2] < dif) {
                val = minCenterAndDif[1];
            }
            if (v1 == minCenterAndDif[0]) p1++;
            else if (v2 == minCenterAndDif[0]) p2++;
            else p3++;
        }
        return val;
    }

    private static int[] getMinCenterAndDiff(int v1, int v2, int v3) {
        int min = Math.min(v1, Math.min(v2, v3));
        int max = Math.max(v1, Math.max(v2, v3));
        int center = getCenter(v1, v2, v3, min, max);
        return new int[]{min, center, (center - min) + (max - center)};
    }

    private static int getCenter(int v1, int v2, int v3, int min, int max) {
        if ((v1 == min || v1 == max) && (v2 == min || v2 == max)) return v3;
        if ((v1 == min || v1 == max) && (v3 == min || v3 == max)) return v2;
        return v1;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MinimumDistance3SortedArrays.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public static class ArrayData implements Comparable<ArrayData> {
        public int val;
        public int idx;

        public ArrayData(int idx, int val) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(ArrayData o) {
            int result = Integer.compare(val, o.val);
            if (result == 0) {
                result = Integer.compare(idx, o.idx);
            }
            return result;
        }
    }
}
