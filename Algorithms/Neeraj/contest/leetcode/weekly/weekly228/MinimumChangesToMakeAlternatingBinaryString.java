package weekly.weekly228;

/**
 * Created on:  Feb 13, 2021
 * Questions:
 */

public class MinimumChangesToMakeAlternatingBinaryString {

    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
        System.out.println(minOperations("110010"));
    }

    public static int minOperations(String s) {
        int even = 0, odd = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (i % 2 == 0) {
                even += cur == '0' ? 0 : 1;
                odd += cur == '1' ? 0 : 1;
            } else {
                even += cur == '0' ? 1 : 0;
                odd += cur == '1' ? 1 : 0;
            }
        }
        return Math.min(even, odd);
    }
}
