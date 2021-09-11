/*
https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthdayCakeCandles {
    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(new int[]{3, 2, 1, 3}) + " should be 2");
    }

    static int birthdayCakeCandles(int[] ar) {
        int output = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max, ar[i]);
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == max)
                output++;
        }
        return output;
    }
}
