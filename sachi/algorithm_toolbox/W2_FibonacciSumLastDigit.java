public class W2_FibonacciSumLastDigit {

    //Given an integer 𝑛, find the last digit of the sum 𝐹0 +𝐹1 +···+𝐹𝑛.
    //SOL: F(0) + F(1) + F(2) + .... F(n-1) + F(n) = F(n+2) - 1
    //The last digit of the Fibonacci series repeats after F(60)
    //So calculate - F((n+2)%60)-1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSumQuick(n));
    }

    private static int getFibonacciSumQuick(long n) {
        if (n < 2) return (int) n;
        n = (n + 2) % 60;
        int a = 0, b = 1, c = 0;
        for (long i = 1; i < n; i++) {
            c = (a + b) % 10;
            a = b;
            b = c;
        }
        return c - 1;
    }

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current = 1;
        long sum = 1;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }
        return sum % 10;
    }
}

