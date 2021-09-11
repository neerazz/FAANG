import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created on:  Mar 06, 2021
 * Questions: https://leetcode.com/problems/sliding-window-median/
 */

public class SlidingWindowMedian {

    public static double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        Median median = new Median();
        int len = nums.length, p1 = 0, i = 0;
        for (int p2 = 0; p2 < len; p2++) {
            median.insert(nums[p2]);
            if (median.count == k) {
                result[i++] = median.getMedian();
                median.remove(nums[p1++]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("**************************** Solution 1 ********************************");
        System.out.println("Sliding window medians are: " + Arrays.toString(findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2)));
        System.out.println("Sliding window medians are: " + Arrays.toString(findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3)));

        System.out.println("**************************** Solution 2 ********************************");
        System.out.println("Sliding window medians are: " + Arrays.toString(medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 2)));
        System.out.println("Sliding window medians are: " + Arrays.toString(medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 3)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length, j = 0;
        boolean isEven = k % 2 == 0;
        double[] result = new double[len - k + 1];
        for (int i = 0; i < len && j < result.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(sub);
            double sum = sub[k / 2];
            if (isEven) {
                sum += sub[(k - 1) / 2];
                sum /= 2;
            }
            result[j++] = sum;
        }
        return result;
    }

    static class Median {
        PriorityQueue<Integer> left = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int count = 0;

        void insert(int num) {
            left.add(num);
            right.add(left.poll());
            if (right.size() > left.size()) left.add(right.poll());
            count++;
        }

        private void sync() {
            while (left.size() >= right.size()) {
                right.add(left.poll());
            }
            while (right.size() > left.size()) {
                left.add(right.poll());
            }
        }

        double getMedian() {
            if (count == 0) return -1;
            double median = left.peek();
            if (count % 2 == 0) {
                median += right.peek();
                median /= 2;
            }
            return median;
        }

        void remove(int num) {
            if (num <= left.peek()) {
                left.remove(num);
            } else {
                right.remove(num);
            }
            sync();
            count--;
        }
    }
}
