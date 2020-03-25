import java.util.*;

public class ArrayCombinations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        helper(set, curr, sol);
        return sol;
    }

    public static void helper(Set<Integer> set, LinkedList<Integer> curr, List<List<Integer>> sol) {

        if (set.size() == 0) {
            sol.add(new ArrayList<>(curr));
            return;
        }

        Set<Integer> set2 = new HashSet<>(set);

        for (Integer i : set) {
            curr.addLast(i);
            set2.remove(i);
            helper(set2, curr, sol);
            curr.removeLast();
            set2.add(i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> sol = permute(new int[]{1, 2, 3});
        for (List<Integer> list : sol) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


}
