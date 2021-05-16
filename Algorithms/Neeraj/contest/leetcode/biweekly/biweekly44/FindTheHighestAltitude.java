package biweekly.biweekly44;

/**
 * Created on:  Jan 24, 2021
 * Questions:
 */

public class FindTheHighestAltitude {

    public static void main(String[] args) {

    }
    public static int largestAltitude(int[] gain) {
        int pre = 0, max = 0;
        for(int curGain: gain){
            int cur = pre + curGain;
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }
}
