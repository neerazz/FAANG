package weekly.weekly201;

/**
 * Created on:  Aug 08, 2020
 * Questions:
 */
public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1) + " = 0");
        System.out.println(findKthBit(4, 11) + " = 1");
        System.out.println(findKthBit(1, 1) + " = 0");
        System.out.println(findKthBit(2, 3) + " = 1");
    }

    public static int findKthNumber(int n, int k) {
        if (n == 1) return 0;
        if (n == 2) {
            if (k == 0) return 0;
            else return 1;
        }
        int len = (int) (Math.pow(2, n) - 1);
        if (k == len / 2) return 1;
        else if (k < len / 2) {
            return findKthNumber(n - 1, k);
        } else {
            return 1 ^ findKthNumber(n - 1, len - k - 1);
        }
    }

    public static char findKthBit(int n, int k) {
        return (char) ('0' + findKthNumber(n, k - 1));
    }
}
