package arraysAndString;

/*
https://leetcode.com/problems/count-primes/
Count the number of prime numbers less than a non-negative number, n.
Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10) + " should be [4].");
        System.out.println(countPrimes(499979) + " should be [4].");
    }

    //    Consider all the numbers as prime. And all take a cascading loop and set the i*j value as false.
    public static int countPrimes(int n) {
        if (n == 0) return 0;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (int j = 2; j * i < n; j++) {
                    primes[i * j] = true;
                }
            }
        }
        int primecount = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) primecount++;
        }
        return primecount;
    }
}
