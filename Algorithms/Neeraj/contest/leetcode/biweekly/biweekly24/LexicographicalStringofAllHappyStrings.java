package biweekly.biweekly24;
/*
    Created on:  Apr 18, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Questions:
 */
public class LexicographicalStringofAllHappyStrings {
    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
        System.out.println(getHappyString(1,4));
        System.out.println(getHappyString(3,9));
        System.out.println(getHappyString(2,7));
        System.out.println(getHappyString(10,100));
    }
    static List<Character> list = Arrays.asList('a','b','c');
    static List<String> op;
    public static String getHappyString(int n, int k) {
        op = new ArrayList<>();
        populateHappyString("A",n,k);
        populateHappyString("B",n,k);
        populateHappyString("C",n,k);
        return op.size() >= k ? op.get(k-1) : "";
    }

    private static void populateHappyString(String input, int n, int k) {
        if(op.size() == k) return;
        if(input.length() == n) {
            op.add(input);
            return;
        }
        char pre = input.charAt(input.length()-1);
        for(char c: list){
            if(c != pre){
                populateHappyString(input+c,n,k);
            }
        }
    }
}
