package RealAndMockInterview.pramp;

public class ArrayIndexEquality {

    static int indexEqualsValueSearch(int[] arr) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == mid && (mid == 0 || arr[mid - 1] == mid - 1)) {
                return mid;
            } else if (mid > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
