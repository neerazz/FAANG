/**
 * Created on:  Sep 09, 2020
 * Questions: https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        int p1 = 0, p2 = 0, l1 = v1.length, l2 = v2.length;
        while (p1 < l1 && p2 < l2) {
            int cur1 = Integer.parseInt(v1[p1++]), cur2 = Integer.parseInt(v2[p2++]);
            if (cur1 == cur2) continue;
            if (cur1 < cur2) return -1;
            else return 1;
        }
        while (p1 < l1) {
            if (Integer.parseInt(v1[p1++]) > 0) return 1;
        }
        while (p2 < l2) {
            if (Integer.parseInt(v2[p2++]) > 0) return -1;
        }
        return 0;
    }
}
