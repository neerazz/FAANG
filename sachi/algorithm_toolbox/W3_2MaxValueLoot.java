/*
The goal of this code problem is to implement an algorithm for the fractional knapsack problem

Input Format: The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack. 
The next 𝑛 lines define the values and weights of the items. 
The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the value and the weight of 𝑖-th item, respectively.

Output Format: Output the maximal value of fractions of items that fit into the knapsack. 
The absolute value of the difference between the answer of your program and the optimal value should be at most 10−3. 
To ensure this, output your answer with at least four digits after the decimal point 
(otherwise your answer, while being computed correctly, can turn out to be wrong because of rounding issues).

*/
import java.text.DecimalFormat;
import java.util.Scanner;

public class W3_2MaxValueLoot {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }

    private static String getOptimalValue(int capacity, int[] values, int[] weights) {
        // Calculate vi/wi from input
        double[] ratio = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            ratio[i] = (double) values[i] / weights[i];
        }
        // Sort vi/wi from desc to asc
        sort(ratio, 0, ratio.length - 1, values, weights);

        // Iterate through to put all max from first and going forward
        double finalVal = 0;
        int i = 0, filledCapacity = 0;
        while (capacity > 0 && i< values.length) {
            if (capacity >= weights[i]) {
                // Take Full
                finalVal += weights[i] * ratio[i];
                filledCapacity = weights[i];
            } else {
                // Cal remaining capacity5
                finalVal += capacity * ratio[i];
                filledCapacity = capacity;
            }
            capacity -= filledCapacity;
            i++;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format(finalVal);
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(double[] arr, int l, int r, int[] values, int[] weights) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            sort(arr, l, m, values, weights);
            sort(arr, m + 1, r, values, weights);
            // Merge the sorted halves
            merge(arr, l, m, r, values, weights);
        }
    }

    // Merge Sort
    private static void merge(double[] arr, int l, int m, int r, int[] values, int[] weights) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        double[] L = new double[n1];
        double[] R = new double[n2];

        int[] vL = new int[n1];
        int[] wL = new int[n1];

        int[] vR = new int[n2];
        int[] wR = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            vL[i] = values[l + i];
            wL[i] = weights[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            vR[j] = values[m + 1 + j];
            wR[j] = weights[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                values[k] = vL[i];
                weights[k] = wL[i];
                i++;
            } else {
                arr[k] = R[j];
                values[k] = vR[j];
                weights[k] = wR[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            values[k] = vL[i];
            weights[k] = wL[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            values[k] = vR[j];
            weights[k] = wR[j];
            j++;
            k++;
        }
    }

}