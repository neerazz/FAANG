package java;

import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-1d-array/problem
 */
public class Java1DArrayPart2 {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int size = game.length;
        if (size == 0) return true;
        if (leap >= size && game[0] == 0) return true;
        return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int leap, int[] game, int index) {
        if (index < 0 || game[index] == 1) return false;
        if (index == game.length - 1 || index + leap > game.length - 1) return true;
        game[index] = 1;
        return isSolvable(leap, game, index - 1) || isSolvable(leap, game, index + 1) || isSolvable(leap, game, index + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
