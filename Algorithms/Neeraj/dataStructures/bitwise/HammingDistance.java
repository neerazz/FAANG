/**
 * Created on:  Jul 05, 2020
 * Questions:
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println("************************************ Solution 1 ********************************");
        System.out.println(hammingDistance(1, 4) + " should be [2]");
        System.out.println(hammingDistance(2173896, 2173796) + " should be [4]");
        System.out.println("************************************ Solution 2 ********************************");
        System.out.println(hammingDistance_optimal(1, 4) + " should be [2]");
        System.out.println(hammingDistance_optimal(2173896, 2173796) + " should be [4]");
    }

    public static int hammingDistance_optimal(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }

    public static int hammingDistance(int x, int y) {
        String v1 = getBinary(x), v2 = getBinary(y);
        int l1 = v1.length(), l2 = v2.length();
        int p1 = 0, p2 = 0;
        int result = 0;
        while (p1 < l1 || p2 < l2) {
            char c1 = p1 < l1 ? v1.charAt(p1) : '0';
            char c2 = p2 < l2 ? v2.charAt(p2) : '0';
            if (c1 != c2) result++;
            p1++;
            p2++;
        }
        return result;
    }

    private static String getBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2 == 0 ? 0 : 1);
            num = num >> 1;
        }
        return sb.toString();
    }
}
