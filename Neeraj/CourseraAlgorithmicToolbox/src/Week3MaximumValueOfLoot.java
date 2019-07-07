import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

Optimal Solution: https://medium.com/competitive/fractional-knapsack-6b39ece7ec92

Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
Input Format. The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
value and the weight of 𝑖-th item, respectively.
Constraints. 1 ≤ 𝑛 ≤ 103
, 0 ≤ 𝑊 ≤ 2 · 106
; 0 ≤ 𝑣𝑖 ≤ 2 · 106
, 0 < 𝑤𝑖 ≤ 2 · 106
for all 1 ≤ 𝑖 ≤ 𝑛. All the
numbers are integers.
Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute
value of the difference between the answer of your program and the optimal value should be at most
10−3
. To ensure this, output your answer with at least four digits after the decimal point (otherwise
your answer, while being computed correctly, can turn out to be wrong because of rounding issues).

Input 1: (1 10 500 30)
1 10
500 30
Output: 166.667

Input 2: (3 50 60 20 100 50 120 30)
3 50
60 20
100 50
120 30
Output: 180.000

Input 3: (1 1000 500 30)
1 1000
500 30
Output: 500.000

Input 4: (1 10 500 30)
1 10
500 30
Output: 166.667
 */
public class Week3MaximumValueOfLoot {

    public static void main(String[] args) {
        int numberOfItems = FastScan.nextInt();
        int totalCapacity = FastScan.nextInt();

        ArrayList<Integer> itemValues = new ArrayList<>();
        ArrayList<Integer> itemWeights = new ArrayList<>();
        ArrayList<Double> itemValuePerWeight = new ArrayList<>();

        for (int i = 0; i < numberOfItems; i++) {
            itemValues.add(FastScan.nextInt());
            itemWeights.add(FastScan.nextInt());
            itemValuePerWeight.add((double) itemValues.get(i) / itemWeights.get(i));
        }
        Double result = getMaximumValue(itemValues, itemWeights, itemValuePerWeight, totalCapacity);
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(result));
    }

    private static Double getMaximumValue(ArrayList<Integer> itemValues,
                                          ArrayList<Integer> itemWeights,
                                          ArrayList<Double> itemValuePerWeight, int totalCapacity) {
//        Sort the item value per weight.
        List<Double> sortedList = itemValuePerWeight.stream().sorted().collect(Collectors.toList());
        Double storedItemWeight = 0.0;
        Double storedItemValue = 0.0;
        Double remainingWeight = 0.0;

        if (totalCapacity == 0) return (double) 0;

//            Loop through all the sorted itemValuePerWeight.
        for (int i = sortedList.size() - 1; i >= 0; i--) {

            remainingWeight = totalCapacity - storedItemWeight;

            Double currentValuePerWeight = sortedList.get(i);
            Integer currentWeight = itemWeights.get(itemValuePerWeight.indexOf(currentValuePerWeight));
            Integer currentValue = itemValues.get(itemValuePerWeight.indexOf(currentValuePerWeight));

//                Check if complete weight can be accommodated.
            if (currentWeight <= remainingWeight) {
                storedItemWeight += currentWeight;
                storedItemValue += currentValue;
            } else {
//                    If the complete weight can't be accommodated, then take fraction of it.
                storedItemWeight += remainingWeight;
                storedItemValue += remainingWeight * currentValue / currentWeight;
            }
            if (storedItemWeight == totalCapacity) break;
        }
        return storedItemValue;
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static double nextLong() {
            return Long.parseLong(next());
        }
    }
}
