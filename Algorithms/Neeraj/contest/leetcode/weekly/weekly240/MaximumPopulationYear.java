package weekly.weekly240;

/**
 * Created on:  May 08, 2021
 * Questions:
 */

public class MaximumPopulationYear {

    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{2008, 2026}, {2004, 2008}, {2034, 2035}, {1999, 2050}, {2049, 2050}, {2011, 2035}, {1966, 2033}, {2044, 2049}}) + " = 2011");
    }

    public static int maximumPopulation(int[][] logs) {
        int[] counts = new int[2052];
        int start = 1950, end = 2050;
        for (int[] log : logs) {
            counts[log[0]]++;
            counts[log[1]]--;
        }
//         Flatten the counts.
        int sum = 0, max = 0, year = 0;
        for (int i = start; i <= end; i++) {
            sum += counts[i];
            if (sum > max) {
                max = sum;
                year = i;
            }
            System.out.println("Year = " + i + " Count = " + sum);
            counts[i] = sum;
        }
//        System.out.println(Arrays.toString(counts));
        return year;
    }
}
