class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reachable index,
            // it means we can't get to this point.
            if (i > reachable) {
                return false;
            }
            // The greedy choice: at each step, we update the maximum reachable index.
            reachable = Math.max(reachable, i + nums[i]);

            // An optimization: if the reachable index is already at or beyond the last index,
            // we know we can make it.
            if (reachable >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    // Alternative greedy approach (working backwards)
    public boolean canJump_fromEnd(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
