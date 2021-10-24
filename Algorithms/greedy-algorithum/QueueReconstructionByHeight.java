import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        System.out.println("************************** Solution 1 ****************************");
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));

        System.out.println("************************** Solution 2 ****************************");
        System.out.println(Arrays.deepToString(reconstructQueue_rev1(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }

    public static int[][] reconstructQueue_rev1(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[0][2]);
    }

    public static int[][] reconstructQueue(int[][] people) {
//        Sort the heights in descending order of height and ascending order of people in queue with same or above height.
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0]) ? n1[1] - n2[1] : n2[0] - n1[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[0][2]);
    }
}
