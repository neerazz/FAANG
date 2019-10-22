package BasicProgramming.InputOutput;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
You are given an integer N. You need to print the series of all prime numbers till N.
Input Format
The first and only line of the input contains a single integer N denoting the number till where you need to find the series of prime number.
Output Format: Print the desired output in single line separated by spaces.
Constraints: 1<=N<=1000
SAMPLE INPUT
9
SAMPLE OUTPUT
2 3 5 7
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getNPrimeNumbers(n).forEach(i -> System.out.print(i + " "));
    }

    private static Set<Integer> getNPrimeNumbers(int n) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 2; i < n + 1; i++) {
            nums.add(i);
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; i * j <= n; j++) {
                nums.remove(i * j);
            }
        }
        return nums;
    }
}
