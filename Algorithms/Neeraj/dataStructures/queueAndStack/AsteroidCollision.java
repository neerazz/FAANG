import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 21, 2020
 * Questions: https://leetcode.com/problems/asteroid-collision/
 */

public class AsteroidCollision {

    public static void main(String[] args) {

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            boolean skip = false;
            while (!stack.isEmpty() && stack.peek() > 0 && cur < 0) {
                int pop = stack.pop();
                if (Math.abs(pop) > Math.abs(cur)) {
                    stack.add(pop);
                }
                if (Math.abs(pop) >= Math.abs(cur)) {
                    skip = true;
                    break;
                }
            }
            if (!skip) stack.add(cur);
        }
        int oplen = stack.size(), idx = oplen;
        int[] result = new int[oplen];
        while (!stack.isEmpty()) {
            result[--oplen] = stack.pop();
        }
        return result;
    }
}
