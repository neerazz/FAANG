import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on:  Sep 07, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2444722699191194
 */
public class SeatingArrangements {
    public static void main(String[] args) {

    }

    static int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        LinkedList<Integer> seating = new LinkedList<>();
        int max = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            int cur = arr[i++];
            if (!seating.isEmpty()) {
                max = Math.max(max, cur - seating.getFirst());
            }
            seating.addFirst(cur);
            if (i < len) {
                cur = arr[i];
                max = Math.max(max, cur - seating.getLast());
                seating.addLast(cur);
            }
        }
        max = Math.max(max, Math.abs(seating.getFirst() - seating.getLast()));
        return max;
    }
}
