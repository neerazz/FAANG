package RealAndMockInterview.pramp;
import java.util.Random;

public class Root {

    public static void main(String[] args) {
        tester();
    }

    public static void tester() {
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(1000);
            x = x + 1;
            int n = rand.nextInt(x);
            n = n + 1;
            double actual = root(x, n);
            double expected = Math.pow(x, 1.0 / n);
            if (expected - actual > 0.001) {
                System.out.println("x: " + x + " n: " + n);
                System.out.println("Failed. Actual:" + actual + "  Expected" + expected);
                break;
            } else {
                System.out.println("x: " + x + " n: " + n);
            }
        }
    }

    static double rootQuick(double x, int n) {
        double lb = 0, ub = Math.max(1, x);
        double aroot = (lb + ub) / 2;
        while (aroot - lb > 0.001) {
            if (Math.pow(aroot, n) > x) {
                ub = aroot;
            } else if (Math.pow(aroot, n) < x) {
                lb = aroot;
            } else {
                break;
            }
            aroot = (ub + lb) / 2;
        }
        return aroot;
    }

    static double root(double x, int n) {
        double start = 0, end = x;
        double mid = (start + end) / 2;
        while (mid - start > 0.001) {
            double prod = Math.pow(mid, n);
            if (prod > x) {
                end = mid;
            } else if (prod < x) {
                start = mid;
            } else {
                break;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }
}
