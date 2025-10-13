# Recursion and Backtracking

## Recursion

Recursion is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem. A recursive function calls itself with a smaller or simpler input.

### Key Components of a Recursive Function:
1.  **Base Case:** A condition that stops the recursion.
2.  **Recursive Step:** The part of the function that calls itself with a modified input, moving closer to the base case.

### When to use Recursion:
*   Problems with a naturally recursive structure (e.g., trees, fractals).
*   Problems that can be broken down into smaller, self-similar subproblems.
*   Traversals (e.g., tree traversals, graph traversals).

---

## Backtracking

Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point in time.

It is a refined brute-force approach where we "prune" the search space by avoiding paths that are guaranteed not to lead to a solution.

### When to use Backtracking:
*   Generating all possible combinations or permutations.
*   Constraint satisfaction problems (e.g., Sudoku, N-Queens).
*   Finding all paths in a grid or graph that meet certain criteria.

### Template: Backtracking

This general template can be adapted for many backtracking problems like generating permutations, combinations, or subsets.

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process from the first element (index 0)
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // 1. Add the current combination to the result list
        result.add(new ArrayList<>(tempList));

        // 2. Iterate through the candidates
        for (int i = start; i < nums.length; i++) {
            // 3. Make a choice: Add the candidate to our current combination
            tempList.add(nums[i]);

            // 4. Recurse: Explore further with the new combination
            // Note: we pass i + 1 to prevent reusing the same element in a combination
            backtrack(result, tempList, nums, i + 1);

            // 5. Backtrack: Undo the choice. Remove the last element to explore other paths.
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

**Example Problems:**
*   [Subsets](https://leetcode.com/problems/subsets/) *(Solution file `Subsets.java` is in this directory)*
*   [Permutations](https://leetcode.com/problems/permutations/) *(Solution file `Permutations.java` is in this directory)*
*   [Combination Sum](https://leetcode.com/problems/combination-sum/) *(Solution file `CombinationSum.java` is in this directory)*
