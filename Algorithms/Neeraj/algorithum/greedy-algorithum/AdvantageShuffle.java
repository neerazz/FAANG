import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 24, 2021
 * Questions:
 */

public class AdvantageShuffle {

    public static void main(String[] args) {

    }

    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        for (int num : A) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int cur = B[i];
            Integer key = map1.higherKey(cur);
            if (key == null) {
                int smallest = map1.firstKey();
                result[i] = smallest;
                int occ = map1.remove(smallest);
                if (occ > 1) map1.put(smallest, occ - 1);
            } else {
                result[i] = key;
                int occ = map1.remove(key);
                if (occ > 1) {
                    map1.put(key, occ - 1);
                }
            }
        }
        return result;
    }
}
