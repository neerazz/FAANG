import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-subtree-with-maximum-average
 */

public class SubtreeMaximumAverageNode {

    static MAryTreeNode maxNode;
    static double maxAvg;

    public static void main(String[] args) {
        MAryTreeNode zero = new MAryTreeNode(0);
        MAryTreeNode two = new MAryTreeNode(-2);
        MAryTreeNode five = new MAryTreeNode(-5);
        zero.children.addAll(
                Arrays.asList(two, five,
                        new MAryTreeNode(-12),
                        new MAryTreeNode(-4),
                        new MAryTreeNode(-8),
                        new MAryTreeNode(-10)));
        two.children.addAll(Arrays.asList(
                new MAryTreeNode(-7),
                new MAryTreeNode(-12),
                new MAryTreeNode(-6),
                new MAryTreeNode(-6)
        ));
        five.children.addAll(Arrays.asList(
                new MAryTreeNode(-7),
                new MAryTreeNode(-5),
                new MAryTreeNode(-8)
        ));
        System.out.println(subtreeMaxAvg(zero));
    }

    public static MAryTreeNode subtreeMaxAvg(MAryTreeNode root) {
        maxNode = null;
        maxAvg = -1 * Integer.MAX_VALUE;
        dfs(root);
        return maxNode;
    }

    private static int[] dfs(MAryTreeNode root) {
        if (root == null) return new int[2];
        int count = 1, sum = root.val;
        if (root.children != null) {
            for (MAryTreeNode dep : root.children) {
                int[] next = dfs(dep);
                count += next[0];
                sum += next[1];
            }
        }
        double curAvg = (double) sum / count;
        if (curAvg > maxAvg) {
            maxNode = root;
            maxAvg = curAvg;
        }
        return new int[]{count, sum};
    }
}

class MAryTreeNode {
    int val;
    List<MAryTreeNode> children;

    public MAryTreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MAryTreeNode{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}