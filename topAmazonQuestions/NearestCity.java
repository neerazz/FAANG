import java.util.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/872961/Amazon-or-OA-2020-or-Nearest-City
 */

public class NearestCity {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findNearestCities(3, new String[]{"c1", "c2", "c3"}, new int[]{3, 2, 1}, new int[]{3, 2, 3}, 3,
//                new String[]{"c1", "c2", "c3"})));
//        System.out.println(Arrays.toString(findNearestCities(5, new String[]{"p1", "p2", "p3", "p4", "p5"}, new int[]{10, 20, 30, 40, 50},
//                new int[]{10, 20, 30, 40, 50}, 5, new String[]{"p1", "p2", "p3", "p4", "p5"})));
//        System.out.println(Arrays.toString(findNearestCities(5, new String[]{"p1", "p2", "p3", "p4", "p5"}, new int[]{10, 20, 10, 40, 50},
//                new int[]{10, 20, 10, 10, 50}, 5, new String[]{"p1", "p2", "p3", "p4", "p5"})));

        System.out.println(Arrays.toString(findNearestCities(6, new String[]{"green", "yellow", "red", "blue", "grey", "pink"}, new int[]{10, 20, 15, 30, 10, 15},
                new int[]{30, 25, 30, 40, 25, 25}, 4, new String[]{"grey", "blue", "red", "pink"})));
    }

    public static String[] findNearestCities(int numOfCities, String[] points, int[] xCoordinates, int[] yCoordinates,
                                             int numOfQueriedPoints, String[] queries) {
        Map<Integer, TreeSet<City>> x = new HashMap<>(), y = new HashMap<>();
        Comparator<City> xSort = (c1, c2) -> c1.y == c2.y ? c1.name.compareTo(c2.name) : Integer.compare(c1.y, c2.y);
        Comparator<City> ySort = (c1, c2) -> c1.x == c2.x ? c1.name.compareTo(c2.name) : Integer.compare(c1.x, c2.x);
        Map<String, City> map = new HashMap<>();
        for (int i = 0; i < numOfCities; i++) {
            City city = new City(points[i], xCoordinates[i], yCoordinates[i]);
            x.computeIfAbsent(xCoordinates[i], val -> new TreeSet<>(xSort)).add(city);
            y.computeIfAbsent(yCoordinates[i], val -> new TreeSet<>(ySort)).add(city);
            map.put(city.name, city);
        }
        Map<String, String> closest = new HashMap<>();
        String[] result = new String[numOfQueriedPoints];
        int i = 0;
        for (String city : queries) {
            result[i++] = getClosest(map.get(city), closest, x, y);
        }
        return result;
    }

    private static String getClosest(City city, Map<String, String> closest, Map<Integer, TreeSet<City>> x, Map<Integer, TreeSet<City>> y) {
        if (closest.containsKey(city.name)) return closest.get(city.name);
        TreeSet<City> xC = x.get(city.x);
        TreeSet<City> yC = y.get(city.y);
        City x1 = xC == null ? null : xC.lower(city), x2 = xC == null ? null : xC.higher(city);
        City y1 = yC == null ? null : yC.lower(city), y2 = yC == null ? null : yC.higher(city);
        String curClosest = getClosest(city, x1, x2, y1, y2);
        closest.put(city.name, curClosest);
        return curClosest;
    }

    private static String getClosest(City cur, City... city) {
        String result = null;
        long dist = Long.MAX_VALUE;
//        Loop through all the x & y coordinates.
        for (City dest : city) {
            if (dest == null) continue;
            long curDist = getDistance(cur, dest);
            if (curDist < dist || (curDist == dist && result != null && result.compareTo(dest.name) > 0)) {
                dist = curDist;
                result = dest.name;
            }
        }
        return result;
    }

    private static long getDistance(City a, City b) {
        return Math.abs((long) (a.x - b.x) * (a.x - b.x) + (long) (a.y - b.y) * (a.y - b.y));
    }

    static class City {
        String name;
        int x, y;

        public City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
}