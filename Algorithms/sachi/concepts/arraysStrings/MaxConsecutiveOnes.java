package concepts.arraysStrings;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(findMaxConsecutiveOnes(input));
        scanner.close();
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, prevMax = 0;
        for (int num : nums) {
            if (num == 1) {
                res++;
            } else {
                prevMax = prevMax <= res ? res : prevMax;
                res = 0;
            }
        }
        return prevMax > res ? prevMax : res;
    }
}