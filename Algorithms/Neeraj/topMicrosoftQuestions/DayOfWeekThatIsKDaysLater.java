/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/703151/
 */

public class DayOfWeekThatIsKDaysLater {

    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) {
        System.out.println(getDayOfWeekThatIsKDaysLater("Wed", 2));
        System.out.println(getDayOfWeekThatIsKDaysLater("Sat", 23));
    }

    private static String getDayOfWeekThatIsKDaysLater(String day, int k) {
        int cur = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i] == day) {
                cur = i;
                break;
            }
        }
        k %= 7;
        int nextDay = (cur + k) % 7;
        return days[nextDay];
    }
}
