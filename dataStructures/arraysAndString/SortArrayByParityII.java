import java.util.Arrays;

/**
 * Created on:  Aug 21, 2020
 * Questions:
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII_optimal(new int[]{4, 2, 5, 7})) + " == " + Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(sortArrayByParityII_optimal(new int[]{4, 1, 1, 0, 1, 0})) + " == " + Arrays.toString(sortArrayByParityII(new int[]{4, 1, 1, 0, 1, 0})));
    }

    /*       [4,1,1,0,1,0]
              0 1 2 3 4 5
     *       [4,1,0,1,1,0]
     *              i
     *   e=4, o=5
     * */
    public static int[] sortArrayByParityII_optimal(int[] A) {
        int even = 0, odd = 1, len = A.length;
        while (even < len && odd < len) {
//            Find the first even index that have odd value.
            while (even < len && A[even] % 2 == 0) even += 2;
//            Find the first odd index that have even value.
            while (odd < len && A[odd] % 2 == 1) odd += 2;

//            Swap those index and keep checking from the same index, that way the value is checked after swap.
            swap(A, even, odd);
        }
        return A;
    }

    public static int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1, i = 0;
        int[] op = new int[A.length];
        while (i < A.length) {
            if (A[i] % 2 == 0) {
                op[even] = A[i++];
                even += 2;
            } else {
                op[odd] = A[i++];
                odd += 2;
            }
        }
        return op;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
