package weekly.weekly241;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-241/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 */

public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {

    public static void main(String[] args) {
        System.out.println(minSwaps("111000") + " = 1");
        System.out.println(minSwaps("010") + " = 0");
        System.out.println(minSwaps("1110") + " = -1");
        System.out.println(minSwaps("1110000000100001010100101010000101010101001000001110101000010111101100000111110001000111010111101100001100001001100101011110100011111100000000100011111011110111111011110111010100111101011111111101101100101010110000011110110100101111000100000001100000")
                + " = 60");
        System.out.println(minSwaps("00011110110110000000000110110101011101111011111101010010010000000000000001101101010010001011110000001101111111110000110101101101001011000011111011101101100110011111110001100110001110000000001100010111110100111001001111100001000110101111010011001")
                + " = 65");
    }

    public static int minSwaps(String s) {
        int[] counts = {0, 0};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - '0']++;
        }
        if (Math.abs(counts[0] - counts[1]) > 1) return -1;
        return Math.min(helper(s, 0), helper(s, 1));
    }

    private static int helper(String s, int start) {
        int[] nonMatching = {0, 0};
//        LinkedList<Integer>[] nonMatching = new LinkedList[]{new LinkedList<Integer>(), new LinkedList<>()};
        int expected = start;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
//            if (cur != expected) nonMatching[cur].add(i);
            if (expected != cur) nonMatching[cur]++;
            expected ^= 1;
        }
//        System.out.println("Starting = " + Arrays.toString(nonMatching));
        return nonMatching[0] == nonMatching[1] ? nonMatching[0] : Integer.MAX_VALUE;
//        System.out.println("Starting = " + Arrays.stream(nonMatching).map(LinkedList::size).collect(Collectors.toList()));
//        return Math.max(nonMatching[0].size(), nonMatching[1].size());
    }
}
