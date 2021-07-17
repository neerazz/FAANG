import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4
 */

class MedianOfAStream {

    PriorityQueue<Integer> left = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int count = 0;

    public void insertNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (right.size() > left.size()) left.add(right.poll());
        count++;
    }

    public double findMedian() {
        if (count == 0) return -1;
        double median = 0;
        if (count % 2 == 0) {
            median += left.peek();
            median += right.peek();
            median /= 2;
        } else {
            median = left.peek();
        }
        return median;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
