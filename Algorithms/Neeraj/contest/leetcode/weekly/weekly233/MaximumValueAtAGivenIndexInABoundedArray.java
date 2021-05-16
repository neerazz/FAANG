package weekly.weekly233;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class MaximumValueAtAGivenIndexInABoundedArray {

    public static void main(String[] args) {
        System.out.println(maxValue(4, 2, 6) + " = 2");
        System.out.println(maxValue(6, 1, 10) + " = 3");
        System.out.println(maxValue(8, 7, 14) + " = 4");
        System.out.println(maxValue(4, 0, 4) + " = 1");
        System.out.println(maxValue(6, 2, 931384943) + " = 155230825");
    }

    public static int maxValue(int n, int index, int maxSum) {
        int start = 0, end = maxSum;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (canForm(n, index, maxSum, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (canForm(n, index, maxSum, end)) return end;
        return canForm(n, index, maxSum, start) ? start : 0;
    }

    private static boolean canForm(int n, int idx, int sum, int val) {
        long left = idx - 1, right = idx + 1, next = val, rem = n - 1;
        if (n * next <= sum) return true;
        sum -= next--;
        while (next > 0 && sum >= 0 && (left >= 0 || right < n)) {
            if (next * rem <= sum) {
//                Next value can be set in the remaining all arrays
                return true;
            }
            int reduce = 0;
            if (left-- >= 0) {
                reduce += next;
                rem--;
            }
            if (right++ < n) {
                reduce += next;
                rem--;
            }
            sum -= reduce;
            next--;
        }
        return sum >= 0 && left == 0 && right == n;
    }
}
