import java.util.Arrays;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
 */

public class RemoveDuplicates {

    public static void main(String[] args) {

    }

    public static int remove(int[] arr) {
        int nonDublicateIdx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) continue;
            arr[nonDublicateIdx++] = arr[i];
        }
        arr[nonDublicateIdx++] = arr[arr.length - 1];
        System.out.println(Arrays.toString(arr));
        return nonDublicateIdx;
    }
}
