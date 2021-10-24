import java.util.Arrays;
import java.util.List;

/*
https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {
    public static void main(String[] args) {
        System.out.println(compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)) + " should be [2,1].");
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int BobPoint = 0, AlicePoint = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                AlicePoint++;
            } else if (a.get(i) < b.get(i)) {
                BobPoint++;
            }
        }
        return Arrays.asList(AlicePoint, BobPoint);
    }
}
