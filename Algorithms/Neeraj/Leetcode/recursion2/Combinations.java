package recursion2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
    static List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        brackTrace(n, k, 1, new LinkedList<>());
        return output;
    }

    private static void brackTrace(int n, int k, int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            brackTrace(n, k, i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }
}
