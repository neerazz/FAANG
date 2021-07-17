package concepts.primitives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{10, 100, 1000, 10000})));
    }


    public static int[] sortByBits(int[] arr) {

        Map<Integer, List<Integer>> counter = new HashMap<>();
        List<Integer> elems;

        for (int i : arr) {
            String bin = Integer.toBinaryString(i);
            int ones = count(bin);
            if (counter.containsKey(ones)) {
                elems = counter.get(ones);
            } else {
                elems = new ArrayList<>();
            }
            elems.add(i);
            counter.put(ones, elems);
        }

        int[] keys = new int[counter.size()];
        int j = 0;
        for (Integer i : counter.keySet()) {
            keys[j++] = i;
        }

        Arrays.sort(keys);

        int[] sol = new int[arr.length];
        int k = 0;
        for (int y : keys) {
            int p = 0;
            List<Integer> values = counter.get(y);
            int[] val = convertToArrayAndSort(values);
            while (k < arr.length && p < val.length) {
                sol[k++] = val[p++];
            }
        }
        return sol;
    }

    private static int[] convertToArrayAndSort(List<Integer> list) {
        int[] sol = new int[list.size()];
        int j = 0;
        for (Integer i : list) {
            sol[j++] = i;
        }
        Arrays.sort(sol);
        return sol;
    }


    private static int count(String bin) {
        int count = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') count++;
        }
        return count;
    }
}
