package weekly.weekly199;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/bulb-switcher-iv/
 */
public class BulbSwitcherIV {
    public static void main(String[] args) {

    }

    public int minFlips(String target) {
        int pre = 0, change = 0;
        for (char c : target.toCharArray()) {
            if (c - '0' != pre) {
                change++;
            }
            pre = c - '0';
        }
        return change;
    }
}
