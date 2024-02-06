import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 24, 2024
 * Ref:
 * In this problem, you have to implement the int findFirstUnique(int[] arr) method that will look for a first unique integer, which appears only once in the whole array. The function returns -1 if no unique number is found.
 *
 * Method Prototype
 * int findFirstUnique(int[] arr)
 * Output
 * The first unique element in the array.
 *
 * Sample Input
 * arr = {9, 2, 3, 2, 6, 6}
 * Sample Output
 * 9
 */

public class CheckFirstUnique {

    public static void main(String[] args) {

    }

    public static int findFirstUnique(int[] arr){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst().orElse(-1);
    }

}
