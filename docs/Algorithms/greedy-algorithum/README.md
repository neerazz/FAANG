# Greedy Algorithms

A greedy algorithm is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. It makes the locally optimal choice at each stage with the hope of finding a global optimum.

Greedy algorithms do not always yield the optimal solution, but for many problems, they do.

## Key Idea

The core of a greedy algorithm is the **greedy choice property**: a global optimum can be arrived at by selecting a local optimum.

## Proving Correctness

To be sure a greedy algorithm is correct, you typically need to prove:
1.  **Greedy Choice Property:** Show that a greedy choice at any step does not prevent us from reaching the global optimal solution.
2.  **Optimal Substructure:** Show that the optimal solution to the problem contains optimal solutions to its subproblems.

## Problem Identification

Look for problems where:
*   You need to find an optimal solution (e.g., maximum, minimum, shortest).
*   Making a locally optimal choice seems like a good strategy.
*   The problem can be broken down into stages or steps.
*   Examples: Finding the minimum number of coins to make change, scheduling problems, finding minimum spanning trees (Prim's, Kruskal's).

## Template: Greedy Approach

The structure of a greedy algorithm is often a simple loop.

```java
class Solution {
    public boolean canJump(int[] nums) {
        // 'goal' represents the last position from which we can reach the end.
        // We start from the end of the array.
        int goal = nums.length - 1;

        // Iterate backwards from the second to last element.
        for (int i = nums.length - 2; i >= 0; i--) {
            // The greedy choice: if we can reach the 'goal' from the current position 'i',
            // then this position becomes our new, closer 'goal'.
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        // If we managed to move our 'goal' all the way to the start (index 0),
        // it means we can reach the end from the beginning.
        return goal == 0;
    }
}
```

**Example Problem:** [Jump Game](https://leetcode.com/problems/jump-game/)
*(Solution file `JumpGame.java` is in this directory)*
