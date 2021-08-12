import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 11, 2021
 * Ref : https://leetcode.com/problems/array-of-doubled-pairs
 */
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {

    }
    /*
    r = 2 * l
    nums[2*i+1] = 2 * nums[2*i]

    i=0, l = 0, r = 1
    i=1, l = 2, r = 3
    i=2, l = 4, r = 5
    i=3, l = 6, r = 7
    i=4, l = 8, r = 9
    i=5, l = 10,r = 11
*/
    public boolean canReorderDoubled(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int cur: arr){
            long left = cur /2, right = cur *2;
            if(left * 2 == cur && map.getOrDefault(left, 0) > 0){
                int count = map.remove(left);
                if(count > 1) map.put(left, count-1);
            }else if(map.getOrDefault(right, 0) > 0){
                int count = map.remove(right);
                if(count > 1) map.put(right, count-1);
            }else{
                long curLong = cur;
                map.put(curLong, map.getOrDefault(curLong, 0)+1);
            }
        }
        // System.out.println(map);
        return map.isEmpty();
    }
}
