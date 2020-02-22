public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));       // return true
        System.out.println(circularQueue.enQueue(2));       // return true
        System.out.println(circularQueue.enQueue(3));       // return true
        System.out.println(circularQueue.enQueue(4));       // return false, the queue is full
        System.out.println(circularQueue.Rear());                 // return 3
        System.out.println(circularQueue.isFull());               // return true
        System.out.println(circularQueue.deQueue());              // return true
        System.out.println(circularQueue.enQueue(4));       // return true
        System.out.println(circularQueue.Rear());                 // return 4

        System.out.println("=========================================");
        circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(7) + " should be true");      // return true
        System.out.println(circularQueue.deQueue() + " should be true");             // return true
        System.out.println(circularQueue.Front() + " should be -1");               // return 7
        System.out.println(circularQueue.Rear() + " should be -1");                // return 7
        System.out.println(circularQueue.enQueue(0) + " should be true");      // return true
        System.out.println(circularQueue.isFull() + " should be false");              // return false
        System.out.println(circularQueue.deQueue() + " should be true");             // return true
        System.out.println(circularQueue.Rear() + " should be 0");                // return 0
        System.out.println(circularQueue.enQueue(3) + " should be true");      // return true

        System.out.println("=========================================");
        circularQueue = new MyCircularQueue(8); // set the size to be 3
        System.out.println(circularQueue.enQueue(3));       // return true
        System.out.println(circularQueue.enQueue(9));       // return true
        System.out.println(circularQueue.enQueue(5));       // return true
        System.out.println(circularQueue.enQueue(0));       // return true
        System.out.println(circularQueue.deQueue());              // return true
        System.out.println(circularQueue.deQueue());              // return true
        System.out.println(circularQueue.isEmpty());              // return false
        System.out.println(circularQueue.isEmpty());              // return false
        System.out.println(circularQueue.Rear());                 // return 0
        System.out.println(circularQueue.Rear());                 // return 0
        System.out.println(circularQueue.deQueue());              // return true
    }
}

class MyCircularQueue {

    private Integer[] nums;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        nums = new Integer[k];
        size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size == nums.length) return false;
        if (size == 0) {
            nums[0] = value;
        } else {
            System.arraycopy(nums, 0, nums, 0, nums.length - 1);
            nums[size] = value;
        }
        size++;
        return true;
    }

    //    This is deQueue is for stack.
    public boolean enQueue_stack(int value) {
        if (size == nums.length) return false;
        if (size == 0) {
            nums[0] = value;
        } else {
            nums[size] = value;
        }
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        if (size > 0) {
            if (nums.length > 0) System.arraycopy(nums, 1, nums, 0, nums.length - 1);
            nums[size - 1] = null;
            size--;
        }
        return true;
    }

    //    This is deQueue is for stack.
    public boolean deQueue_stack() {
        if (size == 0) return false;
        if (size == nums.length) {
            nums[nums.length - 1] = null;
        } else {
            nums[size - 1] = null;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (nums.length > 0 && size > 0) {
            return nums[0] == null ? -1 : nums[0];
        } else {
            return -1;
        }
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (nums.length > 0 && size > 0) {
            return nums[size - 1] == null ? -1 : nums[size - 1];
        } else {
            return -1;
        }
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
        return size == nums.length;
    }
}