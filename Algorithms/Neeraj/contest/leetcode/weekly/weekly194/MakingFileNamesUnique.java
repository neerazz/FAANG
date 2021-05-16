package weekly.weekly194;

import java.util.*;

/**
 * Created on:  Jun 20, 2020
 * Questions: https://leetcode.com/problems/making-file-names-unique/
 */
public class MakingFileNamesUnique {
    public static void main(String[] args) {
        System.out.println("**************************** Solution 1 *********************************");
        System.out.println(Arrays.toString(getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"wano", "wano", "wano", "wano"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"h", "i", "e(3)", "m(2)(3)", "b", "j", "g", "g(1)(2)", "k(4)", "f", "m(3)(1)", "w", "s", "y", "j(4)", "e(4)(3)", "r", "t(4)", "k", "y", "a(4)(2)", "x(4)", "r", "n(2)(2)", "j", "q(2)(2)", "q(3)", "f", "j", "j", "g(2)(4)", "h(3)", "z(1)", "n(1)", "n", "q"})));

        System.out.println("**************************** Solution 2 *********************************");
        System.out.println(Arrays.toString(getFolderNames_option2(new String[]{"gta", "gta(1)", "gta", "avalon"})));
        System.out.println(Arrays.toString(getFolderNames_option2(new String[]{"wano", "wano", "wano", "wano"})));
        System.out.println(Arrays.toString(getFolderNames_option2(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"})));
        System.out.println(Arrays.toString(getFolderNames_option2(new String[]{"h", "i", "e(3)", "m(2)(3)", "b", "j", "g", "g(1)(2)", "k(4)", "f", "m(3)(1)", "w", "s", "y", "j(4)", "e(4)(3)", "r", "t(4)", "k", "y", "a(4)(2)", "x(4)", "r", "n(2)(2)", "j", "q(2)(2)", "q(3)", "f", "j", "j", "g(2)(4)", "h(3)", "z(1)", "n(1)", "n", "q"})));
    }

    public static String[] getFolderNames_option2(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            names[i] = getName(map, names[i]);
        }
        return names;
    }

    private static String getName(Map<String, Integer> map, String name) {
        if (map.containsKey(name)) {
//            If found then keep incrementing the previous count and add the value at the end.
            int n = map.get(name);
            while (map.containsKey(name + "(" + n + ")")) {
                n++;
            }
            map.put(name, n);
//            Make a recursive call to check if there is any file with name(n), exists, if so update teh values.
            name = getName(map, name + "(" + n + ")");
        } else {
            map.put(name, 1);
        }
        return name;
    }

    public static String[] getFolderNames(String[] names) {
        int len = names.length;
        Set<String> taken = new HashSet<>();
        for (int i = 0; i < len; i++) {
            String cur = names[i];
            if (taken.contains(cur)) {
//                Find the new name.
                cur = getNewName(cur, taken, i);
            }
            names[i] = cur;
            taken.add(cur);
        }
        return names;
    }

    private static String getNewName(String cur, Set<String> taken, int max) {
        for (int i = 1; i < 2 * max; i++) {
            String val = cur + "(" + i + ")";
            if (!taken.contains(val)) {
                return val;
            }
        }
        return null;
    }
}
