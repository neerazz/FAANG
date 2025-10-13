import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // If the temporary list is the same size as the input array, we have a complete permutation.
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Skip if the element is already in the current permutation
                if (tempList.contains(nums[i])) {
                    continue;
                }
                // Add the current element to the permutation
                tempList.add(nums[i]);
                // Recurse to build the rest of the permutation
                backtrack(result, tempList, nums);
                // Backtrack: remove the element to explore other possibilities
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
