/**
 * Created on:  Aug 17, 2020
 * Questions: https://leetcode.com/problems/student-attendance-record-i/
 */
public class StudentAttendanceRecordI {
    public static void main(String[] args) {

    }

    public static boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') a++;
            l = c == 'L' ? l + 1 : 0;
            if (a > 1 || l > 2) return false;
        }
        return true;
    }
}
