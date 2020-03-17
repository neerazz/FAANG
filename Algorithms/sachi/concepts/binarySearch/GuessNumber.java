import java.sql.SQLOutput;

public class GuessNumber {
    static long guessed = 9999999999L;

    public static void main(String[] args) {
        long toGuess = 999999999999999999L;

        long startTime = System.currentTimeMillis();
        System.out.println(guessNumber(toGuess));
        long endTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        System.out.println(guessNaive(toGuess));
        long endTime1 = System.currentTimeMillis();

        System.out.println("Quick guess : " + (endTime - startTime) / 1000);
        System.out.println("Naive guess : " + (endTime1 - startTime1) / 1000);

    }

    public static long guessNumber(long n) {
        long start = 1, end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g < 0) {       //move left
                end = mid - 1;
            } else {
                start = mid + 1;   //move right
            }
        }
        return -1;
    }

    private static int guess(long m) {
        return Long.compare(guessed, m);
    }

    public static long guessNaive(long n) {
        for (long i = 0; i <= n; i++) {
            if (i == guessed) return i;
        }
        return -1;
    }

}
