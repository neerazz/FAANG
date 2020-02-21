package algorithms;

/*
https://www.hackerrank.com/challenges/mini-max-sum/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class MiniMaxSum {
    public static void main(String[] args) {
//        miniMaxSum(new int[]{1, 3, 5, 7, 9});
//        miniMaxSum(new int[]{1, 2, 3, 4, 5});
        miniMaxSum(new int[]{942381765, 627450398, 954173620, 583762094, 236817490});
    }

    static void miniMaxSum(int[] arr) {
        if (arr.length == 0) {
            System.out.println("0 0");
        }
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
        long sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, sum-arr[i]);
            max = Math.max(max, sum-arr[i]);
        }
        System.out.println(min + " " + max);
    }
}
