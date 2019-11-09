import java.util.Scanner;

/*
https://towardsdatascience.com/course-1-algorithmic-toolbox-part-4-dynamic-programming-223ffc01984a

Sample 1.
Input:
2
Output:
2
2 = 1 + 1.
Sample 2.
Input:
34
Output:
9
34 = 3 + 3 + 4 + 4 + 4 + 4 + 4 + 4 + 4.

Solution: See rough Explanation.
 */

public class Week5MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalMoney = Integer.parseInt(sc.next());
        int[] denominations = new int[]{1, 3, 4};

        System.out.println(getDPChange(totalMoney, denominations));
    }

    private static int getDPChange(int totalMoney, int[] denominations) {

        int numOfCoins = 0;

        int[][] coinsAtDenomination = new int[denominations.length + 1][totalMoney + 1];
        coinsAtDenomination[0][0] = 0;

        for (int i = 1; i <= denominations.length; i++) {
            for (int j = 1; j <= totalMoney; j++) {
                if (j >= denominations[i - 1]) {
                    if (coinsAtDenomination[i - 1][j] == 0)
                        coinsAtDenomination[i][j] = coinsAtDenomination[i][j - denominations[i - 1]] + 1;
                    else
                        coinsAtDenomination[i][j] = Math.min(coinsAtDenomination[i - 1][j], coinsAtDenomination[i][j - denominations[i - 1]] + 1);
                } else {
                    coinsAtDenomination[i][j] = coinsAtDenomination[i - 1][j];
                }
//                System.out.println("T["+i+"]["+j+"] =" + coinsAtDenomination[i][j]);
            }
        }
//        System.out.println("denominations.length" + denominations.length + "totalMoney" + totalMoney);
        return coinsAtDenomination[denominations.length][totalMoney];
    }
}
