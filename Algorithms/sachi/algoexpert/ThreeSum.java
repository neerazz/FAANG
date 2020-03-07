import java.util.*;

class ThreeSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> sol = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int p1 = i + 1, p2 = array.length - 1, target = targetSum - array[i];
            while (p1 < p2) {
                if (array[p1] + array[p2] == target) {
                    sol.add(new Integer[]{array[i], array[p1], array[p2]});
                    p1++;
                    p2--;
                } else if (array[p1] + array[p2] < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        List<Integer[]> sol = threeNumberSum(new int[]{1, 2, 3}, 6);
        for (Integer[] intarray : sol) {
            System.out.println(Arrays.toString(intarray));
        }
    }

}
