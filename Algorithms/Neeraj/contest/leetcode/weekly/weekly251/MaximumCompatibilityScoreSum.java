package weekly.weekly251;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-251/problems/maximum-compatibility-score-sum/
 */
public class MaximumCompatibilityScoreSum {
    int max;

    public static void main(String[] args) {

    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        max = 0;
        int len = students.length;
        int[][] scores = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                scores[i][j] = score(students[i], mentors[j]);
            }
        }
        Set<Integer> available = new HashSet<>();
        for(int i=0; i<len; i++) available.add(i);
        helper(0, scores, available, 0);
        return max;
    }
    private void helper(int idx, int[][] scores, Set<Integer> available, int score){
        if(available.isEmpty()){
            max = Math.max(max, score);
        }else{
            Set<Integer> temp = new HashSet<>(available);
            for(int men: available){
                temp.remove(men);
                helper(idx+1, scores, temp, score+scores[idx][men]);
                temp.add(men);
            }
        }
    }
    private int score(int[] student, int[] mentor){
        int len = student.length, score = 0;
        for(int i=0; i<len; i++){
            score += student[i] == mentor[i] ? 1 : 0;
        }
        return score;
    }
}
