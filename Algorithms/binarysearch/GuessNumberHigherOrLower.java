/*
https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println("Answer is :" + guessNumber(10) + " should be [].");
    }

    private static int guess(int i) {
        return 0;
    }

    public static int guessNumber(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int comp = guess(mid);
            if (comp == 0) return mid;
            if (comp > 0) start = mid + 1;
            else end = mid - 1;
        }
        return guess(start) == 0 ? start : -1;
    }
}
