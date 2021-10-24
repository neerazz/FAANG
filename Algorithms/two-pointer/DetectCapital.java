/**
 * Created on:  Aug 04, 2020
 * Questions: https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {
    public static void main(String[] args) {

    }

    public static boolean detectCapitalUse(String word) {
        boolean isLower = false;
        int i = 0;
        for (char cur : word.toCharArray()) {
            if (Character.isUpperCase(cur)) {
                if (isLower) return false;
            } else {
                if (!isLower && i > 1) return false;
            }
            isLower = Character.isLowerCase(cur);
            i++;
        }
        return true;
    }
}
