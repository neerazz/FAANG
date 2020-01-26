package problems.queueAndStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1) + " should be [1]");
        System.out.println(m.next(10) + " should be [10+1/2]");
        System.out.println(m.next(3) + " should be [3+10+1/3]");
        System.out.println(m.next(5) + " should be [5+3+10/3]");
        System.out.println("===========================================");
        MovingAverage_Efficient efficient = new MovingAverage_Efficient(3);
        System.out.println(efficient.next(1) + " should be [1]");
        System.out.println(efficient.next(10) + " should be [10+1/2]");
        System.out.println(efficient.next(3) + " should be [3+10+1/3]");
        System.out.println(efficient.next(5) + " should be [5+3+10/3]");
    }
}

class MovingAverage_Efficient {

    Queue<Integer> queue = new LinkedList<>();
    int size;
    int currentsize;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage_Efficient(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            queue.poll();
            queue.add(val);
        } else {
            queue.add(val);
            currentsize++;
        }
        return getAverage();
    }

    public double getAverage() {
        double sum = queue.stream().mapToInt(i -> i).sum();
        return sum / currentsize;
    }
}

class MovingAverage {

    int currentSize;
    int[] nums;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        nums = new int[size];
        currentSize = 0;
    }

    public double next(int val) {
        if (currentSize < nums.length) {
            nums[currentSize] = val;
            currentSize++;
            return getAverage();
        } else {
            System.arraycopy(nums, 1, nums, 0, nums.length - 1);
            nums[nums.length - 1] = val;
            return getAverage();
        }
    }

    public double getAverage() {
        double sum = Arrays.stream(nums).sum();
        return sum / currentSize;
    }
}