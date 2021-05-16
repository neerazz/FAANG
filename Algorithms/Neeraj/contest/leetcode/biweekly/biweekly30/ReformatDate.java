package biweekly.biweekly30;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/reformat-date/
 */
public class ReformatDate {
    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
    }

    public static String reformatDate(String date) {
        String op = "";
        String[] dates = date.split(" ");
        for (int i = 0; i < dates[0].length(); i++) {
            if (Character.isDigit(dates[0].charAt(i))) {
                op += dates[0].charAt(i);
            } else break;
        }
        return dates[2] + "-" + getMonth(dates[1]) + "-" + (op.length() == 1 ? "0" + op : op);
    }

    private static String getMonth(String month) {
        return switch (month) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            default -> "12";
        };
    }
}
