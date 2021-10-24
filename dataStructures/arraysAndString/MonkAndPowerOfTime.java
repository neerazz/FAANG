/*
    Created on:  May 07, 2020
 */

import java.util.LinkedList;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-power-of-time/
 */
public class MonkAndPowerOfTime {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int count = fr.nextInt();
        LinkedList<Integer> calling = new LinkedList<>(), ideal = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            calling.add(fr.nextInt());
        }
        for (int i = 0; i < count; i++) {
            ideal.add(fr.nextInt());
        }
        int op = 0;
        while (!calling.isEmpty() && !ideal.isEmpty()) {
            if (calling.getFirst().equals(ideal.getFirst())) {
                calling.removeFirst();
                ideal.removeFirst();
                op++;
            } else {
                calling.addLast(calling.removeFirst());
                op++;
            }
        }
        System.out.println(op);
    }
}
