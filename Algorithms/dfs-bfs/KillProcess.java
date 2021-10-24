import java.util.*;

/**
 * Created on:  Feb 15, 2021
 * Questions:
 */

public class KillProcess {

    public static void main(String[] args) {
        System.out.println(killProcess(Arrays.asList(6, 1, 3, 9, 5, 8, 7, 4, 10), Arrays.asList(5, 8, 4, 5, 10, 5, 3, 8, 0), 10));
    }

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> relation = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int cpid = pid.get(i), cppid = ppid.get(i);
            relation.computeIfAbsent(cppid, val -> new HashSet<>()).add(cpid);
        }
        List<Integer> killed = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        killed.add(kill);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            Set<Integer> deps = relation.get(poll);
            if (deps != null) {
                queue.addAll(deps);
                killed.addAll(deps);
            }
        }
        return killed;
    }
}
