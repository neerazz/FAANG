import java.util.Arrays;
import java.util.List;

class MoveElementToEnd {
    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
        System.out.println(moveElementToEnd_rev1(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
    }

    public static List<Integer> moveElementToEnd_rev1(List<Integer> array, int toMove) {
        int nonMatch = 0, len = array.size();
        for (int num : array) {
            if (num != toMove) {
                array.set(nonMatch++, num);
            }
        }
        while (nonMatch < len) {
            array.set(nonMatch++, toMove);
        }
        return array;
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int nonMatchIndex = 0, len = array.size();
        for (int i = 0; i < len; i++) {
            int cur = array.get(i);
            if (cur != toMove) {
                array.set(nonMatchIndex++, cur);
            }
        }
        for (int i = nonMatchIndex; i < len; i++) {
            array.set(i, toMove);
        }
        return array;
    }
}
