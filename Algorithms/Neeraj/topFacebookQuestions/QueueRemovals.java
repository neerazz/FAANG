import java.util.*;

/**
 * Created on:  Sep 09, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=229890198389794
 */
public class QueueRemovals {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPositions(new int[]{1, 2, 2, 3, 4, 5}, 5)) + " = " + Arrays.toString(new int[]{5, 6, 4, 1, 2}));
        System.out.println(Arrays.toString(findPositions(new int[]{2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4}, 4)) + " = " + Arrays.toString(new int[]{2, 5, 10, 13}));
    }

    static int[] findPositions(int[] arr, int x) {
//        0: val, 1 : idx
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new int[]{arr[i], i});
        }
        int[] result = new int[x];
        int p1 = 0;
        while (!queue.isEmpty() && x - p1 > 0) {
            // Loop and get the first k elemets out of the queue.
            List<int[]> level = new ArrayList<>();
            int i = 0, maxVal = Integer.MIN_VALUE, maxIdx = 0;
            while (!queue.isEmpty() && i < x) {
                int[] cur = queue.poll();
                if (cur[0] > maxVal) {
                    maxVal = cur[0];
                    maxIdx = i;
                }
                i++;
                if (cur[0] > 0) {
                    cur[0]--;
                }
                level.add(cur);
            }
            result[p1++] = level.remove(maxIdx)[1] + 1;
            queue.addAll(level);
        }
        return result;
    }
}
