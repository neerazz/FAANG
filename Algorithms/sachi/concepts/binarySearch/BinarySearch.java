package concepts.binarySearch;

public class BinarySearch {

    /**
     * Return index of exact number - If it does not exist -> Return null
     *
     * @param arr    Input array
     * @param target - Target to find
     * @return - Index of found number
     */
    public Integer containsExact(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return null;
    }

    /**
     * If equal value is found - Return that index
     * If not return the index of closest value in the array
     *
     * @param arr
     * @param target
     * @return
     */
    public Integer closestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        int start = 0, end = arr.length - 1;
        int closestIndex = 0, closestValue = arr[closestIndex];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (Math.abs(target - arr[mid]) < Math.abs(target - closestValue)) {
                closestIndex = mid;
                closestValue = arr[closestIndex];
            }
            if (target == arr[mid]) {
                closestIndex = mid;
                closestValue = arr[mid];
                break;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return closestValue;
    }


}
