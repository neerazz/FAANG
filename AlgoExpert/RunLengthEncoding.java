/**
 * Created on:  Feb 22, 2021
 * Questions:
 */

public class RunLengthEncoding {

    public static void main(String[] args) {

    }

    public static String runLengthEncoding(String string) {
        char pre = ' ';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char cur : string.toCharArray()) {
            if (cur != pre) {
                while (count > 9) {
                    sb.append(9).append(pre);
                    count -= 9;
                }
                if (count >= 1) sb.append(count).append(pre);
                count = 0;
            }
            pre = cur;
            count++;
        }
        while (count > 9) {
            sb.append(9).append(pre);
            count -= 9;
        }
        if (count >= 1) sb.append(count).append(pre);
        return sb.toString();
    }
}
