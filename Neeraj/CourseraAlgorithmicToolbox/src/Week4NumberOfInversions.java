import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

Week 4 explanation: https://towardsdatascience.com/course-1-algorithmic-toolbox-part-3-divide-and-conquer-dd9022bfa2c0

Problem Introduction
An inversion of a sequence 𝑎0, 𝑎1, . . . , 𝑎𝑛−1 is a pair of indices 0 ≤ 𝑖 < 𝑗 < 𝑛 such
that 𝑎𝑖 > 𝑎𝑗 . The number of inversions of a sequence in some sense measures how
close the sequence is to being sorted. For example, a sorted (in non-descending
order) sequence contains no inversions at all, while in a sequence sorted in descending order any two elements constitute an inversion (for a total of 𝑛(𝑛 − 1)/2
inversions).
6 1 5 2 3
Problem Description
Task. The goal in this problem is to count the number of inversions of a given sequence.
Input Format. The first line contains an integer 𝑛, the next one contains a sequence of integers
𝑎0, 𝑎1, . . . , 𝑎𝑛−1.
Constraints. 1 ≤ 𝑛 ≤ 105
, 1 ≤ 𝑎𝑖 ≤ 109
for all 0 ≤ 𝑖 < 𝑛.
Output Format. Output the number of inversions in the sequence.
Sample 1.
Input: (5 2 3 9 2 9)
5
2 3 9 2 9
Output:
2
The two inversions here are (1, 3) (𝑎1 = 3 > 2 = 𝑎3) and (2, 3) (𝑎2 = 9 > 2 = 𝑎3).
Sample 2:
Input: (6 9 8 7 3 2 1)
6
9 8 7 3 2 1
Output:
15
Sample 3:
Input:
5
2 3 9 2 9
Output:
2

Solution:
This problem can be solved by modifying the merge sort algorithm. For this, we change both the Merge and
MergeSort procedures as follows:
Merge(𝐵, 𝐶) returns the resulting sorted array and the number of pairs (𝑏, 𝑐) such that 𝑏 ∈ 𝐵, 𝑐 ∈ 𝐶, and 𝑏 > 𝑐;
MergeSort(𝐴) returns a sorted array 𝐴 and the number of inversions in 𝐴.

 */
public class Week4NumberOfInversions {

    static int totalNumberOfInversion = 0;

    public static void main(String[] args) {
        int totalNumbers = FastScan.nextInt();
        int[] numbers = new int[totalNumbers];

        for (int i = 0; i < totalNumbers; i++) {
            numbers[i] = FastScan.nextInt();
        }

//      Naive approach
        inversionCount(numbers, totalNumbers);

//            Perform Merge sort.
//        performMergeSort(numbers, totalNumbers-1);   // Incorrect output Have to check.

        System.out.println(totalNumberOfInversion);
    }

    private static void inversionCount(int[] numbers, int totalNumbers) {
        for (int i = 0; i < totalNumbers; i++) {
            int currentNumber = numbers[i];
            for (int j = i + 1; j < totalNumbers; j++) {
                int comparingValue = numbers[j];
                if (numbers[i] > numbers[j]) totalNumberOfInversion++;
            }
        }
    }

    private static void getTotalNumberOfInversions(int totalNumbers, int[] numbers) {
        performMergeSort(numbers, totalNumbers - 1);
    }

    private static void performMergeSort(int[] numbers, int n) {

//        System.out.println("performMergeSort:\t arr = [" + Arrays.toString(numbers) + "], n = [" + n + "], totalNumberOfInversion = [" + totalNumberOfInversion + "]");

        if (n < 2) return;
        int mid = n / 2;

//            Split it into 2 and assign values.
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) left[i] = numbers[i];
        for (int i = mid; i < n; i++) right[i - mid] = numbers[i];

        performMergeSort(left, mid);
        performMergeSort(right, n - mid);

//            Merge the array.
        performMerge(numbers, left, right, mid, n - mid);
    }

    private static void performMerge(int arr[], int[] leftArray, int[] rightArray, int left, int right) {
//        System.out.println("performMerge:\t\t arr = [" + Arrays.toString(arr) + "], leftArray = [" + Arrays.toString(leftArray) + "], rightArray = [" + Arrays.toString(rightArray) + "], left = [" + left + "], right = [" + right + "], totalNumberOfInversion = [" + totalNumberOfInversion + "]");

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int actualArrayIndex = 0;

        while (leftArrayIndex < left && rightArrayIndex < right) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                arr[actualArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                arr[actualArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
                totalNumberOfInversion = totalNumberOfInversion + (left + right + 1) / 2;
            }
            actualArrayIndex++;
        }

//        Copy remaining elements of the arrays
        while (leftArrayIndex < left) {
            arr[actualArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            actualArrayIndex++;
        }
        while (rightArrayIndex < right) {
            arr[actualArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            actualArrayIndex++;
        }
//        System.out.println(">>END performMerge:\t\t\t arr = [" + Arrays.toString(arr) + "], totalNumberOfInversion = [" + totalNumberOfInversion + "]");
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
