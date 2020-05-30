package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortedArraysMerge {

    @EpiTest(testDataFile = "sorted_arrays_merge.tsv")
    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Integer> op = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int rowS = 0, valS = Integer.MAX_VALUE;
        int size = sortedArrays.size();
        while (true) {
            for (int i = 0; i < size; i++) {
                map.putIfAbsent(i, 0);
                int idx = map.get(i);
                if (idx < sortedArrays.get(i).size() && sortedArrays.get(i).get(idx) < valS) {
                    rowS = i;
                    valS = sortedArrays.get(i).get(idx);
                }
            }
            if (valS == Integer.MAX_VALUE) break;
            op.add(valS);
            map.put(rowS, map.get(rowS) + 1);
            rowS = 0;
            valS = Integer.MAX_VALUE;
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
