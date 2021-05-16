package weekly.weekly229;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {

    }

    public static int[] minOperations(String boxes) {
        int len = boxes.length(), opers[] = new int[len];
        for (int i = 0; i < len; i++) {
            int oper = 0;
            for (int j = 0; j < len; j++) {
                if (boxes.charAt(j) == '1') {
                    oper += Math.abs(j - i);
                }
            }
            opers[i] = oper;
        }
        return opers;
    }
}
