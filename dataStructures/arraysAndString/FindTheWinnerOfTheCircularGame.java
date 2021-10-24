/**
 * Created on:  May 05, 2021
 * Questions: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 */

public class FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5) + " = 1");
    }

    public static int findTheWinner(int n, int k) {
        boolean[] losers = new boolean[n + 1];
        int lost = 0;
        int current = 1;
        while (lost++ < n - 1) {
            int curLosser = getLooser(current, losers, n, k);
            losers[curLosser] = true;
            current = getNext(n, curLosser, losers);
//            System.out.println("curLosser = " + curLosser + " Starting = " + current);
        }
        return current;
    }

    static int getNext(int n, int start, boolean[] losers) {
        while (true) {
            start++;
            if (start > n) start = 1;
            if (!losers[start]) return start;
        }
    }

    static int getLooser(int cur, boolean[] losers, int n, int k) {
        int count = 0;
        while (count < k) {
            if (!losers[cur]) {
                count++;
                if (count == k) return cur;
            }
            cur++;
            if (cur > n) cur = 1;
        }
        return cur;
    }
}
