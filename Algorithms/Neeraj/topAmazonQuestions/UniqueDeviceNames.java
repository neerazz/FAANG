import java.util.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-unique-device-names
 */

public class UniqueDeviceNames {

    public static void main(String[] args) {
        System.out.println(getDeviceNames(Arrays.asList("switch", "tv", "switch", "tv", "switch", "tv")));
        System.out.println(getDeviceNames(Arrays.asList("switch", "tv", "switch", "tv", "switch1", "switch", "switch2", "tv")));
    }

    private static List<String> getDeviceNames(List<String> names) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String name : names) {
            result.add(getName(name, map));
        }
        return result;
    }

    private static String getName(String name, Map<String, Integer> map) {
        if (map.containsKey(name)) {
            int num = map.get(name);
            while (map.containsKey(name + num)) {
                num++;
            }
            map.put(name, num);
            String result = name + num;
            getName(result, map);
            return result;
        } else {
            map.put(name, 1);
            return name;
        }
    }
}
