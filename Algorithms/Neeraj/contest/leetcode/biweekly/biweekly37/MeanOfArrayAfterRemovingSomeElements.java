package biweekly.biweekly37;

import java.util.*;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class MeanOfArrayAfterRemovingSomeElements {

    public static void main(String[] args) {

    }
    public double trimMean(int[] arr) {
        int len = arr.length, start = len / 20, end = len - start, count =0;
        double sum = 0;
        Arrays.sort(arr);
        for(int i = start; i<end; i++){
            sum += arr[i];
            count++;
        }
        return sum / count;
    }
}
