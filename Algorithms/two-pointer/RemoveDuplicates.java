class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array is empty, there are no duplicates to remove.
        if (nums.length == 0) {
            return 0;
        }

        // 'slow' pointer will keep track of the position for the next unique element.
        int slow = 0;

        // 'fast' pointer will iterate through the array to find unique elements.
        for (int fast = 1; fast < nums.length; fast++) {
            // If we find an element that is different from the element at the 'slow' pointer's position,
            // it means we've found a new unique number.
            if (nums[fast] != nums[slow]) {
                // We move the 'slow' pointer one step forward.
                slow++;
                // And we place the new unique element at this new position.
                nums[slow] = nums[fast];
            }
        }

        // The length of the array with unique elements is the position of the last unique element + 1.
        return slow + 1;
    }
}
