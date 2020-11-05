import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 04, 2020
 * Questions: https://medium.com/javascript-in-plain-english/these-coding-problems-were-asked-by-uber-4cf366d9ef9b
 * Question
 * A rule looks like this:
 * A NE B
 * This means this means point A is located northeast of point B.
 * A SW C
 * means that point A is southwest of C.
 * Given a list of rules, check if the sum of the rules validate. For example:
 * A N B
 * B NE C
 * C N A
 * does not validate, since A cannot be both north and south of C.
 * A NW B
 * A N B
 * is considered valid.
 */

public class ValidDirection {

    public static void main(String[] args) {
        System.out.println(isValid(Arrays.asList(
                Arrays.asList("A", "N", "B"),
                Arrays.asList("B", "NE", "C"),
                Arrays.asList("C", "N", "A")
        )));
        System.out.println(isValid(Arrays.asList(
                Arrays.asList("A", "NW", "B"),
                Arrays.asList("A", "N", "B")
        )));
    }

    static Map<String, int[]> dirs = new HashMap<>();

    static {
        dirs.put("N", new int[]{-1, 0});
        dirs.put("E", new int[]{0, 1});
        dirs.put("W", new int[]{-1, 0});
        dirs.put("S", new int[]{1, 0});
        dirs.put("NE", new int[]{1, 1});
        dirs.put("SE", new int[]{-1, 1});
        dirs.put("SW", new int[]{-1, -1});
        dirs.put("NW", new int[]{-1, 1});
    }

    private static boolean isValid(List<List<String>> list) {
        Map<String, int[]> map = new HashMap<>();
        for (List<String> val : list) {
            String from = val.get(0), dir = val.get(1), to = val.get(2);
            int fromX = 0, fromY = 0;
            if (map.containsKey(from)) {
//            If the direction already exists, then take that value.
                int[] vals = map.get(from);
                fromX = vals[0];
                fromY = vals[1];
            }
            map.put(from, new int[]{fromX, fromY});
            int[] curDir = dirs.get(dir);
            int toX = fromX + curDir[0], toY = fromY + curDir[1];
//            If to already exits then the value should be the calculated value.
            if (map.containsKey(to)) {
                int[] preVal = map.get(to);
                if (toX != preVal[0] && toY != preVal[1]) return false;
            } else {
                map.put(to, new int[]{toX, toY});
            }
        }
        return true;
    }
}
