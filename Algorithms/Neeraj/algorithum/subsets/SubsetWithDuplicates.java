import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr
 */

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int size = subsets.size();
            Set<List<Integer>> temp = new HashSet<>();
            for (List<Integer> level : subsets) {
                List<Integer> list = new ArrayList<>(level);
                list.add(num);
                temp.add(list);
            }
            subsets.addAll(temp);
        }
        return new ArrayList<>(subsets);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findSubsets(new int[]{1, 3, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[]{1, 5, 3, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}
