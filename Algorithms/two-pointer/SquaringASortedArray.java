/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R
 */

public class SquaringASortedArray {

    public static void main(String[] args) {

    }

    public static int[] makeSquares_rev1(int[] arr) {
        int start = 0, end = arr.length - 1, idx = arr.length - 1;
        int[] result = new int[arr.length];
        while (idx >= 0) {
            int v1 = arr[start] * arr[start];
            int v2 = arr[end] * arr[end];
            if (v1 < v2) {
                result[idx--] = v1;
                start++;
            } else {
                result[idx--] = v2;
                end--;
            }
        }
        return result;
    }

    public static int[] makeSquares(int[] arr) {
        int negidx = 0, posIdx = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negidx = i;
            } else if (arr[i] >= 0) {
                posIdx = Math.min(posIdx, i);
            }
        }

        int[] result = new int[arr.length];
        int idx = 0;
        while (idx < arr.length) {
            if (negidx >= 0 && posIdx < arr.length) {
                int neg = arr[negidx] * arr[negidx];
                int pos = arr[posIdx] * arr[posIdx];
                if (neg < pos) {
                    result[idx++] = neg;
                    negidx--;
                } else {
                    result[idx++] = pos;
                    posIdx++;
                }
            } else if (negidx >= 0) {
                result[idx++] = arr[negidx] * arr[negidx];
                negidx--;
            } else {
                result[idx++] = arr[posIdx] * arr[posIdx];
                posIdx++;
            }
        }
        return result;
    }
}
