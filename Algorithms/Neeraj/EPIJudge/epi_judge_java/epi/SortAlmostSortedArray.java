package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

    public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(sequence.hasNext() && queue.size() < k){
            queue.add(sequence.next());
        }
        List<Integer> op = new ArrayList<>();
        while(sequence.hasNext()){
            queue.add(sequence.next());
            op.add(queue.poll());
        }
        while(!queue.isEmpty()){
            op.add(queue.poll());
        }
        return op;
    }

    @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
    public static List<Integer>
    sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
        return sortApproximatelySortedData(sequence.iterator(), k);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
