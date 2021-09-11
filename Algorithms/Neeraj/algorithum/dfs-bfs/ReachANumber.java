import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Dec 28, 2020
 * Questions: https://leetcode.com/problems/reach-a-number/solution/
 */

public class ReachANumber {

    public static void main(String[] args) {
        System.out.println(reachNumber(3));
        System.out.println(reachNumber(2));
    }

    public static int reachNumber(int target) {
        int k = 0;
        target = Math.abs(target);
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static int reachNumber_bruteForce(int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int steps = 1, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
//        Set<Integer> visited = new HashSet<>();
//        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
//            System.out.println(queue);
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (poll + steps == target || poll - steps == target) return steps;
                queue.add(poll - steps);
                queue.add(poll + steps);
//                if (visited.add(poll - steps)) queue.add(poll - steps);
//                if (visited.add(poll + steps)) queue.add(poll + steps);
            }
            steps++;
        }
        return -1;
    }
}
