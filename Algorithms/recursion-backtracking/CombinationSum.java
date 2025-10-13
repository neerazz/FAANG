import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting is not strictly necessary but can help with pruning if we add logic to stop early.
        // Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If the remainder is less than 0, it's not a valid combination.
        if (remain < 0) {
            return;
        }
        // If the remainder is 0, we've found a valid combination.
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        }
        // Otherwise, continue to explore.
        else {
            for (int i = start; i < candidates.length; i++) {
                // Add the candidate to the temporary list
                tempList.add(candidates[i]);
                // Recurse with the new remainder and the same starting index,
                // as we can reuse the same element.
                backtrack(result, tempList, candidates, remain - candidates[i], i);
                // Backtrack: remove the element to explore other combinations.
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
