/**
 * Created on:  Nov 29, 2020
 * Questions: https://leetcode.com/problems/jump-game-iii/
 */

public class JumpGameIII {

    public static void main(String[] args) {

    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr, start, visited);
    }

    private static boolean helper(int[] arr, int start, boolean[] visited) {
        if (visited[start]) return false;
        if (arr[start] == 0) return true;
        visited[start] = true;
        int back = start - arr[start], front = start + arr[start];
        // System.out.println("Back = " + back + " cur = " + start + " front = " + front);
        boolean result = false;
        if (back >= 0 && back < arr.length && helper(arr, back, visited)) {
            return true;
        }
        if (front >= 0 && front < arr.length && helper(arr, front, visited)) {
            return true;
        }
        return false;
    }
}
