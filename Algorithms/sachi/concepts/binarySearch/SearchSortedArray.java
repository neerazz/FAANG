package concepts.binarySearch;

public class SearchSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5},0));
    }

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int start = 0, end = nums.length - 1, shiftIndex = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid + 1] < nums[mid]) {
                shiftIndex = mid + 1;
                break;
            } else if (nums[mid] > nums[start]) { //Go right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(shiftIndex == 0){
            //Search whole array
            return binSearch(nums, 0, nums.length-1, target);
        }else if (target == nums[shiftIndex]) {
            return shiftIndex;
        } else if (target >= nums[0]) {
            //Search left
            return binSearch(nums, 0, shiftIndex-1, target);
        } else {
            //Search right
            return binSearch(nums, shiftIndex, nums.length-1, target);
        }

    }

    public static int binSearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
