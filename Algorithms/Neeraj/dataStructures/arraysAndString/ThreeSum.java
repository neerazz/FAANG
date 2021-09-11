import java.util.*;

class ThreeSum {
    static List<Integer[]> output;

    public static void main(String[] args) {
        System.out.println("*****************    Method 1 *****************");
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println("**********************************");
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println("*****************    Method 2 *****************");
        threeNumberSum_method2(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println("**********************************");
        threeNumberSum_method2(new int[]{12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
    }

    public static List<Integer[]> threeNumberSum_method2(int[] array, int targetSum) {
        output = new ArrayList<>();
        Arrays.sort(array);
        nSumHelper(array, 0, 3, targetSum, new Integer[3]);
        return output;
    }

    private static void nSumHelper(int[] array, int start, int n, int targetSum, Integer[] vals) {
        int size = vals.length;
        if (n == 2) {
            List<Integer[]> result = new ArrayList<>();
            if (getTwoSum(array, start, targetSum, result)) {
                for (Integer[] val : result) {
                    Integer[] temp = Arrays.copyOf(vals, size);
                    temp[size - 2] = val[0];
                    temp[size - 1] = val[1];
                    output.add(temp);
                }
            }
            return;
        }
        for (int i = start; i < size; i++) {
            int cur = array[i];
            Integer[] temp = Arrays.copyOf(vals, size);
            temp[size - n] = cur;
            nSumHelper(array, i + 1, n - 1, targetSum - cur, temp);
        }
    }

    private static boolean getTwoSum(int[] array, int start, int targetSum, List<Integer[]> vals) {
        boolean found = false;
        int end = array.length - 1;
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == targetSum) {
                Integer[] op = {array[start], array[end]};
                vals.add(op);
                found = true;
            }
            if (sum > targetSum) end--;
            else start++;
        }
        return found;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> op = new ArrayList<>();
        if (array.length < 3) return op;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Set<Integer> inner = new HashSet<>();
            for (int j = i + 1; j < array.length; j++) {
                int rem = targetSum - array[i] - array[j];
                if (inner.contains(rem)) {
                    List<Integer> innerResult = Arrays.asList(array[i], array[j], rem);
                    Collections.sort(innerResult);
                    set.add(innerResult);
                }
                inner.add(array[j]);
            }
        }
        for (List<Integer> temp : set) {
            op.add(new Integer[]{temp.get(0), temp.get(1), temp.get(2)});
        }
        return op;
    }
}
