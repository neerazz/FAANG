import java.util.List;

/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.algoexpert.io/questions/Validate%20Subsequence
 */
public class ValidateSubsequence {
    public static void main(String[] args) {

    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == sequence.get(0) && valid(array, i, sequence)) {
                return true;
            }
        }
        return false;
    }

    private static boolean valid(List<Integer> array, int idx, List<Integer> sequence) {
        int p1 = 0;
        while (idx < array.size() && p1 < sequence.size()) {
            if (array.get(idx++) == sequence.get(p1)) p1++;
        }
        return p1 == sequence.size();
    }
}
