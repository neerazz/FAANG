import java.util.HashMap;
import java.util.Map;

public class TripletsXOR {

    public static int countTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j; k < arr.length; k++) {
                    int sol = arr[i] ^ arr[j] ^ arr[k];
                    map.putIfAbsent(sol, 0);
                    map.put(sol, map.get(sol) + 1);
                }
            }
        }
        int max = 0;
        for (int v : map.values()) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{1, 3, 5, 7, 9}));
    }
}
