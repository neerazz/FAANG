package weekly.weekly202;

/**
 * Created on:  Aug 15, 2020
 * Questions: https://leetcode.com/problems/three-consecutive-odds/
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {

    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum = (val & 1) == 1 ? sum + 1 : 0;
            if (sum >= 3) return true;
        }
        return false;
    }
}
