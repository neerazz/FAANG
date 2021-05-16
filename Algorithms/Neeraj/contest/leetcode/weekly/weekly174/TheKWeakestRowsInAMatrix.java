package weekly.weekly174;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

Example 1:
Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers for each row is:
row 0 -> 2
row 1 -> 4
row 2 -> 1
row 3 -> 2
row 4 -> 5
Rows ordered from the weakest to the strongest are [2,0,3,1,4]
Example 2:
Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers for each row is:
row 0 -> 1
row 1 -> 4
row 2 -> 1
row 3 -> 1
Rows ordered from the weakest to the strongest are [0,2,3,1]

Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
 */
public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2)));
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3)));
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = row> 0 ? mat[0].length : 0;
        PriorityQueue<Soldier> queue = new PriorityQueue<>();
        for (int i = 0; i < row; i++) {
            queue.add(new Soldier(i, Arrays.stream(mat[i]).boxed().mapToInt(Integer::intValue).sum()));
        }
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = queue.poll().row;
        }
        return output;
    }
    static class Soldier implements Comparable{
        Integer row;
        Integer soldiers;

        public Soldier(Integer row, Integer soldiers) {
            this.row = row;
            this.soldiers = soldiers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Soldier soldier = (Soldier) o;

            if (row != soldier.row) return false;
            return soldiers == soldier.soldiers;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + soldiers;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            Soldier source = (Soldier) o;
            return this.soldiers == source.soldiers ? this.row.compareTo(source.row) : this.soldiers.compareTo(source.soldiers);
        }
    }
}
