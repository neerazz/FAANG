class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window of size k
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max_sum = sum;

        // Slide the window from the k-th element to the end of the array
        for (int i = k; i < nums.length; i++) {
            // Subtract the element that is leaving the window and add the new element
            sum = sum - nums[i - k] + nums[i];
            // Update the maximum sum found so far
            max_sum = Math.max(max_sum, sum);
        }

        // The result is the maximum sum divided by k
        return max_sum / k;
    }
}
