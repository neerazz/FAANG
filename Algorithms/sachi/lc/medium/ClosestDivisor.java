import java.util.Arrays;

public class ClosestDivisor {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestDivisors(999)));
    }

    public static int[] closestDivisors(int num) {

        int num1 = num + 1;
        int num2 = num + 2;

        double sq1 = Math.sqrt(num1);
        int q1 = (int) sq1;
        if (sq1 % 1 == 0) {
            return new int[]{q1, q1};
        }
        double sq2 = Math.sqrt(num2);
        int q2 = (int) sq2;
        if (sq2 % 1 == 0) {
            return new int[]{q2, q2};
        }

        int a, b, c, d;

        while (true) {
            if (num1 % q1 == 0) {
                a = q1;
                b = num1 / q1;
                break;
            }
            q1--;
        }

        while (true) {
            if (num2 % q2 == 0) {
                c = q2;
                d = num2 / q2;
                break;
            }
            q2--;
        }

        if (Math.abs(a - b) > Math.abs(c - d)) {
            return new int[]{c, d};
        } else {
            return new int[]{a, b};
        }

    }
}
