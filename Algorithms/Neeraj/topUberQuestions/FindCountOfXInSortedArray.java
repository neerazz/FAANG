/**
 * Created on:  Nov 04, 2020
 * Questions: https://medium.com/javascript-in-plain-english/these-coding-problems-were-asked-by-uber-4cf366d9ef9b
 */

public class FindCountOfXInSortedArray {

    public static void main(String[] args) {
//        System.out.println(findCountOfXInSortedArray(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
//        System.out.println(findCountOfXInSortedArray(new int[]{2, 2, 2, 2}, 2));
        System.out.println(findCountOfXInSortedArray(new int[]{2, 2}, 2));
    }

    private static int findCountOfXInSortedArray(int[] nums, int tar) {
        int[] range = searchRange(nums, tar);
        return range[1] - range[0] + 1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = getIdx(nums, target, true);
        int right = getIdx(nums, target, false);
        return new int[]{left, right};
    }

    private static int getIdx(int[] nums, int target, boolean left) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (left) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(left){
            if (nums[start] == target) return start;
            return nums[end] == target ? end : -1;
        }else{
            if (nums[end] == target) return end;
            return nums[start] == target ? start : -1;
        }
    }
}
