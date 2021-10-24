/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/add-digits/
 */
public class AddDigits {
    public static void main(String[] args) {

    }

    //     https://leetcode.com/articles/add-digits/
    public static int addDigits_optimal(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }

    public static int addDigits(int num) {
        while (num > 9) {
            int cur = 0;
            while (num > 0) {
                cur += num % 10;
                num /= 10;
            }
            num = cur;
        }
        return num;
    }
}
