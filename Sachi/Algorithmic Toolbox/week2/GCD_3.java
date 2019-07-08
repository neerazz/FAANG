import java.util.Scanner;

//Given two integers 𝑎 and 𝑏, find their greatest common divisor.
public class GCD_3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(findGCd(a, b));
        //test();
    }

    private static long findGCd(int a, int b) {
        if (b == 0) return 1;
        if (a == 0) return 1;
        int rem = a % b;
        if (rem == 0) {
            return b;
        }
        return findGCd(b, rem);
    }

    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }
        return current_gcd;
    }

    private static void test() {
        while (true) {
            int a = (int) (Math.random() * 11);
            int b = (int) (Math.random() * 105636389);
            int sol1 = gcd_naive(a, b);
            int sol2 = (int) findGCd(a, b);
            if (sol1 == sol2) {
                System.out.println("Ok for " + a + " " + b);
            } else {
                System.out.println("Failed for " + a + " " + b);
                System.out.println("Naive " + sol1 + " Fast" + sol2);
                break;
            }

        }
    }

}
