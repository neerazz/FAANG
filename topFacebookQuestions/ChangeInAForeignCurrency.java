/**
 * Created on:  Sep 08, 2020
 * Questions:
 */
public class ChangeInAForeignCurrency {
    public static void main(String[] args) {

    }

    private static boolean helper(int target, int[] denominations, Boolean[] dp) {
        if (target < 0) return false;
        if (target == 0) return true;
        if (dp[target] != null) return dp[target];
        for (int cur : denominations) {
            if (helper(target - cur, denominations, dp)) {
                return dp[target] = true;
            }
        }
        return dp[target] = false;
    }


    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        Boolean[] dp = new Boolean[targetMoney + 1];
        return helper(targetMoney, denominations, dp);
    }
}
