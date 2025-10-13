import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap. The PriorityQueue in Java is a min-heap by default.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // Add the current element to the heap
            minHeap.offer(num);

            // If the heap size is greater than k, it means we have more than k largest elements.
            // The smallest of these is at the root of the min-heap, so we remove it.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // After iterating through all numbers, the heap contains the k largest elements,
        // and the root of the heap is the k-th largest element.
        return minHeap.peek();
    }
}
