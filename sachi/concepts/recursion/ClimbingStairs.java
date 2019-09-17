import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(climbStairs(n));
        scanner.close();
    }

    private static int climbStairs(int n) {
        int[] stairs = {1, 2};
        int res = 0;
        if (n <= 1) return n;
        while (true) {
            int sum = 0;
            while (sum <= n) {

            }
        }
    }
}