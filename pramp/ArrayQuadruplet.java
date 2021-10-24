import java.util.*;

class ArrayQuadruplet {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        if (arr.length == 0) return new int[0];
        int len = arr.length;
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        //Getting combination of key any values
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = arr[i], b = arr[j], sum = a + b;
                Set<List<Integer>> values = map.getOrDefault(sum, new HashSet<>());
                List<Integer> cur = a > b ? Arrays.asList(i, j) : Arrays.asList(j, i);
                values.add(cur);
                map.put(sum, values);
            }
        }

        Set<List<Integer>> output = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = arr[i], b = arr[j], sum = a + b, rem = s - sum;
                if (map.containsKey(rem)) {
                    Set<List<Integer>> values = map.get(rem);
                    for (List<Integer> temp : values) {
                        //Check if the current list values are already in the oputput set.
                        int k = temp.get(0), l = temp.get(1);
                        if (i != k && i != l && j != k && j != l) {
                            int[] op = new int[]{arr[i], arr[j], arr[k], arr[l]};
                            Arrays.sort(op);
                            List<Integer> cur = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(cur);
                            output.add(cur);
                            return op;
                        }
                    }
                }
            }
        }
        System.out.println(output);
        // output.forEach(a -> System.out.println(Arrays.toString(a)));
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20)) + " should be [0, 4, 7, 9]");
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{}, 12)) + " should be []");
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{4, 4, 4}, 12)) + " should be []");
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{4, 4, 4, 4}, 16)) + " should be [4,4,4,4]");
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 120)) + " should be []");
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{1, 2, 3, 4, 5, 9, 19, 12, 12, 19}, 40)) + " should be [4, 5, 12, 19]");
    }

}
