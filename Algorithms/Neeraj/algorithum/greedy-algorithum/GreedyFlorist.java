package InterviewPreparation.GreedyAlgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class GreedyFlorist {
    public static void main(String[] args) {
        System.out.println(getMinimumCost(3,new int[]{2,5,6}) + " should be [13]");
        System.out.println(getMinimumCost(3,new int[]{1,2,3,4}) + " should be [11]");
    }

    static int getMinimumCost(int k, int[] c) {
        List<Integer> sortedPrice = Arrays.stream(c).boxed().sorted((p1,p2) -> p2.compareTo(p1)).collect(Collectors.toList());
        int price =0, factor =1, flowers =0, index =0;
        while (flowers < c.length){
            for (int i = 0; i < k; i++) {
                flowers++;
                price += sortedPrice.get(index++) * factor;
                if (flowers == c.length){
                    break;
                }
            }
            factor++;
        }
        return price;
    }
}
