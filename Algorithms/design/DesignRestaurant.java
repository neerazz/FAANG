import java.util.*;

/**
 * Created on:  Sep 14, 2021
 * Ref: https://leetcode.com/discuss/interview-experience/1461079/google-swe-l3l4-dublin-ireland-reject
 * <p>
 * Build a data structure to perform three operations (Restaurant is full initially):
 * 1) waitList (string customer_name, int table_size):
 * Add customer with given name and table size they want to book into the whitelist
 * 2) leave (string customer_name):
 * Customer wants to leave the whitelist so remove them.
 * 3) serve (int table_size):
 * This means restaurant now has a free table of size equal to table_size. Find the best customer to serve from waitlist
 * Best Customer: Customer whose required size is less than or equal to the table_size. If multiple customers are matching use first come first serve.
 * For e.g. if whitelist has customers with these table requirements => [2, 3, 4, 5, 5, 7] and restaurant is serving table_size = 6 then best customer is index 3 (0-based indexing).
 */
public class DesignRestaurant {
    public static void main(String[] args) {

    }
}

class Restaurant {

    TreeMap<Integer, LinkedHashSet<String>> map = new TreeMap<>();
    Map<String, Integer> waitingList = new HashMap<>();

    int waitList(String customerName, int tableSize) {
        waitingList.put(customerName, tableSize);
        map.computeIfAbsent(tableSize, val -> new LinkedHashSet<>()).add(customerName);
        return waitingList.size();
    }

    void leave(String customerName) {
        int tableSize = waitingList.remove(customerName);
        Set<String> set = map.get(tableSize);
        set.remove(customerName);
        if (set.isEmpty()) map.remove(tableSize);
    }

    String serve(int tableSize) {
        if (map.isEmpty()) return null;
        Integer floorKey = map.floorKey(tableSize);
        if (floorKey == null) {
            System.out.println("No any customer waiting for Table of size: " + tableSize + " or below.");
            return null;
        }
        LinkedHashSet<String> set = map.get(floorKey);
        String next = set.iterator().next();
        set.remove(next);
        if (set.isEmpty()) map.remove(floorKey);
        return next;
    }
}