/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/construct-quad-tree/
 */

public class ConstructQuadTree {

    public static void main(String[] args) {
        System.out.println(construct(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(construct_2(new int[][]{{0, 1}, {1, 0}}));
    }

    public static Node construct_2(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, 0, n);
    }

    static Node helper(int[][] grid, int row, int col, int length) {
        if (length == 1) {
            return new Node(grid[row][col] == 1, true);
        }
        int midRow = row + (length / 2), midCol = col + (length / 2);
        Node leftTop = helper(grid, row, col, length / 2);
        Node rightTop = helper(grid, row, midCol, length / 2);
        Node leftBottom = helper(grid, midRow, col, length / 2);
        Node rightBottom = helper(grid, midRow, midCol, length / 2);
        if (isSame(leftTop, rightTop, leftBottom, rightBottom)) {
            return new Node(leftTop.val, true);
        } else {
            return new Node(false, false, leftTop, rightTop, leftBottom, rightBottom);
        }
    }

    static boolean isSame(Node n1, Node n2, Node n3, Node n4) {
        return n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf &&
                n1.val == n2.val && n2.val == n3.val && n3.val == n4.val;
    }

    //    Time: O(N^2)
    public static Node construct(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        return helper(grid, 0, 0, rows - 1, cols - 1);
    }

    private static Node helper(int[][] grid, int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) return new Node(grid[sx][sy] == 1, true);
        int mx = (sx + ex + 1) / 2, my = (sy + ey + 1) / 2;
        Node n1 = helper(grid, sx, sy, mx - 1, my - 1),
                n2 = helper(grid, sx, my, mx - 1, ey);
        Node n3 = helper(grid, mx, sy, ex, my - 1),
                n4 = helper(grid, mx, my, ex, ey);
        if (n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf &&
                n1.val == n2.val && n2.val == n3.val && n3.val == n4.val) {
//            All the four are leaves then this also will be leaf
            return new Node(n1.val, true);
        }
        return new Node(false, false, n1, n2, n3, n4);
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", isLeaf ? 1 : 0, val ? 1 : 0) + (topLeft == null ? "" : "," + topLeft + topRight + bottomLeft + bottomRight);
        }
    }
}
