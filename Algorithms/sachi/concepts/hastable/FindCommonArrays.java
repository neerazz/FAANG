import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCommonArrays {

    public static void main(String[] args) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        String s = "sachi";
        s.length();
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        for (Integer i : nums1) {
            a.add(i);
        }

        for (Integer i : nums2) {
            b.add(i);
        }

        List<Integer> sol = new ArrayList<>();

        for (Integer val : a) {
            if (b.contains(val)) {
                sol.add(val);
            }
        }
        return sol.stream().mapToInt(i -> i).toArray();
    }
}
