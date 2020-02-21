package firecode.level1;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2, 5, 7, 8, 9}, 9));
        System.out.println(binarySearch(new int[]{2, 8, 9, 12}, 6));
        System.out.println(binarySearch(new int[]{2}, 4));
        System.out.println(binarySearch(new int[]{}, 9));
    }

    public static Boolean binarySearch(int[] arr, int n) {
        if (arr.length == 0) return false;
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            int middleValue = arr[middle];
            if (middleValue > n) end = middle;
            else if (middleValue < n) start = middle + 1;
            else return true;
        }
        return arr[start] == n;
    }
}
