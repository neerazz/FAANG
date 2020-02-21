import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
You are organizing a funny competition for children. As a prize fund you have n candies. You would like to use these candies for top k places in a competition with a natural restriction that a higher place gets a larger number of candies. To make as many children happy as possible, you are going to find the largest value of k for which it is possible.

Problem Description:
The goal of this problem is to represent a given positive integer n as a sum of as many pairwise distinct positive integers as possible. That is, to find the maximum k such that n can be written as a1+a2+···+ak where a1,…,ak are positive integers and ai != aj for all 1 ≤i<j≤k.
Input Format: The input consists of a single integer n.
Output Format: In the first line, output the maximum number k such that n can be represented as a sum of k pairwise distinct positive integers. In the second line, output k pairwise distinct positive integers that sum up to n (if there are many such representations, output any of them).
Sample 1:
Input: 6
Output: 3
1 2 3
Sample 2:
Input: 8
Output: 3
1 2 5
 */
public class Week3MaximizingTheNumberOfPrize {

    public static void main(String[] args) {
        int numberOfCandies = FastScan.nextInt();
        List<Integer> prizesList = getPairOfPrizes(numberOfCandies);
        System.out.println(prizesList.size());
        prizesList.forEach(i -> System.out.print(i + " "));
    }

    private static List<Integer> getPairOfPrizes(int numberOfCandies) {
        List<Integer> prizesList = new ArrayList<>();
        int sum = 0;
        int currentPoint = 0;

        while (sum < numberOfCandies) {
            currentPoint++;

            if ((currentPoint * 2 + 1 + sum) <= numberOfCandies) {
                prizesList.add(currentPoint);
            } else {
                currentPoint = numberOfCandies - sum;
                prizesList.add(currentPoint);
            }
            sum += currentPoint;
            if (sum == numberOfCandies) {
                break;
            }
        }
        return prizesList;
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

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
