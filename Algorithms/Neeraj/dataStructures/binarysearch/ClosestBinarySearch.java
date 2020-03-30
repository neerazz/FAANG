import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class ClosestBinarySearch {
    public static void main(String[] args) {
        System.out.println("************************ Closest Value ************************");
        System.out.println(findClosestValueInBst(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 10) + " should be [9]");
        System.out.println(findClosestValueInBst(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [1 or 3]");
        System.out.println(findClosestValueInBst(new int[]{-1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [3]");
        System.out.println(findClosestValueInBst(new int[]{1, 4, 5, 7, 9, 12, 16, 19}, 2) + " should be [1]");
        System.out.println(findClosestValueInBst(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 7) + " should be [7]");
        System.out.println("------------------- Start Random Testing -----------------------");
        TestCode.testFindClosestValueInBst();
        System.out.println("-------------------  End Random Testing  -----------------------");
        System.out.println("************************ Closest Smallest Value ************************");
        System.out.println(findLowestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 11) + " should be [9]");
        System.out.println(findLowestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [1]");
        System.out.println(findLowestClosestValue(new int[]{-1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [-1]");
        System.out.println(findLowestClosestValue(new int[]{1, 4, 5, 7, 9, 12, 16, 19}, 2) + " should be [1]");
        System.out.println(findLowestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 7) + " should be [7]");
        System.out.println("------------------- Start Random Testing -----------------------");
        TestCode.testFindLowestClosestValue();
        System.out.println("-------------------  End Random Testing  -----------------------");
        System.out.println("************************ Closest Largest Value ************************");
        System.out.println(findHighestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 10) + " should be [12]");
        System.out.println(findHighestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [3]");
        System.out.println(findHighestClosestValue(new int[]{-1, 3, 5, 7, 9, 12, 16, 19}, 2) + " should be [3]");
        System.out.println(findHighestClosestValue(new int[]{1, 4, 5, 7, 9, 12, 16, 19}, 2) + " should be [4]");
        System.out.println(findHighestClosestValue(new int[]{1, 3, 5, 7, 9, 12, 16, 19}, 7) + " should be [7]");
        System.out.println("------------------- Start Random Testing -----------------------");
        TestCode.testFindHighestClosestValueInBst();
        System.out.println("-------------------  End Random Testing  -----------------------");
    }

    static int closestHighest;
    private static int findHighestClosestValue(int[] arr, int target) {
        closestHighest = Integer.MAX_VALUE;
        closestHighestHelper(arr, 0, arr.length - 1, target);
        return closestHighest == Integer.MAX_VALUE ? -1 : closestHighest;
    }

    //    Ex: [1,3,5,7,9,12,16,19], target = 10, ans = 9
//             0 1 2 3 4  5  6  7
//    s=0, e=7, m=3, mv=7 -> Move right
//    s=4, e=7, m=5, mv=12 -> Move left
//    s=4, e=4, m=4, mv=9 -> Move right
//    s=5, e=4, -> Exit
    private static void closestHighestHelper(int[] arr, int start, int end, int target) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        int midV = arr[mid];
        if (midV < closestHighest && midV >= target && Math.abs(closestHighest - target) > Math.abs(target - midV)) {
            closestHighest = midV;
        }
        if (midV == target) return;
        if (midV < target) {
//            If mid value smaller then target move right
            closestHighestHelper(arr, mid + 1, end, target);
        } else {
//            If mid value is greater than target then move left
            closestHighestHelper(arr, start, mid - 1, target);
        }
    }

    static int closestSmallest;
    private static int findLowestClosestValue(int[] arr, int target) {
        closestSmallest = Integer.MIN_VALUE;
        closestSmallestHelper(arr, 0, arr.length - 1, target);
        return closestSmallest == Integer.MIN_VALUE ? -1 : closestSmallest;
    }

    //    Ex: [1,3,5,7,9,12,16,19], target = 11, ans = 9
//             0 1 2 3 4  5  6  7
//    s=0, e=7, m=3, mv=7 -> Move right
//    s=4, e=7, m=5, mv=12 -> Move left
//    s=4, e=4, m=4, mv=9 -> Move right
//    s=5, e=4, -> Exit
    private static void closestSmallestHelper(int[] arr, int start, int end, int target) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        int midV = arr[mid];
        if (midV > closestSmallest && midV <= target && Math.abs(closestSmallest - target) > Math.abs(target - midV)) {
            closestSmallest = midV;
        }
        if (midV == target) return;
        if (midV < target) {
//            If mid value smaller then target move right
            closestSmallestHelper(arr, mid + 1, end, target);
        } else {
//            If mid value is greater than target then move left
            closestSmallestHelper(arr, start, mid - 1, target);
        }
    }


    static int closest;

    public static int findClosestValueInBst(int[] arr, int target) {
        closest = Integer.MAX_VALUE;
        if (arr == null || arr.length == 0) return -1;
        closestHelper(arr, 0, arr.length - 1, target);
        return closest == Integer.MAX_VALUE ? -1 : closest;
    }

    //    Ex: [1,3,5,7,9,12,16,19], target = 2, ans = 1
//         0 1 2 3 4  5  6  7
//    s=0, e=7, m=3, mv=7 -> Move left
//    s=0, e=2, m=1, mv=1 -> Move left
//    s=0, e=0, m=0, mv=1 -> Move right
//    s=1, e=0, -> Exit
    private static void closestHelper(int[] arr, int start, int end, int target) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        int midV = arr[mid];
        if (Math.abs(closest - target) > Math.abs(target - midV)) {
            closest = midV;
        }
        if (midV == target) return;
        if (midV < target) {
//            If mid value smaller then target move right
            closestHelper(arr, mid + 1, end, target);
        } else {
//            If mid value is greater than target then move left
            closestHelper(arr, start, mid - 1, target);
        }
    }

    static class TestCode {
        static Random random = new Random();

        static int[] getRandomArray() {
            int len = random.nextInt(1000);
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = random.nextInt(999999999);
            }
            return arr;
        }

        static void testFindHighestClosestValueInBst() {
            for (int i = 1; i <= 50; i++) {
                testFindHighestClosestValueInBstIndividual(i);
            }
        }

        static void testFindHighestClosestValueInBstIndividual(int test) {
            int[] input = getRandomArray();
            Arrays.sort(input);
            TreeSet<Integer> set = new TreeSet<>();
            for (int i : input) {
                set.add(i);
            }
            int randomIDX = random.nextInt(input.length > 0 ? input.length-1 : 0);
            int randomValue = input[randomIDX] +10;
            Integer ceiling = set.ceiling(randomValue);
            int closestValueInBst = ClosestBinarySearch.findHighestClosestValue(input, randomValue);
            if (ceiling != null && closestValueInBst == ceiling) {
                System.out.println("Passed test case:" + test);
            } else {
                System.out.println("Test Case Failed:" + test);
            }
            System.out.println("Array   :\t" + Arrays.toString(input));
            System.out.println("Target  :\t" + randomValue);
            System.out.println("Actual  :\t" + closestValueInBst);
            System.out.println("Expected:\t" + ceiling);
        }

        static void testFindLowestClosestValue() {
            for (int i = 1; i <= 50; i++) {
                testFindLowestClosestValueIndividual(i);
            }
        }

        static void testFindLowestClosestValueIndividual(int test) {
            int[] input = getRandomArray();
            Arrays.sort(input);
            TreeSet<Integer> set = new TreeSet<>();
            for (int i : input) {
                set.add(i);
            }
            int randomIDX = random.nextInt(input.length > 0 ? input.length-1 : 0);
            int randomValue = input[randomIDX] +10;
            Integer floor = set.floor(randomValue);
            int closestValueInBst = ClosestBinarySearch.findLowestClosestValue(input, randomValue);
            if (floor != null && closestValueInBst == floor) {
                System.out.println("Passed test case:" + test);
            } else {
                System.out.println("Test Case Failed:" + test);
            }
            System.out.println("Array   :\t" + Arrays.toString(input));
            System.out.println("Target  :\t" + randomValue);
            System.out.println("Actual  :\t" + closestValueInBst);
            System.out.println("Expected:\t" + floor);
        }

        static void testFindClosestValueInBst() {
            for (int i = 1; i <= 50; i++) {
                testFindClosestValueInBstIndividual(i);
            }
        }

        static void testFindClosestValueInBstIndividual(int test) {
            int[] input = getRandomArray();
            Arrays.sort(input);
            TreeSet<Integer> set = new TreeSet<>();
            for (int i : input) {
                set.add(i);
            }
            int randomIDX = random.nextInt(input.length > 0 ? input.length-1 : 0);
            int randomValue = input[randomIDX] +10;
            Integer ceiling = set.ceiling(randomValue);
            Integer floor = set.floor(randomValue);
            int closestValueInBst = ClosestBinarySearch.findClosestValueInBst(input, randomValue);
            if (ceiling != null && closestValueInBst == ceiling) {
                System.out.println("Passed test case:" + test);
            } else if (floor != null && closestValueInBst == floor) {
                System.out.println("Passed test case:" + test);
            } else {
                System.out.println("Test Case Failed:" + test);
            }
            System.out.println("Array   :\t" + Arrays.toString(input));
            System.out.println("Target  :\t" + randomValue);
            System.out.println("Actual  :\t" + closestValueInBst);
            System.out.println("Expected:\t" + ceiling + " or " + floor);
        }
    }
}
