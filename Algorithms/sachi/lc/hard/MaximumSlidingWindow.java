import java.util.TreeMap;

public class MaximumSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        //Add K values to TreeMap
        int p1 = 0, p2 = 0, counter = 0;
        int[] sol = new int[n - k + 1];

        while (p2 < k - 1) {
            treeMap.putIfAbsent(nums[p2], 0);
            treeMap.put(nums[p2], treeMap.get(nums[p2]) + 1);
            p2++;
        }

        while (p2 < n) {
            treeMap.putIfAbsent(nums[p2], 0);
            treeMap.put(nums[p2], treeMap.get(nums[p2]) + 1);
            sol[counter++] = treeMap.lastKey();
            if (treeMap.get(nums[p1]) == 1) {
                treeMap.remove(nums[p1]);
            } else {
                treeMap.put(nums[p1], treeMap.get(nums[p1]) - 1);
            }
            p2++;
            p1++;
        }
        return sol;
    }

    public static void main(String[] args) {
        //int[] sol = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] sol = maxSlidingWindow(new int[]{7,2,4}, 2);
        Util.print(sol);
    }
}
