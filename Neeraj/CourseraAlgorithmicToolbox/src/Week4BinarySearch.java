import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Problem Description
Task. The goal in this code problem is to implement the binary search algorithm.
Input Format. The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛−1
of 𝑛 pairwise distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘
positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘−1.
Constraints. 1 ≤ 𝑛, 𝑘 ≤ 104; 1 ≤ 𝑎𝑖 ≤ 109
for all 0 ≤ 𝑖 < 𝑛; 1 ≤ 𝑏𝑗 ≤ 109
for all 0 ≤ 𝑗 < 𝑘;
Output Format. For all 𝑖 from 0 to 𝑘 − 1, output an index 0 ≤ 𝑗 ≤ 𝑛 − 1 such that 𝑎𝑗 = 𝑏𝑖 or −1 if there
is no such index.
Sample 1.
Input: (5 1 5 8 12 13 5 8 1 23 1 11)
5 1 5 8 12 13
5 8 1 23 1 11
Output:
2 0 -1 0 -1
In this sample, we are given an increasing sequence 𝑎0 = 1, 𝑎1 = 5, 𝑎2 = 8, 𝑎3 = 12, 𝑎4 = 13 of length
five and five keys to search: 8, 1, 23, 1, 11. We see that 𝑎2 = 8 and 𝑎0 = 1, but the key
 */
public class Week4BinarySearch {

    public static void main(String[] args) {
        int sortedNumbersCount = FastScan.nextInt();
        int[] sortedNumbers = new int[sortedNumbersCount];
        for (int i = 0; i < sortedNumbersCount; i++) {
            sortedNumbers[i] = FastScan.nextInt();
        }

        int searchNumbersCount = FastScan.nextInt();
        int[] searchNumbers = new int[searchNumbersCount];
        for (int i = 0; i < searchNumbersCount; i++) {
            searchNumbers[i] = FastScan.nextInt();
        }
        Arrays.stream(searchNumbersFromArray(sortedNumbers, searchNumbers)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] searchNumbersFromArray(int[] sortedNumbers, int[] searchNumbers) {
        int[] result = new int[searchNumbers.length];
        for (int i = 0; i < searchNumbers.length; i++) {
            int search = binarySearch(searchNumbers[i], sortedNumbers);
            result[i] = search;
        }
        return result;
    }

    private static int binarySearch(int searchNumber, int[] sortedNumbers) {
        int lowestIndex = 0;
        int highestIndex = sortedNumbers.length - 1;

        while (lowestIndex <= highestIndex) {
            int median = (lowestIndex + highestIndex) / 2;
            int valueAtMedian = sortedNumbers[median];
            if (valueAtMedian == searchNumber) return median;
            else if (valueAtMedian < searchNumber) lowestIndex = median + 1;
            else highestIndex = median - 1;
        }
        return -1;
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
