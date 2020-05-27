/**
 * Created on:  May 25, 2020
 * Questions: https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjzN4
 */
public class RootOfNumber {
    static double root(double x, int n) {
        if (n == 1) return x;
        return sqrtOfX(0, x, x, n);
    }

    static double sqrtOfX(double start, double end, double x, int n) {
        while (start < end) {
            double mid = start + (end - start) / 2;
            double midPower = getPower(mid, n);
            if (Math.abs(x - midPower) < 0.001) {
                return mid;
            } else if (midPower > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1.0;
    }

    static double getPower(double x, int n) {
        double op = 1;
        for (int i = 0; i < n; i++) {
            op *= x;
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(root(7, 3) + " should be [1.913]");
        System.out.println(root(9, 2) + " should be [3]");
        System.out.println(root(10, 3) + " should be [2.154]");
        System.out.println(root(4, 2) + " should be [2]");
        System.out.println(root(27, 3) + " should be [3]");
        System.out.println(root(16, 4) + " should be [2]");
        System.out.println(root(160, 3) + " should be [5.429]");
    }
}
