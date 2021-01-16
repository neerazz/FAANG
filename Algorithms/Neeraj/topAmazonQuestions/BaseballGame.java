import java.util.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/baseball-game/
 */

public class BaseballGame {

    public static void main(String[] args) {
//        System.out.println(finalScore(new String[]{"5", "2", "X", "Z", "+"}) + " = 14");
//        System.out.println(finalScore(new String[]{"10", "20", "X", "+"}) + " = 130");
        System.out.println(finalScore(new String[]{"10", "20", "Z", "30", "+"}) + " = 100");
    }

    public static int finalScore(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String cur : ops) {
            if (cur.equals("+")) {
                int size = list.size();
                list.add(list.get(size - 1) + list.get(size - 2));
            } else if (cur.equals("X")) {
                list.add(2 * list.get(list.size() - 1));
            } else if (cur.equals("Z")) {
                list.removeLast();
            } else {
                list.add(Integer.parseInt(cur));
            }
        }
        int sum = 0;
        for (int num : list) sum += num;
        return sum;
    }
}
