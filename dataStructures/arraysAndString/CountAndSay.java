/**
 * Created on:  Aug 19, 2020
 * Questions: https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public static void main(String[] args) {

    }

    public static String countAndSay(int n) {
        String str = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            char pre = str.charAt(0);
            int count = 0;
            for (char cur : str.toCharArray()) {
                if (pre == cur) count++;
                else {
                    sb.append(count).append(pre);
                    pre = cur;
                    count = 1;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
            n--;
        }
        return str;
    }
}
