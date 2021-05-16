package biweekly.biweekly42;

import java.util.*;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {

    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            q1.add(students[i]);
            q2.add(sandwiches[i]);
        }
        while (!q1.isEmpty()) {
            int start = q1.size();
            Queue<Integer> level = new LinkedList<>();
            while (!q1.isEmpty()) {
                int poll = q1.poll();
                if (q2.peek() == poll) {
//                    Then take it.
                    q2.poll();
                } else {
                    level.add(poll);
                }
            }
            q1.addAll(level);
            if (level.size() == start) break;
        }
        return q1.size();
    }
}
