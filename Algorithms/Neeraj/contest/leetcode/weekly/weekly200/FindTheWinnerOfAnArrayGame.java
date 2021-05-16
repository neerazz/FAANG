package weekly.weekly200;

/**
 * Created on:  Aug 01, 2020
 * Questions: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */
public class FindTheWinnerOfAnArrayGame {
    public static void main(String[] args) {
        System.out.println();
    }

    public int getWinner(int[] arr, int k) {
        int max = arr[0];
//            loop from left to right and check which number can win k cicutinve gaem.
        for (int i = 0; i < arr.length; i++) {
            int wins = i > 0 && arr[i - 1] < arr[i] ? 1 : 0;
            max = Math.max(max, arr[i]);
//                Loop through right till teh current value is greater then the one on right
            int j = i + 1;
            while (j < arr.length && arr[i] > arr[j]) {
                j++;
                wins++;
            }
            if (wins >= k) return arr[i];
        }
        return max;
    }
}
