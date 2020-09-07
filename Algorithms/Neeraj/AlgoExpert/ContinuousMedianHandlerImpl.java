import java.util.PriorityQueue;

/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.algoexpert.io/questions/Continuous%20Median
 */
public class ContinuousMedianHandlerImpl {
    public static void main(String[] args) {

    }

    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> left = new PriorityQueue<>((v1, v2) -> v2 - v1), right = new PriorityQueue<>();

        public void insert(int number) {
            right.add(number);
            if (!left.isEmpty()) right.add(left.poll());
            while (left.size() < right.size()) left.add(right.poll());
            int size = left.size() + right.size();
            if (size == 0) median = 0;
            if (size % 2 == 0) {
                median = ((double) left.peek() + (double) right.peek()) / 2;
            } else {
                median = left.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }
}
