package biweekly.biweekly42;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class AverageWaitingTime {

    public static void main(String[] args) {
//        System.out.println(averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }

    public static double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int start = 1;
        for (int[] customer : customers) {
            int finish = Math.max(start, customer[0]) + customer[1];
            int curWait = finish - customer[0];
            sum += curWait;
            start = finish;
        }
        return sum / customers.length;
    }
}
