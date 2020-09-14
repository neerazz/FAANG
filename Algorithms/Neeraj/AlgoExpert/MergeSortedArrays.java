import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Sep 12, 2020
 * Questions: https://www.algoexpert.io/questions/Merge%20Sorted%20Arrays
 */
public class MergeSortedArrays {
    public static void main(String[] args) {

    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        int len = arrays.size();
        int[] idxs = new int[len];
        Set<Integer> completed = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        while (completed.size() < len) {
// 			Loop through all the list index item and get the smallest value.
            int min = Integer.MAX_VALUE, list = -1;
            for (int i = 0; i < len; i++) {
                if (!completed.contains(i) && arrays.get(i).get(idxs[i]) < min) {
                    min = arrays.get(i).get(idxs[i]);
                    list = i;
                }
            }
// 			Add the min value to op, and increase the index value.
            result.add(min);
            if (arrays.get(list).size() == ++idxs[list]) completed.add(list);
        }

        return result;
    }
}
