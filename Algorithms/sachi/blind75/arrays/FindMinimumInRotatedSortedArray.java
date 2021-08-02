package blind75.arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input = new int[]{3, 4, 5, 1, 2};
        System.out.println(findMin(input));
        //TODO:Implement this
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        if (nums[left] < nums[right]) return nums[left];
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[right] < nums[mid]) {
                left = mid;
            }
        }
        return -1;
    }
}
