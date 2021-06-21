package biweekly.biweekly54;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-54/problems/find-the-student-that-will-replace-the-chalk/
 */

public class FindTheStudentThatWillReplaceTheChalk {

    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) sum += num;
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] <= k) k -= chalk[i];
            else return i;
        }
        return -1;
    }
}
