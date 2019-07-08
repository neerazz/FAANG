import java.util.Scanner;

//Given an integer 𝑛, find the last digit of the 𝑛th Fibonacci number 𝐹𝑛 (that is, 𝐹𝑛 mod 10).

public class LastDigitOfFibanoci_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciLastDigitFast(n));
		/*while(true){
			int n =  (int) (Math.random() * 150);
			int sol1 = calc_lastF(n);
			int sol2 =  getFibonacciLastDigitNaive(n);
			if(sol1 == sol2){
				System.out.println("Ok for n :" + n);
			}else{
				System.out.println("Failed for n :" + n + " Naive: " + sol2 + " Fast:" + sol1);
				break;
			}
		}*/
    }


    private static int getFibonacciLastDigitFast(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int f = 0, s = 1, sum = 0;
        for (long i = 2; i <= n; i++) {
            sum = f + s;
            if (sum > 9) {
                sum = sum % 10;
            }
            f = s;
            s = sum;
        }
        return s;
    }

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current = 1;
        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return (int) (current % 10);
    }


}
