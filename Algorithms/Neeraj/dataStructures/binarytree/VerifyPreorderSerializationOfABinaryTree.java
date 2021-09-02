import java.util.*;

/**
 * Created on:  Aug 26, 2021
 * Ref: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {

    }

    static int p, len;
    static boolean outOfIndex;

    public static boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        len = split.length;
        p = 0;
        outOfIndex = false;
        boolean exploredAll = dfs(split);
        if (outOfIndex) return false;
        if (exploredAll && p == len) return true;
        return false;
    }

    static boolean dfs(String[] split) {
//        When the pointer runs out of index, return false.
        if (p >= len || outOfIndex) {
            outOfIndex = true;
            return false;
        }
        String cur = split[p++];
        if (cur.equals("#")) return true;
        return dfs(split) && dfs(split);
    }
}
