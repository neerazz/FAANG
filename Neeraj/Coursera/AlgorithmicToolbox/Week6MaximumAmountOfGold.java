import java.util.Scanner;

/*
Input Format. The first line of the input contains the capacity W of a knapsack and the number n of bars of gold.
The next line contains n integers w0,w1,...,wn−1 defining the weights of the bars of gold.
Constraints. 1 ≤ W ≤ 104; 1 ≤ n ≤ 300; 0 ≤ w0,...,wn−1 ≤ 105.
Output Format. Output the maximum weight of gold that fits into a knapsack of capacity W.
Sample 1.
Input: 10 3
1 4 8
Output: 9
Here, the sum of the weights of the first and the last bar is equal to 9.
Solution:
Create an two dimensional array of size [weights][capacity},
and get the maximum possible weight that can be accommodated at each capacity for each weight.

Refer The rough for details. Also the link https://www.youtube.com/watch?v=8LusJS5-AGo
 */
public class Week6MaximumAmountOfGold {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalCapacity = Integer.parseInt(sc.next());
        int weightsCount = Integer.parseInt(sc.next());
        int[] weights = new int[weightsCount];

        for (int i = 0; i < weightsCount; i++) weights[i] = Integer.parseInt(sc.next());

        System.out.println(getMaximumValue(weights, weightsCount, totalCapacity));
    }

    private static int getMaximumValue(int[] weights, int weightsCount, int totalCapacity) {

        int[][] temp = new int[weightsCount + 1][totalCapacity + 1];

        for (int i = 1; i <= weightsCount; i++) {
            for (int j = 1; j <= totalCapacity; j++) {
                if (j >= weights[i - 1]) {
                    temp[i][j] = Math.max(temp[i - 1][j], weights[i - 1] + temp[i - 1][j - weights[i - 1]]);
                } else {
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        return temp[weightsCount][totalCapacity];
    }
}
