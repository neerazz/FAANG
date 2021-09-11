import java.util.Arrays;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-items-in-containers
 */

public class ItemsInContainers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfItems("*|*|", new int[]{1}, new int[]{3})) + " = [0]");
        System.out.println(Arrays.toString(numberOfItems("*|*|*|", new int[]{1}, new int[]{6})) + " = [2]");
    }

    private static int[] numberOfItems(String str, int[] starts, int[] ends) {
        int len = str.length();
        int[] sTree = new int[4 * len];
        buildSTree(str, 0, len - 1, sTree, 0);
        int[] result = new int[starts.length], left = new int[len], right = new int[len];
//        Left array will have the index of close\open located on the left side.
//        Right array will have the index of close\open located on the right side.
        int closeIdx = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == '|') closeIdx = i;
            right[i] = closeIdx;
        }
        closeIdx = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '|') closeIdx = i;
            left[i] = closeIdx;
        }
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i], end = ends[i];
            int startIdx = right[start - 1], endIdx = left[end - 1];
            result[i] = getCount(startIdx, endIdx, str, sTree);
        }
        return result;
    }

    private static void buildSTree(String str, int s, int e, int[] sTree, int i) {
        if (s == e) {
            sTree[i] = str.charAt(s) == '*' ? 1 : 0;
        } else {
            int m = (s + e) / 2, left = 2 * i + 1, right = 2 * i + 2;
            buildSTree(str, s, m, sTree, left);
            buildSTree(str, m + 1, e, sTree, right);
            sTree[i] = sTree[left] + sTree[right];
        }
    }

    private static int getCount(int startIdx, int endIdx, String str, int[] sTree) {
        if (startIdx == Integer.MAX_VALUE || endIdx == Integer.MAX_VALUE || startIdx >= endIdx) return 0;
        int count = 0;
        for (int i = startIdx + 1; i < endIdx; i++) {
            count += str.charAt(i) == '*' ? 1 : 0;
        }
        return count;
//        return query(startIdx, endIdx, 0, str.length() - 1, sTree, 0);
    }

    private static int query(int qs, int qe, int s, int e, int[] sTree, int i) {
        if (qe < s || qs > e) return 0;
        if (qs <= s && e <= qe) return sTree[i];
        int m = (s + e) / 2, left = 2 * i + 1, right = 2 * i + 2;
        return query(qs, qe, s, m, sTree, left) + query(qs, qe, m + 1, e, sTree, right);
    }
}
