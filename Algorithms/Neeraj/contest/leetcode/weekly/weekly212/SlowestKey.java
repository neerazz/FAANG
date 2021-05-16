package weekly.weekly212;

/**
 * Created on:  Oct 24, 2020
 * Questions:
 */

public class SlowestKey {

    public static void main(String[] args) {
        System.out.println(slowestKey(new int[]{9,29,49,5}, "cbcd"));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] time = new int[26];
        int pre = 0, max = 0;
        char maxChar = ' ';
        for (int i = 0; i < releaseTimes.length; i++) {
            int cur = releaseTimes[i], val = cur - pre;
            int c = keysPressed.charAt(i) - 'a';
            time[c] = Math.max(time[c], val);
            if (max < time[c] || (max == time[c] && maxChar < keysPressed.charAt(i))) {
                maxChar = keysPressed.charAt(i);
                max = time[c];
            }
            pre = cur;
        }
        return maxChar;
    }
}
