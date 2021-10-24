/**
 * Created on:  Jun 05, 2020
 * Questions:
 */
public class BusiestTimeInTheMall {
    static int findBusiestPeriod(int[][] data) {
        int count = 0, maxVal = 0, maxTime = 0, preTime = 0;
        for (int[] val : data) {
            int curTime = val[0], curVal = val[1], act = val[2];
            if (curTime != preTime) {
                // It is different
                // [[1487799425,21,0],[1487799427,22,1],[1487901318,7,0]]
                if (count > maxVal) {
                    maxVal = count;
                    maxTime = preTime;
                }
                preTime = curTime;
            }
            count += act == 1 ? curVal : -1 * curVal;
        }
        if (count > maxVal) {
            maxTime = preTime;
        }
        return maxTime;
    }

    public static void main(String[] args) {

    }
}
