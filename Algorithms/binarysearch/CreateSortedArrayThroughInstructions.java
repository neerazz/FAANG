import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jan 10, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3599/
 */

public class CreateSortedArrayThroughInstructions {

    public static void main(String[] args) {
        System.out.println(createSortedArray(new int[]{1, 5, 6, 2}));
        System.out.println(createSortedArray(new int[]{1, 2, 3, 6, 5, 4}));
        System.out.println(createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}));
        System.out.println(createSortedArray(new int[]{4, 14, 10, 2, 5, 3, 8, 19, 7, 20, 12, 1, 9, 15, 13, 11, 18, 6, 16, 17}));
        System.out.println(createSortedArray(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2}));
    }

    public static int createSortedArray(int[] instructions) {
        long result = 0, mod = 1_000_000_007;
        List<Integer> list = new ArrayList<>();
        for (int num : instructions) {
            if (!list.isEmpty()) {
                int left = getLeft(list, num), right = getRight(list, num);
                if (left <= 0 && right != -1) {
                    result = (result + Math.min(list.get(left) == num ? left : left + 1, list.size() - right)) % mod;
                }
                list.add(left == -1 ? 0 : left + 1, num);
            } else list.add(num);
        }
        System.out.println(list);
        return (int) result;
    }

    private static int getRight(List<Integer> list, int val) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= val) left = mid + 1;
            else right = mid;
        }
        if (list.get(left) > val) return left;
        return -1;
    }

    private static int getLeft(List<Integer> list, int val) {
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= val) right = mid;
            else left = mid;
        }
        if (list.get(right) <= val) return right;
        if (list.get(left) <= val) return left;
        return -1;
    }

    public int createSortedArray_rev2(int[] inst) {
        List<Integer> l = new ArrayList<>();
        int res = 0;
        for (int i : inst) {
            res += Math.min(getLeftIdx(l, i), getRightIdx(l, i));
            res %= 1000000007;
        }
        return res;
    }

    public int getRightIdx(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= num) {
                left = mid + 1;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int res = Math.min(left, Math.max(list.size() - left, 0));
        list.add(left, num);
        return res;
    }

    public int getLeftIdx(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == num) {
                right = mid - 1;
            } else if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(Math.max(left, 0), Math.max(list.size() - left, 0));
    }
}
