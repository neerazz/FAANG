import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {
    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> importance = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Employee emp : employees) {
            int empid = emp.id, imp = emp.importance;
            importance.put(empid, imp);
            map.put(empid, emp.subordinates);
        }
        return dfs(id, importance, map);
    }

    int dfs(int id, Map<Integer, Integer> imp, Map<Integer, List<Integer>> map) {
        int val = imp.get(id);
        for (int dep : map.getOrDefault(id, new ArrayList<>())) {
            val += dfs(dep, imp, map);
        }
        return val;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
