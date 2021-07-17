package concepts.binarySearch;

import util.Util;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class BinaryTester {

    static BinarySearch binarySearch = new BinarySearch();

    public static void main(String[] args) {
        testBinaryClosest();
        //testBinarySearch();
    }

    /**
     * Test Binary Search Function
     */
    public static void testBinarySearch() {
        //Test Binary Search Function
        while (true) {
            int[] arr = Util.generateRandomArray();
            Arrays.sort(arr);
            if (arr.length == 0) continue;
            Random random = new Random();
            int randIndex = random.nextInt(arr.length);
            int target = arr[randIndex];
            Integer actual = binarySearch.containsExact(arr, target);
            if (actual != null && arr[actual] != target) {
                System.out.println("Failed for Input -> \n" + Arrays.toString(arr));
                System.out.println("Target: " + target + " Expected: " + randIndex + " Actual: " + actual);
                break;
            }
        }
    }

    public static void testBinaryClosest() {
        boolean twoPossiblities;
        while (true) {
            twoPossiblities = false;
            int[] arr = Util.generateRandomArray();
            Arrays.sort(arr);
            if (arr.length == 0) continue;
            Random random = new Random();
            int randIndex = random.nextInt(arr.length);
            int target = arr[randIndex] + random.nextInt(20);

            //Find Expected
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int value : arr) {
                treeSet.add(value);
            }
            Integer small = treeSet.floor(target);
            Integer large = treeSet.ceiling(target);
            small = small == null ? 0 : small;
            large = large == null ? 0 : large;
            int expected = -1;
            if (target > arr[arr.length - 1]) {
                expected = arr[arr.length - 1];
            } else if (target < arr[0]) {
                expected = arr[0];
                twoPossiblities = false;
            } else if (Math.abs(target - small) == Math.abs(target - large)) {
                twoPossiblities = true;
            } else {
                expected = Math.abs(target - small) >= Math.abs(target - large) ? large : small;
                twoPossiblities = false;
            }
            //Find Actual
            int actual = binarySearch.closestValue(arr, target);
            //Check
            if (!twoPossiblities &&  expected != actual) {
                System.out.println("Failed for Input -> \n" + Arrays.toString(arr));
                System.out.println("Target: " + target + " Expected: " + expected + " Actual: " + actual);
                break;
            } else  if(actual != small || actual != large){
                System.out.println("Failed for Input -> \n" + Arrays.toString(arr));
                System.out.println("Target: " + target + " Expected: " + expected + " Actual: " + actual);
                break;            }
        }
    }

}
