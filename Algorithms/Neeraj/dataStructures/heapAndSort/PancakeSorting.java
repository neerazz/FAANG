import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on:  Aug 29, 2020
 * Questions: https://leetcode.com/problems/pancake-sorting/
 */
public class PancakeSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i2 = scan.nextInt();
        double d2 = scan.nextDouble();
        String s2 = scan.nextLine();
    }

    public static List<Integer> pancakeSort(int[] A) {
        int i = A.length;
        List<Integer> op = new ArrayList<>();
        while (i > 0) {
//             Loop from start till j to find the max number
            int maxIdx = 0, maxValue = A[0];
            for (int j = 1; j < i; j++) {
                if (A[j] == i) {
                    maxIdx = j;
                    break;
                }
            }
//             Reverse from zero to max, then reverse zero to i;
            op.add(maxIdx + 1);
            reverse(A, maxIdx);
            op.add(i);
            reverse(A, --i);
        }
        return op;
    }

    private static void reverse(int[] arr, int end) {
        if (end == 0) return;
        int start = 0;
        while (start < end) {
            int temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp;
        }
    }
}
