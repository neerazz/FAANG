import java.util.*;

/**
 * Created on:  Oct 11, 2021
 * Ref: https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArrayImpl {
    public static void main(String[] args) {

    }

    static class SnapshotArray {
        Map<Integer, Integer> values;
        int snapId = 0;
        Map<Integer, Map<Integer, Integer>> map;

        public SnapshotArray(int length) {
            map = new HashMap<>();
            values = new HashMap<>();
        }

        public void set(int index, int val) {
            values.put(index, val);
        }

        public int snap() {
            map.put(snapId, new HashMap<>(values));
            return snapId++;
        }

        public int get(int index, int snap_id) {
            Map<Integer, Integer> array = map.get(snap_id);
            if (array == null) return -1;
            return array.getOrDefault(index, 0);
        }
    }
}
