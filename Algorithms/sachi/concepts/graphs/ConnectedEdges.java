import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConnectedEdges {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        //Create connections
        while (edges > 0) {
            int e1 = scanner.nextInt();
            int e2 = scanner.nextInt();
            map.putIfAbsent(e1, new ArrayList<>());
            map.get(e1).add(e2);
            edges--;
        }
        int queries = scanner.nextInt();
        while (queries > 0) {
            int q1 = scanner.nextInt();
            int q2 = scanner.nextInt();
            boolean found = false;
            if (map.containsKey(q1)) {
                List<Integer> list = map.get(q1);
                found = list.contains(q2);
            } else if (map.containsKey(q2)) {
                List<Integer> list = map.get(q2);
                found = list.contains(q1);
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            queries--;
        }
    }

}
