package weekly.weekly213;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-213/problems/kth-smallest-instructions/
 */

public class KthSmallestInstructions {

    //    static List<String> path;
    static int count;
    static String result;

    public static void main(String[] args) {
        System.out.println(kthSmallestPath(new int[]{2, 3}, 1));
        System.out.println(kthSmallestPath(new int[]{2, 3}, 2));
        System.out.println(kthSmallestPath(new int[]{2, 3}, 3));
        System.out.println(kthSmallestPath(new int[]{15, 15}, 155117520));
    }

    public static String kthSmallestPath(int[] destination, int k) {
        int rows = destination[0], cols = destination[1];
//        path = new ArrayList<>();
        count = 0;
        result = "";
        helper(0, 0, rows, cols, "", k);
//        return path.get(path.size() - 1);
        return result;
    }

    private static void helper(int row, int col, int rows, int cols, String soFar, int k) {
//        if (path.size() >= k) return;
        if (count >= k) return;
        if (row == rows && col == cols) {
//            path.add(soFar);
            count++;
            if (count == k) result = soFar;
            return;
        }
        if (col < cols) {
//            Keep moving towards the right
            helper(row, col + 1, rows, cols, soFar + "H", k);
        }
        if (row < rows) {
            helper(row + 1, col, rows, cols, soFar + "V", k);
        }
    }
}
