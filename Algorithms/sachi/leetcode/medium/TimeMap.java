import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class TimeMap {

    Map<String, Map<Integer, String>> valMap;
    Map<String, TreeSet<Integer>> treeMap;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        valMap = new HashMap<>();
        treeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valMap.putIfAbsent(key, new HashMap<>());
        Map<Integer, String> valInnerMap = valMap.get(key);
        valInnerMap.put(timestamp, value);

        treeMap.putIfAbsent(key, new TreeSet<>());
        TreeSet<Integer> innerTree = treeMap.get(key);
        innerTree.add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (!valMap.containsKey(key)) return "";
        TreeSet<Integer> innerTree = treeMap.get(key);
        Integer closestVal = innerTree.floor(timestamp);
        if (closestVal == null) return "";
        Map<Integer, String> valInnerMap = valMap.get(key);
        return valInnerMap.get(closestVal);
    }
}