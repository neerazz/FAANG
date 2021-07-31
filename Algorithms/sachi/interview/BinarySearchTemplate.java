package interview;

public class BinarySearchTemplate {

    public static void main(String[] args) {

    }

    //Useful only when there will be absolute match
    //left <= right
    //left = mid + 1;
    //right = mid - 1;
    public int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
