/**
 * Created on:  Jul 14, 2020
 * Questions: https://leetcode.com/problems/angle-between-hands-of-a-clock
 */
public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30) + " should be [165]");
        System.out.println(angleClock(4, 50) + " should be [155]");
        System.out.println(angleClock(12, 0) + " should be [0]");
        System.out.println(angleClock(3, 15) + " should be [7.5]");
    }

    public static double angleClock(int hour, int minutes) {
        double h = (hour == 12 ? 0 : hour) * 30 + minutes * 0.5;
        double m = minutes * 6;
        double dif = Math.abs(h - m);
        return Math.min(360 - dif, dif);
    }
}
