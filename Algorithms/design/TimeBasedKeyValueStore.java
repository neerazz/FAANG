import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("123", "123", 123);
        System.out.println(obj.get("123", 121));
        System.out.println(obj.get("123", 123));
        System.out.println(obj.get("123", 125));
    }

    static class TimeMap {

        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                Map.Entry<Integer, String> preVal = map.get(key).floorEntry(timestamp);
                if (preVal != null) return preVal.getValue();
            }
            return "";
        }
    }
}
