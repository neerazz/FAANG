package y2020.RoundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff48/00000000003f47fb
 */
public class PaintersDuel {
    static int score;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int s = sc.nextInt();
            int[] a = {sc.nextInt(), sc.nextInt()};
            int[] b = {sc.nextInt(), sc.nextInt()};
            int c = sc.nextInt();
            int[][] underConstruction = new int[c][2];
            for (int j = 0; j < c; j++) {
                underConstruction[j][0] = sc.nextInt();
                underConstruction[j][1] = sc.nextInt();
            }
            result[i] = getFinalScore(s, a, b, c, underConstruction);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getFinalScore(int n, int[] a, int[] b, int c, int[][] underConstruction) {
        score = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n + 1][2 * n];
        for (int[] val : underConstruction) {
            visited[val[0]][val[1]] = true;
        }
        visited[a[0]][a[1]] = visited[b[0]][b[1]] = true;
        helper(n, a, b, visited, 1, 1, 0, null);
        return score;
    }

    private static void helper(int n, int[] a, int[] b, boolean[][] visited, int aScore, int bScore, int turn, Boolean prePossible) {
        List<int[]> posbilities = getposibilities(turn == 0 ? a : b, n, visited);
        for (int[] pos : posbilities) {
            visited[pos[0]][pos[1]] = true;
            if (turn == 0) {
                helper(n, pos, b, visited, aScore + 1, bScore, 1, true);
            } else {
                helper(n, a, pos, visited, aScore, bScore + 1, 0, true);
            }
            visited[pos[0]][pos[1]] = false;
        }
        if (posbilities.isEmpty()) {
            if (!prePossible) {
//                Means previous painter was not able to paint. then it is the end.
                score = Math.max(score, aScore - bScore);
                System.out.println("n = " + n + ", a = " + Arrays.toString(a) + ", b = " + Arrays.toString(b) + ", visited = " + Arrays.deepToString(visited) + ", aScore = " + aScore + ", bScore = " + bScore + ", turn = " + turn + ", prePossible = " + prePossible);
            } else {
                helper(n, a, b, visited, aScore, bScore, turn ^ 1, false);
            }
        }
    }

    private static List<int[]> getposibilities(int[] cur, int n, boolean[][] visited) {
        List<int[]> op = new ArrayList<>();
//        Check left side
        if (cur[1] - 1 > 0 && !visited[cur[0]][cur[1] - 1]) {
            op.add(new int[]{cur[0], cur[1] - 1});
        }
//        Check the right side
        if (cur[1] + 1 < 2 * cur[0] && !visited[cur[0]][cur[1] + 1]) {
            op.add(new int[]{cur[0], cur[1] + 1});
        }
//        Check up and down based on upper and lower triangle.
        if (cur[1] % 2 == 0) {
//            If even then it is lower triangle, means you can only go up.
            if (cur[0] - 1 >= 1 && !visited[cur[0] - 1][cur[1] - 1]) op.add(new int[]{cur[0] - 1, cur[1] - 1});
        } else {
            if (cur[0] + 1 <= n && !visited[cur[0] + 1][cur[1] + 1]) op.add(new int[]{cur[0] + 1, cur[1] + 1});
        }
        return op;
    }
}
