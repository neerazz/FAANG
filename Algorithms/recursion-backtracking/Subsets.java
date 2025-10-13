import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add the current subset to the list of results.
        // A new ArrayList is created to avoid modification by reference.
        result.add(new ArrayList<>(currentSubset));

        // Explore further by adding each of the remaining elements to the current subset.
        for (int i = start; i < nums.length; i++) {
            // Include the element
            currentSubset.add(nums[i]);

            // Recurse with the next starting position
            backtrack(result, currentSubset, nums, i + 1);

            // Backtrack: remove the element to explore subsets without it
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
