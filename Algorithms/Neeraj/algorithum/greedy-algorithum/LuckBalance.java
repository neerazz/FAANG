package InterviewPreparation.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class LuckBalance {
    public static void main(String[] args) {
        System.out.println(luckBalance(2,new int[][]{{5,1},{1,1},{4,0}}) + " should be [10]");
        System.out.println(luckBalance(1,new int[][]{{5,1},{1,1},{4,0}}) + " should be [8]");
        System.out.println(luckBalance(3,new int[][]{{5,1},{2,1},{1,1},{8,1},{10,0},{5,0}}) + " should be [29]");
    }

    static int luckBalance(int k, int[][] contests) {
        List<Integer> importantContests = new ArrayList<>();
        int unImportantSum = 0;
        for(int[] contest : contests){
            if (contest[1] == 0){
                unImportantSum += contest[0];
            }else {
                importantContests.add(contest[0]);
            }
        }
        int shouldWin = importantContests.size() - k;
        Collections.sort(importantContests);
        int totalLuck = unImportantSum;
        for (int i = 0; i < importantContests.size(); i++) {
            if (i < shouldWin){
                totalLuck -= importantContests.get(i);
            }else {
                totalLuck += importantContests.get(i);
            }
        }
        return totalLuck;
    }
}
