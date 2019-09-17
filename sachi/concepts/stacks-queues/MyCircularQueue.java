public class MyCircularQueue {

    private int[] _input;
    private int head = -1;
    private int tail = -1;
    private int size = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        _input = new int[k];
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6);
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(5));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            //List is full
            return false;
        } else if (head == -1 && tail == -1) {
            head = increment(head);
            tail = increment(tail);
            _input[head] = value;
            size++;
            return true;
        } else {
            //Add to list
            tail = increment(tail);
            _input[tail] = value;
            size++;
            return true;
        }
    }

    private int increment(int pointer) {
        if (pointer == _input.length - 1) {
            return 0;
        } else {
            return ++pointer;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (size == 1) {
            head = -1;
            tail = -1;
            size--;
            return true;
        } else {
            head = increment(head);
            size--;
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        return _input[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        return _input[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return increment(tail) == head;
    }
}
