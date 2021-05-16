package weekly.weekly224;

import java.util.*;

/**
 * Created on:  Jan 16, 2021
 * Questions:
 */

public class TupleWithSameProduct {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6}));
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}) + " = 1288");
    }

    public static int tupleSameProduct(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        int count = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                long product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            int size = entry.getValue();
            if (size < 2) continue;
            int mul = (size * (size - 1)) / 2;
            count += 8 * mul;
        }
        return count;
    }

    public static int tupleSameProduct_naive(int[] nums) {
        int count = 0, len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                if (a == b) continue;
                int product = nums[a] * nums[b];
                for (int c = 0; c < len; c++) {
                    if (c == a || c == b) continue;
                    int d = product / nums[c];
                    if (product % nums[c] == 0 && nums[c] != d && set.contains(d)) {
//                        System.out.println(String.format("%d, %d, %d, %d", nums[a], nums[b], nums[c], d));
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
