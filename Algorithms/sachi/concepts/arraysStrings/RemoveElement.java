package concepts.arraysStrings;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(removeElement(input, val));
        scanner.close();
    }

    // When not equal, keep counting and replace the last known value.
    // Because you do not care what happens to the array
    private static int removeElement(int[] nums, int val) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }
}