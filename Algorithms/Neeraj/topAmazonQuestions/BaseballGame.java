import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/baseball-game/
 */

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public static int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String cur : ops) {
            if (cur.equals("+")) {
                int size = list.size();
                list.add(list.get(size - 1) + list.get(size - 2));
            } else if (cur.equals("D")) {
                list.add(2 * list.get(list.size() - 1));
            } else if (cur.equals("C")) {
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
