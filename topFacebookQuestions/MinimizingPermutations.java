/**
 * Created on:  Sep 09, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=292715105029046
 */
public class MinimizingPermutations {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2, 5, 4, 3}) + " = 1");
        System.out.println(minOperations(new int[]{3, 1, 2}) + " = 2");
    }

    static void reverse(int[] arr, int from, int to) {
        if (from == to) return;
        while (from < to) {
            int temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }

    static int minOperations(int[] arr) {
        int oper = 0;
        boolean reversed = true;
        while (reversed) {
            reversed = false;
            Integer smallest = null, idx = null;
            for (int i = 0; i < arr.length; i++) {
                if (smallest == null) {
                    smallest = i + 1 == arr[i] ? null : i + 1;
                } else {
                    idx = arr[i] == smallest ? i + 1 : null;
                }
                if (idx != null) break;
            }
            if (smallest != null) {
                reversed = true;
                reverse(arr, smallest - 1, idx - 1);
                oper++;
            }
        }
        return oper;
    }
}
