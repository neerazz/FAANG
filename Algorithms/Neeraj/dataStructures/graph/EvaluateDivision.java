import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Sep 27, 2020
 * Questions: https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(calcEquation(
                Arrays.asList(
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "e"),
                        Arrays.asList("c", "d"),
                        Arrays.asList("e", "d")
                ), new double[]{2.0, 3.0, 0.5, 5.0},
                Arrays.asList(
                        Arrays.asList("a", "b")
                ))));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equ : equations) {
            if (!map.containsKey(equ.get(0))) {
                map.put(equ.get(0), idx++);
            }
            if (!map.containsKey(equ.get(1))) {
                map.put(equ.get(1), idx++);
            }
        }
        double[][] costs = new double[idx][idx];
        for (int i = 0; i < idx; i++) {
            Arrays.fill(costs[i], Double.MIN_NORMAL);
        }
        for (int i = 0; i < values.length; i++) {
            int fromIdx = map.get(equations.get(i).get(0));
            int toIdx = map.get(equations.get(i).get(1));
            costs[fromIdx][fromIdx] = costs[toIdx][toIdx] = 1;
            costs[fromIdx][toIdx] = values[i];
            costs[toIdx][fromIdx] = 1 / values[i];
        }
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                for (int k = 0; k < idx; k++) {
                    if (costs[j][i] == Double.MIN_NORMAL || costs[i][k] == Double.MIN_NORMAL) continue;
                    costs[j][k] = costs[j][i] * costs[i][k];
                }
            }
        }
        double[] op = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            int from = map.getOrDefault(query.get(0), -1), to = map.getOrDefault(query.get(1), -1);
            if (from == -1 || to == -1 || costs[from][to] == Double.MIN_NORMAL) {
                op[i] = -1.0;
            } else {
                op[i] = costs[from][to];
            }
        }
        return op;
    }
}
