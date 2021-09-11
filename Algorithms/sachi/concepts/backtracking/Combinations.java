package concepts.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2).toString());
    }

    public void backtrack(int counter, LinkedList<Integer> curr) {
        if (curr.size() == k)
            output.add(new LinkedList<>(curr));

        for (int i = counter; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }

}
