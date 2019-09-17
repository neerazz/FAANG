//Given two integers 𝑎 and 𝑏, find their least common multiple.
//SOL: LCM(a,b) = a*b / GCD(a,b)

//Do LCM of three
//DO HCF and others
//DO GCD of three

public class W2_LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(lcm_quick(a, b));
        scanner.close();
        //test();
    }

    private static long lcm_quick(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        if (b == 0) return 1;
        if (a == 0) return 1;
        long rem = a % b;
        if (rem == 0) {
            return b;
        }
        return gcd(b, rem);
    }

    private static void test() {
        while (true) {
            int a = (int) (Math.random() * 4543);
            int b = (int) (Math.random() * 9876);
            long startTime1 = System.nanoTime();
            int sol1 = (int) lcm_naive(a, b);
            long endTime1 = System.nanoTime();
            long startTime2 = System.nanoTime();
            int sol2 = (int) lcm_quick(a, b);
            long endTime2 = System.nanoTime();
            if (sol1 == sol2) {
                System.out.println("Ok for " + a + " " + b + " Slow time: " + (endTime1 - startTime1) + " Fast Time: " + (endTime2 - startTime2));
            } else {
                System.out.println("Failed for " + a + " " + b);
                System.out.println("Naive " + sol1 + " Fast" + sol2);
                break;
            }

        }
    }


}
