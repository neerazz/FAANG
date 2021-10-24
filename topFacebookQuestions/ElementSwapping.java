import java.util.Arrays;

/**
 * Created on:  Sep 07, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=838749853303393
 */
public class ElementSwapping {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMinArray(new int[]{5, 3, 1}, 2)));
        System.out.println(Arrays.toString(findMinArray(new int[]{8, 9, 11, 2, 1}, 3)));
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] findMinArray(int[] arr, int k) {
        int p1 = 0, len = arr.length;
        while (k > 0) {
            // Find the smallest index from p1 to end.
            int val = arr[p1], idx = p1;
            for (int j = p1 + 1; j < len && j <= p1 + k; j++) {
                if (arr[j] < val) {
                    idx = j;
                    val = arr[j];
                }
            }
            if (idx != p1) {
                while (idx > p1) {
                    swap(arr, idx--, idx);
                    k--;
                }
            }
            p1++;
            if (p1 == len) break;
        }
        return arr;
    }
}
