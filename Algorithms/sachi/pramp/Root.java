public class Root {

    public static void main(String[] args) {
        System.out.println(rootQuick(11, 2));
        System.out.println(root(11, 2));
        System.out.println("Actual: " + Math.sqrt(11));
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
