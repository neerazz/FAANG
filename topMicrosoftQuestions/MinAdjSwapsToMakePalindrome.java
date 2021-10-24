/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/351783/
 */

public class MinAdjSwapsToMakePalindrome {

    public static void main(String[] args) {
        System.out.println(String.format("%d expected %d", minSwaps("mamad"), 3));
        System.out.println(String.format("%d expected %d", minSwaps("asflkj"), -1));
        System.out.println(String.format("%d expected %d", minSwaps("aabb"), 2));
        System.out.println(String.format("%d expected %d", minSwaps("ntiin"), 1));
    }

    private static int minSwaps(String str) {
        if (!canFormPalindrome(str)) return -1;
        int swaps = 0;
        char[] chars = str.toCharArray();
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (chars[s] != chars[e]) {
//                Lop from the end and find the char at start index
                int temp = e;
                while (temp > s && chars[s] != chars[temp]) {
                    temp--;
                }
                if (temp == s) {
//                    if the start element is again found at start index. Then swap the start element to the next value.
                    char tempC = chars[s];
                    chars[s] = chars[s + 1];
                    chars[s + 1] = tempC;
                    swaps++;
                } else {
//                Swap the char from temp till the end.
                    while (temp < e) {
                        chars[temp] = chars[temp + 1];
                        swaps++;
                        temp++;
                    }
                    chars[e] = chars[s];
                    s++;
                    e--;
                }
            } else {
                s++;
                e--;
            }
        }
        return swaps;
    }

    private static boolean canFormPalindrome(String str) {
        int[] counts = new int[26];
        int odd = 0;
        for (char cur : str.toCharArray()) {
            counts[cur - 'a']++;
        }
        boolean oddLength = str.length() % 2 == 1;
        for (int val : counts) {
            if (val % 2 == 0) continue;
            if (oddLength) oddLength = false;
            else return false;
        }
        return true;
    }
}
