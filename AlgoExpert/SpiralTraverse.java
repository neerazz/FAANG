import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Sep 14, 2020
 * Questions: https://www.algoexpert.io/questions/Spiral%20Traverse
 */
public class SpiralTraverse {
    public static void main(String[] args) {

    }

    public static List<Integer> spiralTraverse(int[][] array) {
        int rs = 0, re = array.length - 1, cs = 0, ce = re >= 0 ? array[0].length - 1 : 0;
        List<Integer> list = new ArrayList<>();
        while (rs <= re && cs <= ce) {

            for (int i = cs; i <= ce; i++) list.add(array[rs][i]);
            rs++;

            for (int i = rs; i <= re; i++) list.add(array[i][ce]);
            ce--;

            // if(cs < ce){
            if (rs <= re) {
                for (int i = ce; i >= cs; i--) list.add(array[re][i]);
                re--;
            }

            // if(rs < re){
            if (cs <= ce) {
                for (int i = re; i >= rs; i--) list.add(array[i][cs]);
                cs++;
            }
        }
        return list;
    }
}
