/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-load-balancer
 */

public class LoadBalancer {

    public static void main(String[] args) {
//        System.out.println(loadBalance(new int[]{1, 3, 4, 2, 2, 2, 1, 1, 2}));
        System.out.println(loadBalance(new int[]{1, 2, 1, 2, 1}));
    }

    public static boolean loadBalance(int[] arr) {
        int len = arr.length, sTree[] = new int[2 * len + 1], start = 2, end = len - 2;
        if (len < 5) return false;
        buildTree(arr, 0, len - 1, sTree, 0);
        for (int i = start; i < end; i++) {
            int sum = 0;
            for (int j = i; j < end; j++) {
                sum += arr[j];
                int left = query(0, i - 2, sTree, 0, len - 1, 0);
                int right = query(j + 2, len - 1, sTree, 0, len - 1, 0);
                if (sum == left && sum == right) return true;
            }
        }
        return false;
    }

    private static int query(int qs, int qe, int[] sTree, int s, int e, int i) {
        if (s > qe || e < qs) return 0;
        if (qs <= s && e <= qe) return sTree[i];
        int m = (s + e) / 2;
        return query(qs, qe, sTree, s, m, 2 * i + 1) + query(qs, qe, sTree, m + 1, e, 2 * i + 2);
    }

    private static void buildTree(int[] arr, int s, int e, int[] sTree, int idx) {
        if (s == e) {
            sTree[idx] = arr[s];
        } else {
            int mid = (s + e) / 2, left = 2 * idx + 1, right = 2 * idx + 2;
            buildTree(arr, s, mid, sTree, left);
            buildTree(arr, mid + 1, e, sTree, right);
            sTree[idx] = sTree[left] + sTree[right];
        }
    }
}
