package weekly.weekly228;

/**
 * Created on:  Feb 13, 2021
 * Questions:
 */

public class MinimumLimitOfBallsInABag {

    public static void main(String[] args) {

    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int start = 1, end = 1_000_000_000;
        while (start < end) {
            int mid = start + (end - start) / 2;
//            Check if can we reduce the nums array with mid as teh max element with in the allowed operations.
            if (canReduce(nums, mid, maxOperations)) {
                end = mid;
            } else {
//                nums cannot be reduced to mid as max. So increase your left pointer to mid+1
                start = mid + 1;
            }
        }
        return start;
    }

    //    https://www.youtube.com/watch?v=5ET1d6PfbNU&feature=emb_title
    private static boolean canReduce(int[] nums, int max, int maxOperations) {
        int operation = 0;
        for (int num : nums) {
//            To reduce a number from num, to max. You will need (num/max) - 1 (In case it is properly divisible).
//              If num is 6 and max is 3. Then to bring 6 to 3, 6/3=2 but we only need 1 operation here. So when properly divisible then reduce by one.
//              If num is 7 and max is 3, Then to bring 7 to 3, 7/3=2, we need 2 operations(7 -> (4,3) -> (3,3,1)).
            operation += (num / max) - (num % max == 0 ? 1 : 0);
            if (operation > maxOperations) return false;
        }
        return true;
    }
}
