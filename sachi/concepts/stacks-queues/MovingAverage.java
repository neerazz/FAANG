import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    private int size;
    private Deque<Integer> queue;
    private double sum;

    private MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
            queue.addLast(val);
            return sum / queue.size();
        } else {
            sum += val;
            queue.addLast(val);
            sum -= queue.pollFirst();
            return sum / size;
        }
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
