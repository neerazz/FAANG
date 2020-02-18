package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.awt.event.ItemEvent;
import java.util.List;

public class CircularQueue {

    @EpiTest(testDataFile = "circular_queue.tsv")
    public static void queueTest(List<QueueOp> ops) throws TestFailure {
        Queue q = new Queue(1);
        int opIdx = 0;
        for (QueueOp op : ops) {
            switch (op.op) {
                case "Queue":
                    q = new Queue(op.arg);
                    break;
                case "enqueue":
                    q.enqueue(op.arg);
                    break;
                case "dequeue":
                    int result = q.dequeue();
                    if (result != op.arg) {
                        throw new TestFailure()
                                .withProperty(TestFailure.PropertyName.STATE, q)
                                .withProperty(TestFailure.PropertyName.COMMAND, op)
                                .withMismatchInfo(opIdx, op.arg, result);
                    }
                    break;
                case "size":
                    int s = q.size();
                    if (s != op.arg) {
                        throw new TestFailure()
                                .withProperty(TestFailure.PropertyName.STATE, q)
                                .withProperty(TestFailure.PropertyName.COMMAND, op)
                                .withMismatchInfo(opIdx, op.arg, s);
                    }
                    break;
            }
            opIdx++;
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "CircularQueue.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public static class Queue {
        Integer[] myList;
        int start;
        int end;

        public Queue(int capacity) {
            myList = new Integer[capacity];
            start = 0;
            end = 0;
        }

        public void enqueue(Integer x) {
            // TODO - you fill in here.
            if (size() < myList.length) {
                myList[++end] = x;
            } else {
                //Double the array size
                Integer[] temp = myList;
                myList = new Integer[temp.length * 2];
                if (temp.length >= 0){
                    System.arraycopy(temp, 0, myList, 0, temp.length);
                }
            }
            return;
        }

        public Integer dequeue() {
            // TODO - you fill in here.
            return 0;
        }

        public int size() {
            // TODO - you fill in here.
            if (end == -1) return 0;
            if (end > start) {
                return myList.length - end - start + 1;
            } else {
                return end - start + 1;
            }
        }

        @Override
        public String toString() {
            // TODO - you fill in here.
            return super.toString();
        }
    }

    @EpiUserType(ctorParams = {String.class, int.class})
    public static class QueueOp {
        public String op;
        public int arg;

        public QueueOp(String op, int arg) {
            this.op = op;
            this.arg = arg;
        }

        @Override
        public String toString() {
            return op;
        }
    }
}
