package concepts.hastable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public static void main(String[] args) {
        System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }

    public static List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        for (String str : strings) {
            String hashValue = hash(str);
            if (map.containsKey(hashValue)) {
                list = map.get(hashValue);
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
            }
            map.put(hashValue, list);
        }
        return new ArrayList<>(map.values());

    }

    private static String hash(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.length());
        for (int i = 0; i < str.length() - 1; i++) {
            int val = str.charAt(i + 1) - str.charAt(i);
            val = val < 0 ? 26 + val : val;
            sb.append(val);
        }
        return sb.toString();
    }
}
