package weekly.weekly184;/*
    Created on:  Apr 11, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Questions:
 */
public class QueriesOnAPermutationWithKey {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(processQueries(new int[]{3, 1, 2, 1}, 5)));
    }
    public static int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i =1; i<=m; i++) list.add(i);
        int len = queries.length;
        int[] op = new int[len];
        for(int i=0; i<len; i++){
            int cur = queries[i], index = list.indexOf(cur);
            list.remove(index);
            op[i] = index;
            list.add(0,cur);
        }
        return op;
    }
}
