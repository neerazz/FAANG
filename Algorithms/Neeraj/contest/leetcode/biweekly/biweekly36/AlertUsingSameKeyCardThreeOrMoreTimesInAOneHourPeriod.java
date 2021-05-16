package biweekly.biweekly36;

import java.util.*;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args) {
        System.out.println(alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        System.out.println(alertNames(
                new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"},
                new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
        System.out.println(alertNames(
                new String[]{"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"},
                new String[]{"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"}));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        TreeSet<String> output = new TreeSet<>();
        for (int i = 0; i < keyName.length; i++) {
            map.computeIfAbsent(keyName[i], val -> new ArrayList<>()).add(keyTime[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> names = entry.getValue();
            Collections.sort(names);
            int p1 = 0;
            for (int i = 0; i < names.size(); i++) {
                while (p1 <= i && aboveHour(names.get(p1), names.get(i))) {
                    p1++;
                }
                if (i - p1 + 1 >= 3) output.add(entry.getKey());
            }
        }
        return new ArrayList<>(output);
    }

    private static boolean aboveHour(String preTime, String curTime) {
        String[] pre = preTime.split(":"), cur = curTime.split(":");
        int preH = Integer.parseInt(pre[0]), preM = Integer.parseInt(pre[1]);
        int curH = Integer.parseInt(cur[0]), curM = Integer.parseInt(cur[1]);
        if (curH == preH) return false;
        if (curH == preH + 1 && preM == curM) return false;
        return curH != preH + 1 || 60 - preM + curM >= 60;
    }
}
