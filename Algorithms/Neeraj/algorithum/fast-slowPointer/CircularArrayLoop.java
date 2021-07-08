/**
 * Created on:  Jul 07, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/3jY0GKpPDxr
 */

public class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (hasCircle(arr, i)) return true;
        }
        return false;
    }

    static boolean hasCircle(int[] arr, int start) {
        int next = start, len = arr.length, travelled = 0;
        boolean isForward = arr[start] > 0;
        while (travelled++ < len) {
            next = next(next, arr);
            if (next == start) return true;
            boolean curIsForward = arr[next] > 0;
            if (isForward && !curIsForward) return false;
            if (!isForward && curIsForward) return false;
        }
        return false;
    }

    static int next(int cur, int[] arr) {
        int len = arr.length;
        int next = len + cur + arr[cur];
        return next % len;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[]{1, 2, -1, 2, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 2, -1, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 1, -1, -2}));
    }
}
