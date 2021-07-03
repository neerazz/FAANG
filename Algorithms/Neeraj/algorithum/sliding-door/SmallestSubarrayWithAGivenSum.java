/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
 */

public class SmallestSubarrayWithAGivenSum {

    public static void main(String[] args) {

    }
    
    public static int findMinSubArray(int S, int[] arr) {
        int sum = 0, len = arr.length, min = len +1, p1 =0, p2 =0;
        while(p2 < len){
            sum += arr[p2];
            while(p1 <= p2 && sum >= S){
                min = Math.min(min, p2-p1+1);
                sum -= arr[p1++];
            }
            p2++;
        }
        return min== len+1 ? -1 : min;
    }
}
