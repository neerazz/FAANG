import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Sep 28, 2020
 * Questions: https://www.algoexpert.io/questions/Same%20BSTs
 */
public class SameBSTs {
    public static void main(String[] args) {
        System.out.println(sameBsts(
                Arrays.asList(7, 6, 5, 4, 3, 2, 1),
                Arrays.asList(7, 6, 5, 4, 3, 2, 1, 0)));
        System.out.println(sameBsts(
                Arrays.asList(5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34),
                Arrays.asList(5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8)));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) return true;
        if (arrayOne.size() != arrayTwo.size()) return false;
        return arrayOne.get(0).equals(arrayTwo.get(0)) &&
                sameBsts(getLeft(arrayOne), getLeft(arrayTwo)) &&
                sameBsts(getRight(arrayOne), getRight(arrayTwo));
    }

    private static List<Integer> getRight(List<Integer> nums) {
//        return nums.stream().filter(val -> val > center).collect(Collectors.toList());
        List<Integer> op = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) >= nums.get(0)) op.add(nums.get(i));
        }
        return op;
    }

    private static List<Integer> getLeft(List<Integer> nums) {
//        return nums.stream().filter(val -> val < center).collect(Collectors.toList());
        List<Integer> op = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(0)) op.add(nums.get(i));
        }
        return op;
    }
}
