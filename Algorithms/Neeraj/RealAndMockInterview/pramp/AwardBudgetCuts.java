import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 29, 2020
 * Questions: https://www.pramp.com/challenge/r1Kw0vwG6OhK9AEGAyWV
 *
 * Award Budget Cuts
 * The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing.
 * Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won’t be impacted.
 *
 * Given an array grantsArray of the original grants and the reduced budget newBudget,
 *  write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of
 *  recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).
 * Analyze the time and space complexities of your solution.
 * Example:
 * input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
 * output: 47 # and given this cap the new grants array would be
 *            # [2, 47, 47, 47, 47]. Notice that the sum of the
 *            # new grants is indeed 190
 */
public class AwardBudgetCuts {
    public static void main(String[] args) {
//        System.out.println(findGrantsCap(new double[]{500, 1000, 2}, 1000) + " should be [499]");
//        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 1000}, 190) + " should be [47]");
//        System.out.println(findGrantsCap(new double[]{2, 4}, 3) + " should be [1.5]");
//        System.out.println(findGrantsCap(new double[]{2, 4, 6}, 3) + " should be [1]");
        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 167}, 400) + " should be [128]");
    }

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        List<Double> doubles = new ArrayList<>();
        double sum = 0;
        for (double val : grantsArray) {
            sum += val;
            doubles.add(val);
        }
//        Sort it in descending order
        doubles.sort((v1, v2) -> Double.compare(v2, v1));
        int length = grantsArray.length;
        for (int i = 0; i < length; i++) {
            Double cur = doubles.get(i);
//            At each element from higher to lower try to find out by changing all the higher elements you will be with in the Budget.
            if ((cur * i) + sum < newBudget) {
//            Once found the element then you need to replace all the element at the left.
//            Find a number that can be put in all the higher elements to exactly get all the Budget .
                double surpass = newBudget - sum;
                return surpass / i;
            } else {
                sum -= cur;
            }
        }
        return newBudget / length;
    }
}
