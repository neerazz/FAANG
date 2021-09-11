import java.util.Arrays;

/**
 * Created on:  Oct 07, 2020
 * Questions:
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
 * <p>
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
 * <p>
 * Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,3,4]
 * Output: "23:41"
 * Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
 * Example 2:
 * <p>
 * Input: A = [5,5,5,5]
 * Output: ""
 * Explanation: There are no valid 24-hour times as "55:55" is not valid.
 * Example 3:
 * <p>
 * Input: A = [0,0,0,0]
 * Output: "00:00"
 * Example 4:
 * <p>
 * Input: A = [0,0,1,0]
 * Output: "10:00"
 */

public class MaxTime {

    static int[] result;
    static boolean valid;

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{0, 0, 1, 0}));
    }

    public static String largestTimeFromDigits(int[] arr) {
        int[] time = new int[4];
        result = new int[4];
        valid = false;
        boolean[] taken = new boolean[4];
        helper(arr, 0, time, taken);
        if (valid) {
            return new StringBuilder()
                    .append(result[0])
                    .append(result[1])
                    .append(":")
                    .append(result[2])
                    .append(result[3])
                    .toString();
        }
        return "";
    }

    private static void helper(int[] arr, int idx, int[] time, boolean[] taken) {
        if (idx == 4) {
            valid = true;
//             Valid if the new time is greater then existing time.
            int existing = 0, newVal = 0;
            for (int i = 0; i < 4; i++) {
                existing = existing * 10 + result[i];
                newVal = newVal * 10 + time[i];
            }
            if (newVal > existing) {
                result = Arrays.copyOf(time, 4);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!taken[i] && isValid(time, arr[i], idx)) {
                    taken[i] = true;
                    time[idx] = arr[i];
                    helper(arr, idx + 1, time, taken);
                    taken[i] = false;
                }
            }
        }
    }

    private static boolean isValid(int[] time, int val, int idx) {
        if (idx == 0) {
            return val <= 2;
        } else if (idx == 1) {
            if (time[0] == 2) return val <= 3;
            else return val <= 9;
        } else if (idx == 2) {
            return val <= 5;
        }
        return val <= 9;
    }
}
