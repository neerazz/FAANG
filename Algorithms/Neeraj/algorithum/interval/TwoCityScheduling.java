import java.util.Arrays;

/**
 * Created on:  Jun 03, 2020
 * Questions: https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}) + " should be [110].");
        System.out.println(twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}) + " should be [1859].");
    }

    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (v1, v2) -> Integer.compare(v1[0] - v1[1], v2[0] - v2[1]));
        int sum = 0, n = costs.length;
        for (int i = 0; i < n / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            sum += costs[i][1];
        }
        return sum;
    }
}
