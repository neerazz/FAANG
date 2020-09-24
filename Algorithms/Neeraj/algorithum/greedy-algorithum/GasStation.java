public class GasStation {
    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 **************************");
        System.out.println(canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(
                new int[]{3, 3, 4},
                new int[]{3, 4, 4}));
        System.out.println(canCompleteCircuit(
                new int[]{4, 5, 2, 6, 5, 3},
                new int[]{3, 2, 7, 3, 2, 9}));
        System.out.println(canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(
                new int[]{2},
                new int[]{2}));

        System.out.println("*************************** Solution 2 **************************");
        System.out.println(canCompleteCircuit_rev(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit_rev(
                new int[]{3, 3, 4},
                new int[]{3, 4, 4}));
        System.out.println(canCompleteCircuit_rev(
                new int[]{4, 5, 2, 6, 5, 3},
                new int[]{3, 2, 7, 3, 2, 9}));
        System.out.println(canCompleteCircuit_rev(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit_rev(
                new int[]{2},
                new int[]{2}));
    }

    public static int canCompleteCircuit_rev(int[] gas, int[] cost) {
        int len = gas.length, gasSum = 0, costSum = 0, tank = 0, start = 0;
        for (int i = 0; i < len; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
//                You cannot start from any previous points and reach here.
                tank = 0;
                start = i + 1;
            }
        }
        return gasSum >= costSum ? start : -1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i] && backTracing(gas, cost, i + 1, 1, gas[i])) {
                return i;
            }
        }
        return -1;
    }

    private static boolean backTracing(int[] gas, int[] cost, int index, int totalCovered, int tank) {
        if (totalCovered == gas.length) return true;
        if (index >= gas.length) index = 0;
        int prevIndex = index - 1 < 0 ? gas.length - 1 : index - 1;
        tank = tank - cost[prevIndex] + gas[index];
        if (tank >= cost[index]) {
            return backTracing(gas, cost, index + 1, totalCovered + 1, tank);
        }
        return false;
    }
}
