import java.util.Arrays;

public class ReorderLogs {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (o1, o2) -> {
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);

            if (Character.isDigit(s1[1].charAt(0)) && Character.isDigit(s2[1].charAt(0))) {
                return 0;
            } else if (Character.isDigit(s1[1].charAt(0))) {
                return 1;
            } else if (Character.isDigit(s2[1].charAt(0))) {
                return -1;
            } else {
                if (s1[1].equals(s2[1])) {
                    return o1.compareTo(o2);
                } else {
                    return s1[1].compareTo(s2[1]);
                }
            }
        });
        return logs;

    }

}
