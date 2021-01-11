package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class OnlineMedian {
    public static List<Double> onlineMedian(Iterator<Integer> sequence) {
        List<Double> op = new ArrayList<>();
        SortedLinkedList<Integer> heap = new SortedLinkedList<>();
        while (sequence.hasNext()) {
            heap.add(sequence.next());
            op.add(heap.getMedian());
        }
        return op;
    }

    static class SortedLinkedList<Integer extends Comparable<java.lang.Integer>> extends LinkedList<java.lang.Integer> {

        @Override
        public boolean add(java.lang.Integer e) {
            if (this.isEmpty()) {
                super.add(e);
            } else {
                int index = Collections.binarySearch(this, e);
                if (index < 0) {
//                    If key is not present, the it returns "(-(insertion point) - 1)".
                    index = (index+1) * -1;
                }
                super.add(index, e);
            }
            return true;
        }

        public Double getMedian() {
            int size = this.size();
            if (size % 2 == 1) {
                return Double.valueOf(this.get(size / 2).toString());
            } else {
                Double first = Double.valueOf(this.get(size / 2).toString());
                Double second = Double.valueOf(this.get((size - 1) / 2).toString());
                return (first + second) / 2;
            }
        }
    }

    @EpiTest(testDataFile = "online_median.tsv")
    public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
        return onlineMedian(sequence.iterator());
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "OnlineMedian.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
