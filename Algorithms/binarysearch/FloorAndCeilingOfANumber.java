/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/qA5wW7R8ox7
 */

public class FloorAndCeilingOfANumber {

    public static int searchFloorOfANumber(int[] arr, int key) {
        int start = 0, end = arr.length - 1, floor = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) {
                floor = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floor;
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) start = mid + 1;
            else end = mid;
        }
        if (arr[start] >= key) return start;
        return arr[end] >= key ? end : -1;
    }

    public static void main(String[] args) {
        System.out.println("*********************** Floor ***************************");
        System.out.println(searchFloorOfANumber(new int[]{4, 6, 10}, 6));
        System.out.println(searchFloorOfANumber(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchFloorOfANumber(new int[]{4, 6, 10}, 17));
        System.out.println(searchFloorOfANumber(new int[]{4, 6, 10}, -1));
        System.out.println(searchFloorOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
        System.out.println(searchFloorOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 20));
        System.out.println(searchFloorOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 0));
        System.out.println("*********************** Ceiling ***************************");
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, 6));
        System.out.println(searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, 17));
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, -1));
        System.out.println(searchCeilingOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
        System.out.println(searchCeilingOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 20));
        System.out.println(searchCeilingOfANumber(new int[]{1, 2, 8, 10, 10, 12, 19}, 0));
    }
}
