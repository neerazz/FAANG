package level1;

import java.util.ArrayList;

public class FindTheNumberThatAppearsOnce {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 1, 2, 4, 3, 5}) + " should be [5].");
    }

    public static int singleNumber(int[] A) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            if (values.contains(current)) duplicates.add(current);
            else values.add(current);
        }
        for (Integer i : values) {
            if (!duplicates.contains(i)) return i;
        }
        return -1;
    }
}
