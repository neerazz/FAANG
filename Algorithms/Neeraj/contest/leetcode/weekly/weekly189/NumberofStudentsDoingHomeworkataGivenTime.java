package weekly.weekly189;

/**
 * Created on:  May 16, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-189/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class NumberofStudentsDoingHomeworkataGivenTime {
    public static void main(String[] args) {

    }
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count =0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] <= queryTime && endTime[i] >= queryTime) count++;
        }
        return count;
    }
}
