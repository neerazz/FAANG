package leetcode.v1.easy;


public class DateDiff {

    public int daysBetweenDates(String date1, String date2) {

        int diffDays = 0;

        String[] s1 = date1.split("-");
        String[] s2 = date2.split("-");

        int y1 = Integer.parseInt(s1[0]);
        int m1 = Integer.parseInt(s1[1]);
        int d1 = Integer.parseInt(s1[2]);

        int y2 = Integer.parseInt(s2[0]);
        int m2 = Integer.parseInt(s2[1]);
        int d2 = Integer.parseInt(s2[2]);

        //calculate leap years

        return 0;


    }
}
