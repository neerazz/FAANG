package level1;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberThatAppearsOnce {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 1, 2, 4, 3, 5}) + " should be [5].");
    }

    public static int singleNumber(int[] A) {
//        Java 8
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            integerMap.put(current, integerMap.getOrDefault(current, 0) + 1);
        }
        return integerMap.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1).map(Map.Entry::getKey)
                .findFirst().orElse(-1);
//        Java 8 +
//        return Arrays.stream(A).boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue()==1).map(Map.Entry::getKey)
//                .findFirst().orElse(-1);
    }
}
