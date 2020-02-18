package ds.binarysearch;

public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println("Answer is:" + findMin(new int[]{3, 4, 5, 1, 2}) + " should be [1].");
        System.out.println("Answer is:" + findMin(new int[]{1, 3, 5}) + " should be [1].");
        System.out.println("Answer is:" + findMin(new int[]{2, 2, 2, 0, 1}) + " should be [0].");
        System.out.println("Answer is:" + findMin(new int[]{1, 3, 3}) + " should be [1].");
        System.out.println("Answer is:" + findMin(new int[]{10, 1, 10, 10, 10}) + " should be [1].");
        System.out.println("Answer is:" + findMin(new int[]{3, 3, 1, 3}) + " should be [1].");
    }

    public static int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) return nums[i];
        }
        return nums[0];
    }
}
