package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {
    // The numbering starts from one, i.e., if A = [3,1,-1,2] then
    // findKthLargest(1, A) returns 3, findKthLargest(2, A) returns 2,
    // findKthLargest(3, A) returns 1, and findKthLargest(4, A) returns -1.
    @EpiTest(testDataFile = "kth_largest_in_array.tsv")
    public static int findKthLargest(int k, List<Integer> A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> Integer.compare(v1, v2));
        for (int val : A) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "KthLargestInArray.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
