import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        int index = scanner.nextInt();
        System.out.println(myPowR(base, index));
        scanner.close();
    }

    public static double myPowR(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private static double fastPow(double x, long n){
        if(n==0) return 1.0;
        double half = fastPow(x,n/2);
        if(n%2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }

    /**
     * Brute Force approach
     * @param x
     * @param n
     * @return
     */
    private static double myPow(double x, int n) {
        int N = n;
        double ans = 1;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        for(int i=0; i<N; i++){
            ans = ans * x;
        }
        return ans;
    }
}