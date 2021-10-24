import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        System.out.println(maxMin(2, new int[]{1, 2, 1, 2, 1}) + " should be [0]");
        System.out.println(maxMin(4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200}) + " should be [3]");
    }

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int pointer1 = 0, pointer2 = k - 1, minValue = Integer.MAX_VALUE;
        while (pointer2 < arr.length) {
            minValue = Math.min(minValue, arr[pointer2++] - arr[pointer1++]);
        }
        return minValue;
    }
}
