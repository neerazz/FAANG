package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-arraylist/problem
 */
public class JavaArraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.next());
        List<List<Integer>> list = new ArrayList<>();
//        Read all the inputs.
        for (int i = 0; i < numberOfLines; i++) {
            List<Integer> temp = new ArrayList<>();
            int valuesInLine = Integer.parseInt(sc.next());
            for (int j = 0; j < valuesInLine; j++) {
                temp.add(Integer.parseInt(sc.next()));
            }
            list.add(temp);
        }
//        Read's input that needs to be displayed.
        int numberOfOutput = Integer.parseInt(sc.next());
        for (int i = 0; i < numberOfOutput; i++) {
            int line = Integer.parseInt(sc.next());
            int position = Integer.parseInt(sc.next());
            if (line - 1 < list.size() && line > 0) {
                List<Integer> list1 = list.get(line - 1);
                if (position - 1 < list1.size() && position > 0) {
                    System.out.println(list1.get(position - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
