package concepts.hastable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Isomorphic {

    public static void main(String[] args) {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> cM = new HashMap<>();
        List<String> places = new ArrayList<>();
        int sol = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            cM.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (cM.containsKey(list2[i])) {
                int val = i + cM.get(list2[i]);
                if (val < sol) {
                    places = new ArrayList<>();
                    places.add(list2[i]);
                    sol = val;
                } else if (val == sol) {
                    places.add(list2[i]);
                }
            }
        }
        return places.toArray(new String[0]);

    }
}
