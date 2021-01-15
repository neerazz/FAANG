import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-choose-a-flask
 */

public class ChooseAFlask {

    public static void main(String[] args) {
        System.out.println(flaskType(4, new int[]{4, 6, 6, 7}, 3, 9, buildPairInt(new int[][]{{0, 3}, {0, 5}, {0, 7}, {1, 6}, {1, 8}, {1, 9}, {2, 3}, {2, 5}, {2, 6}})));
    }

    private static int flaskType(int o, int[] orders, int types, int total, List<PairInt> typeMarks) {
        int type = -1, minWaste = Integer.MAX_VALUE;
        Map<Integer, TreeSet<Integer>> marksMap = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int order : orders) {
            orderMap.put(order, orderMap.getOrDefault(order, 0) + 1);
        }
        for (PairInt mark : typeMarks) {
            marksMap.computeIfAbsent(mark.first, val -> new TreeSet<>()).add(mark.second);
        }
        for (int i = 0; i < types; i++) {
            Integer curWaste = 0, mark = 0;
            TreeSet<Integer> marks = marksMap.get(i);
            boolean processedAll = true;
            for (int curMark : orderMap.keySet()) {
                if (curMark > mark) {
                    mark = marks.ceiling(curMark);
                    if (mark == null) {
                        processedAll = false;
                        break;
                    }
                }
                curWaste += (mark - curMark) * orderMap.get(curMark);
            }
            if (curWaste < minWaste && processedAll) {
                minWaste = curWaste;
                type = i;
            }
        }
        return type;
    }

    private static List<PairInt> buildPairInt(int[][] pairs) {
        return Arrays.stream(pairs).map(pair -> new PairInt(pair[0], pair[1])).collect(Collectors.toList());
    }
}

class PairInt {
    int first, second;

    PairInt(int first, int second) {
        this.first = first;
        this.second = second;
    }
}