/**
 * Created on:  Mar 09, 2021
 * Questions: https://leetcode.com/problems/count-numbers-with-unique-digits/
 */

public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return countNumbersWithUniqueDigits(10);
//        Now calculate the possible ways a number can be formed with n digits.
        int poss = 9, count = 1;
        for (int digit = 0; digit < n; digit++) {
//            You start with 9 possibilities (0 cannot be placed, because 01 is not a number with 2 digit it is number with 1 digit),
//              After get the number of possibilities you can place a number, you need to keep reducing a possibility,
//              because the number that was used in in current position should not be used again.
            if (digit == 0) count *= 9;
            else count *= poss--;
//            Other key thing to consider, is that first digit and second digit can have 9, possibilities.
//              Because 0 is not a valid number for first digit,
//              But 0 is a valid number for all digits after 1 to n.
        }
        System.out.println("Count at " + n + " digits is : " + count);
//        Now, count will have the number of ways to form n digit, add that to number of ways we can form an (n-1)  digit.
        return count + countNumbersWithUniqueDigits(n - 1);
    }
}
