package leetcode.v1.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FreqStack {

    //0 - Count of Elements
    //1 - Position placement
    Map<Integer, Freq> map;
    int position;

    public FreqStack() {
        map = new HashMap<>();
        position = 0;
    }

    public void push(int x) {
        map.putIfAbsent(x, new Freq());
        Freq freq = map.get(x);
        freq.key = x;
        freq.count++;
        freq.positions.add(position);
    }

    public int pop() {
        Queue<Freq> pq = new PriorityQueue<>();
        for (Freq freq : map.values()) {
            pq.add(freq);
            if (pq.size() > 1) pq.poll();
        }
        int key = pq.poll().key;
        Freq freq = map.get(key);
        if (freq.count == 0) {
            map.remove(key);
        } else {
            freq.count--;
            List<Integer> pos = freq.positions;
            pos.remove(pos.size() - 1);
        }
        return key;
    }

    class Freq implements Comparable<Freq> {
        int count;
        int key;
        List<Integer> positions;

        Freq() {
            key = 0;
            count = 0;
            positions = new ArrayList<>();
        }

        @Override
        public int compareTo(Freq other) {
            if (this.count == other.count) {
                if (positions.size() == 0 && other.positions.size() == 0) {
                    return 0;
                } else if (positions.size() == 0) {
                    return -1;
                } else if (other.positions.size() == 0) {
                    return 1;
                } else {
                    return positions.get(positions.size() - 1) - other.positions.get(positions.size() - 1);
                }
            } else {
                return this.count - other.count;
            }
        }
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
