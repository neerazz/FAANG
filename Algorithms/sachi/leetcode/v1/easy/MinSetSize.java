package leetcode.v1.easy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MinSetSize {

    public static void main(String[] args) {
        //int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int[] arr = {7,7,7,7,7,7};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            int count = countMap.get(value) == null ? 0 : countMap.get(value);
            countMap.put(value, ++count);
        }
        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort(Collections.reverseOrder());
        int sum = 0;
        for (int i=0; i<countList.size(); i++) {
            sum += countList.get(i);
            if(sum >= arr.length/2){
                return ++i;
            }
        }
        return 1;

    }

}
