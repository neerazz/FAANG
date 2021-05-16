package biweekly.biweekly19;
/*

 */
public class AngleBetweenHandsofaClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12,30));
        System.out.println(angleClock(3,15));
        System.out.println(angleClock(3,30));
        System.out.println(angleClock(12,00));
        System.out.println(angleClock(1,57));
    }
    public static double angleClock(int hour, int minutes) {
        hour = hour ==12 ? 0 : hour;
        minutes = minutes==60 ? 0 : minutes;
        Double hoursAngle = (hour *30) + (minutes * 0.5);
        Double minutesAngle = (double)minutes * 6;
        double anbleDiff = Math.abs(hoursAngle - minutesAngle);
        return anbleDiff > 180 ? 360 - anbleDiff : anbleDiff;
    }
}
