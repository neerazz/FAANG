package weekly.weekly182;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public static void main(String[] args) {

    }

    public static int findLucky(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
//        return map.entrySet().stream().filter(e -> e.getKey().equals(e.getValue())).map(e->e.getKey())
//                .sorted((v1,v2) -> v2-v1).limit(1).findAny().orElse(-1);
        int result =-1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                result = Math.max(entry.getKey() , result);
            }
        }
        return result;
    }
}
