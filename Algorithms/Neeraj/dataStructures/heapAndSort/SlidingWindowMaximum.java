import java.util.*;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol2(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol3(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
        System.out.println(Arrays.toString(maxSlidingWindow_sol4(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
    }

    public static int[] maxSlidingWindow_sol4(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.length, i = 0, j = 0;
        while (i < k - 1) {
            int cur = nums[i++];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        while (i < len) {
            int end = nums[i++], start = nums[j++];
            map.put(end, map.getOrDefault(end, 0) + 1);
            result.add(map.lastKey());
            int count = map.remove(start);
            if (count > 1) map.put(start, count - 1);
        }
        return result.stream().mapToInt(val -> val).toArray();
    }

    public static int[] maxSlidingWindow_sol3(int[] nums, int k) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = nums[0];
        int[] right = new int[len];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (i % k == 0) left[i] = nums[i];          // Start of the block
            else left[i] = Math.max(left[i - 1], nums[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            if ((i + 1) % k == 0) right[i] = nums[i];   // Start of the block
            else right[i] = Math.max(right[i + 1], nums[i]);
        }
        int p1 = 0;
        List<Integer> result = new ArrayList<>();
        for (int p2 = k - 1; p2 < len; p2++) {
            int max = Math.max(left[p2], right[p1]);
            result.add(max);
            p1++;
        }
        int[] op = new int[result.size()];
        int index = 0;
        for (int val : result) {
            op[index++] = val;
        }
        return op;
    }

    public static int[] maxSlidingWindow_sol2(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        List<Integer> op = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
        int index = 0, p1 = 0, p2 = k - 1, len = nums.length;
        for (int i = 0; i < k - 1; i++) queue.add(nums[i]);
        while (p2 < len) {
            int p1Value = nums[p1], p2Value = nums[p2];
            queue.add(p2Value);
            int max = queue.peek();
            op.add(max);
            queue.remove(p1Value);
            p1++;
            p2++;
        }
        int[] result = new int[op.size()];
        for (int i = 0; i < op.size(); i++) {
            result[i] = op.get(i);
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        List<Integer> op = new ArrayList<>();
        int index = 0, p1 = 0, p2 = k - 1, len = nums.length;
        while (p2 < len) {
            int max = getMaximum(nums, p1, p2);
            op.add(max);
            p1++;
            p2++;
        }
        int[] result = new int[op.size()];
        for (int i = 0; i < op.size(); i++) {
            result[i] = op.get(i);
        }
        return result;
    }

    private static int getMaximum(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        while (i <= j) {
            max = Math.max(max, nums[i++]);
        }
        return max;
    }
}
