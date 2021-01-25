import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAverage {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 3, 2, 6, -1, 4, 1, 8, 2);
        int k = 5;
        System.out.println(averageOfContiguousArrays(input, k));
    }

    /**
     * Find the averages of contiguous arrays of size k
     *
     * @param input input array
     * @param k     k
     * @return averages of arrays
     */
    public static List<Double> averageOfContiguousArrays(List<Integer> input, int k) {

        int p1 = 0, p2;
        double sum = 0;

        List<Double> sol = new ArrayList<>();

        for (p2 = 0; p2 < k; p2++) {
            sum += input.get(p2);
        }
        sol.add(sum / k);
        p2--;

        while (p2 < input.size() - 1) {
            sum -= input.get(p1);
            p1++;
            p2++;
            sum += input.get(p2);
            sol.add(sum / k);
        }
        return sol;
    }

}


