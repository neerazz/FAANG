package biweekly.biweekly40;

import java.util.*;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class DesignFrontMiddleBackQueue {

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)
    }

    static class FrontMiddleBackQueue {
        LinkedList<Integer> list = new LinkedList<>();

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            list.addFirst(val);
        }

        public void pushMiddle(int val) {
            int mid = list.size() / 2;
            list.add(mid, val);
        }

        public void pushBack(int val) {
            list.add(val);
        }

        public int popFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeFirst();
        }

        public int popMiddle() {
            if (list.isEmpty()) {
                return -1;
            }
            int mid = (list.size() - 1) / 2;
            return list.remove(mid);
        }

        public int popBack() {
            return list.isEmpty() ? -1 : list.removeLast();
        }
    }
}
