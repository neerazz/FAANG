/**
 * Created on:  Sep 30, 2020
 * Questions: https://leetcode.com/problems/day-of-the-week/
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        return java.time.LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.ENGLISH);
    }
}
