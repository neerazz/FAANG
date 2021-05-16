package weekly.weekly185;
/*
    Created on:  Apr 18, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class DisplayTableofFoodOrdersinaRestaurant {
    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> items = new HashSet<>();
        Set<Integer> tables = new HashSet<>();
        Map<Integer, Map<String, Integer>> tableOrders = new HashMap<>();
        for (List<String> order : orders) {
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            Map<String, Integer> tableItems = tableOrders.getOrDefault(table, new HashMap<>());
            tableItems.put(food, tableItems.getOrDefault(food, 0) + 1);
            tableOrders.put(table, tableItems);
            tables.add(table);
            items.add(food);
        }
//        Sort all the items and food.
        List<String> itemsSorted = new ArrayList<>(items);
        List<Integer> tablesSorted = new ArrayList<>(tables);
        Collections.sort(itemsSorted);
        Collections.sort(tablesSorted);
        List<List<String>> display = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(itemsSorted);
        display.add(header);
        for (Integer table : tablesSorted) {
            List<String> row = new ArrayList<>();
            row.add("" + table);
            Map<String, Integer> tableItems = tableOrders.get(table);
            for (String item : itemsSorted) {
                row.add("" + tableItems.getOrDefault(item, 0));
            }
            display.add(row);
        }
        return display;
    }
}
