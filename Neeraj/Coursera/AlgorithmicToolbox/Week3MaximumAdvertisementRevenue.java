import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

Get all week 3 solution: https://towardsdatascience.com/course-1-algorithmic-toolbox-part-2-big-o-and-greedy-6265d9065f05

Problem Introduction
You have 𝑛 ads to place on a popular Internet page. For each ad, you know how
much is the advertiser willing to pay for one click on this ad. You have set up 𝑛
slots on your page and estimated the expected number of clicks per day for each
slot. Now, your goal is to distribute the ads among the slots to maximize the
total revenue.
Problem Description
Task. Given two sequences 𝑎1, 𝑎2, . . . , 𝑎𝑛 (𝑎𝑖
is the profit per click of the 𝑖-th ad) and 𝑏1, 𝑏2, . . . , 𝑏𝑛 (𝑏𝑖
is
the average number of clicks per day of the 𝑖-th slot), we need to partition them into 𝑛 pairs (𝑎𝑖
, 𝑏𝑗 )
such that the sum of their products is maximized.
Input Format. The first line contains an integer 𝑛, the second one contains a sequence of integers
𝑎1, 𝑎2, . . . , 𝑎𝑛, the third one contains a sequence of integers 𝑏1, 𝑏2, . . . , 𝑏𝑛.
Constraints. 1 ≤ 𝑛 ≤ 103
; −105 ≤ 𝑎𝑖
, 𝑏𝑖 ≤ 105
for all 1 ≤ 𝑖 ≤ 𝑛.
Output Format. Output the maximum value of ∑︀𝑛
𝑖=1
𝑎𝑖𝑐𝑖
, where 𝑐1, 𝑐2, . . . , 𝑐𝑛 is a permutation of
𝑏1, 𝑏2, . . . , 𝑏𝑛.
Sample 1.
Input: (1 23 39)
1
23
39
Output:
897
897 = 23 · 39.
Sample 2.
Input: (3 1 3 -5 -2 4 1)
3
1 3 -5
-2 4 1
Output:
23
23 = 3 · 4 + 1 · 1 + (−5) · (−2).
 */
public class Week3MaximumAdvertisementRevenue {

    public static void main(String[] args) {
        int numberOfAds = FastScan.nextInt();
        List<Integer> profitPerClick = new ArrayList<>();
        List<Integer> noOfClicks = new ArrayList<>();
        for (int i = 0; i < numberOfAds; i++) {
            profitPerClick.add(FastScan.nextInt());
        }

        for (int i = 0; i < numberOfAds; i++) {
            noOfClicks.add(FastScan.nextInt());
        }
        System.out.println(getMaximumAdValue(numberOfAds, profitPerClick, noOfClicks));
    }

    private static long getMaximumAdValue(int numberOfAds, List<Integer> profitPerClick, List<Integer> noOfClicks) {
        long outputValue = 0;

        List<Integer> sortedProfitsPerClick = profitPerClick.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> sortedNoOfClicks = noOfClicks.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < numberOfAds; i++) {
            outputValue += (long) sortedProfitsPerClick.get(i) * sortedNoOfClicks.get(i);
        }
        return outputValue;
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
