/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=951929261870357
 */

public class BillionUsersDay {

    static int billion = 1_000_000_000;

    public static void main(String[] args) {
        System.out.println(getBillionUsersDay(new float[]{1.5f}));

        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
    }

    static int getBillionUsersDay(float[] growthRates) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canReachBillion(growthRates, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean canReachBillion(float[] growthRates, int days) {
        double users = 0;
        for (float rate : growthRates) {
            users += Math.pow(rate, days);
        }
        return users >= billion;
    }
}
